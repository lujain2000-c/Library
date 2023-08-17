package com.example.librarysystem.Controller;

import com.example.librarysystem.Api.ApiResponse;
import com.example.librarysystem.Model.Book;
import com.example.librarysystem.Service.BookService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vi/book")
@RequiredArgsConstructor
public class BookController {

    final private BookService bookServise;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(bookServise.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addCoffee(@RequestBody @Valid Book book){
        bookServise.addBook(book);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateCoffee(@PathVariable Integer id, @RequestBody @Valid Book book ){
        bookServise.updateBook(id, book);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteCoffee( @PathVariable Integer id){
        bookServise.deleteBook(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }


    @GetMapping("/search/{title}")
    public ResponseEntity searchByTitle(@PathVariable String title){
        return ResponseEntity.status(200).body( bookServise.getBookByTitle(title));
    }

    @GetMapping("/search/{author}")
    public ResponseEntity searchByAuthor(@PathVariable String author){
        return ResponseEntity.status(200).body( bookServise.getBookByAuthor(author));
    }

    @GetMapping("/search/{category}")
    public ResponseEntity searchByCategoty(@PathVariable String category){
        return ResponseEntity.status(200).body( bookServise.getByCategory(category));
    }

}
