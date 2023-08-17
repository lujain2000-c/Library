package com.example.librarysystem.Repository;

import com.example.librarysystem.Model.Book;
import com.example.librarysystem.Model.Librarian;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibrarianRepository extends JpaRepository<Librarian,Integer> {

    Librarian findLibrarianById(Integer id);
    Librarian findLibrarianByEmail(String email);
    Librarian findAllByEmailAndPassword(String email,String password);

}
