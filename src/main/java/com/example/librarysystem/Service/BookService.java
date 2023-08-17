package com.example.librarysystem.Service;

import com.example.librarysystem.Api.ApiException;
import com.example.librarysystem.Model.Book;
import com.example.librarysystem.Repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor

public class BookService {

    private final BookRepository bookRepository;


    public List<Book> getAll(){
        return bookRepository.findAll();
    }

    public void addBook(Book coffee){
        bookRepository.save(coffee);

    }

    public void updateBook(Integer id, Book book) {
        Book book1 = bookRepository.findBookById(id);

        if (book1 == null) {
            throw new ApiException("not found");
        }
        book1.setTitle(book.getTitle());
        book1.setCategory(book.getCategory());
        book1.setAuthor(book.getAuthor());
        book1.setISBN(book.getISBN());
        book1.setNumberOfPages(book.getNumberOfPages());
        bookRepository.save(book1);
    }

    public void deleteBook(Integer id){
        Book book = bookRepository.findBookById(id);
        if (book == null) {
            throw new ApiException("not found");
        }
        bookRepository.delete(book);

    }

    public Book getBookByAuthor(String author) {
        Book book = bookRepository.findBookByAuthor(author);

        if (book == null) {
            throw new ApiException("not found");
        }
        return book;
    }

    public Book getBookByTitle(String title) {
        Book book = bookRepository.findBookByTitle(title);

        if (book == null) {
            throw new ApiException("not found");
        }
        return book;
    }

    public List<Book> getByCategory(String category){

        List<Book> books = bookRepository.findBookByCategory(category);
        if (books.isEmpty()) {
            throw new ApiException("not found");
        }
        return books;
    }

    public List<Book> getBookByNumberOfPage() {

        List<Book> books = bookRepository.findBookByNumberOfPagesGreaterThan(300);
        if (books.isEmpty()) {
            throw new ApiException("not found");
        }
        return books;
    }
}


