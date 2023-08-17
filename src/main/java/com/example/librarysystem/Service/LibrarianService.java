package com.example.librarysystem.Service;

import com.example.librarysystem.Api.ApiException;
import com.example.librarysystem.Model.Book;
import com.example.librarysystem.Model.Librarian;
import com.example.librarysystem.Repository.BookRepository;
import com.example.librarysystem.Repository.LibrarianRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LibrarianService {

    private final LibrarianRepository librarianRepository;


    public List<Librarian> getAll(){
        return librarianRepository.findAll();
    }

    public void addLibrarian(Librarian librarian){
        librarianRepository.save(librarian);

    }

    public void updateLibrarian(Integer id, Librarian librarian) {
        Librarian librarian1 = librarianRepository.findLibrarianById(id);

        if (librarian1 == null) {
            throw new ApiException("not found");
        }
        librarian1.setName(librarian.getName());
        librarian1.setUsername(librarian.getUsername());
        librarian1.setPassword(librarian.getPassword());
        librarian1.setEmail(librarian.getEmail());

        librarianRepository.save(librarian1);
    }

    public void deleteBook(Integer id){
        Librarian librarian = librarianRepository.findLibrarianById(id);
        if (librarian == null) {
            throw new ApiException("not found");
        }
        librarianRepository.delete(librarian);

    }

    public Librarian getLibrarianById(Integer id) {
        Librarian librarian = librarianRepository.findLibrarianById(id);

        if (librarian == null) {
            throw new ApiException("not found");
        }
        return librarian;
    }

    public Librarian getLibrarianByemail(String email) {
        Librarian librarian = librarianRepository.findLibrarianByEmail(email);

        if (librarian == null) {
            throw new ApiException("not found");
        }
        return librarian;
    }
    public Librarian getLibrarianByemailAndPassword(String email, String password) {
        Librarian librarian = librarianRepository.findAllByEmailAndPassword(email,password);

        if (librarian == null) {
            throw new ApiException("not found");
        }
        return librarian;
    }

}
