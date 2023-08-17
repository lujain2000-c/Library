package com.example.librarysystem.Repository;

import com.example.librarysystem.Model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    Book findBookById(Integer id);
    Book findBookByAuthor(String author);
    Book findBookByTitle(String title);
    List<Book> findBookByNumberOfPagesGreaterThan(Integer NumberOfPages);
    List<Book> findBookByCategory(String category);
}
