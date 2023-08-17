package com.example.librarysystem.Controller;

import com.example.librarysystem.Api.ApiResponse;
import com.example.librarysystem.Model.Book;
import com.example.librarysystem.Model.Librarian;
import com.example.librarysystem.Service.BookService;
import com.example.librarysystem.Service.LibrarianService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/vi/librarian")
@RequiredArgsConstructor
public class LibrarianController {


    final private LibrarianService librarianService;

    @GetMapping("/get")
    public ResponseEntity getAll(){
        return ResponseEntity.status(200).body(librarianService.getAll());
    }

    @PostMapping("/add")
    public ResponseEntity addCoffee(@RequestBody @Valid Librarian librarian){
        librarianService.addLibrarian(librarian);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity updateLibrarian(@PathVariable Integer id, @RequestBody @Valid Librarian librarian ){
        librarianService.updateLibrarian(id, librarian);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteLibrarian( @PathVariable Integer id){
        librarianService.deleteBook(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }


    @GetMapping("/search/{id}")
    public ResponseEntity searchById(@PathVariable Integer id){
        return ResponseEntity.status(200).body( librarianService.getLibrarianById(id));
    }

    @GetMapping("/search/{email}/{password")
    public ResponseEntity searchByEmailAndPassword(@PathVariable String email,@PathVariable String password){
        return ResponseEntity.status(200).body( librarianService.getLibrarianByemailAndPassword(email, password));
    }

    @GetMapping("/search/{email}")
    public ResponseEntity searchByEmail(@PathVariable String email){
        return ResponseEntity.status(200).body( librarianService.getLibrarianByemail(email));
    }


}
