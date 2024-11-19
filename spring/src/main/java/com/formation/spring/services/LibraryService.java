package com.formation.spring.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.spring.entities.Book;
import com.formation.spring.entities.Library;
import com.formation.spring.repositories.BookRepository;
import com.formation.spring.repositories.LibraryRepository;

import jakarta.transaction.Transactional;

@Service
public class LibraryService {

    @Autowired
    private LibraryRepository libraryRepository;

    @Autowired
    private BookRepository bookRepository;

    public Library createLibrary(Library library) {
        return libraryRepository.save(library);
    }

    public Library updateLibrary(Long id, Library newLibrary) {
        Library library = libraryRepository.findById(id).orElseThrow(() -> new RuntimeException("Lib not found"));

        library.setName(newLibrary.getName());
        library.setBooks(newLibrary.getBooks());

        return libraryRepository.save(library);
    }

    @Transactional
    public Library addBookTLibrary(Long libraryID, Long bookID) {
        Library library = libraryRepository.findById(libraryID)
                .orElseThrow(() -> new RuntimeException("Lib not found"));
        Book book = bookRepository.findById(bookID).orElseThrow(() -> new RuntimeException("Book not found"));

        library.getBooks().add(book);
        book.getLibraries().add(library);

        bookRepository.save(book);
        return libraryRepository.save(library);
    }

    @Transactional
    public Library removeBookFromLibrary(Long libraryID, Long bookID) {
        Library library = libraryRepository.findById(libraryID)
                .orElseThrow(() -> new RuntimeException("Lib not found"));
        Book book = bookRepository.findById(bookID).orElseThrow(() -> new RuntimeException("Book not found"));

        if(library.getBooks().contains(book) && book.getLibraries().contains(library)){
            library.getBooks().remove(book);
            book.getLibraries().remove(library);
            bookRepository.save(book);
            return libraryRepository.save(library);
        } else {
           throw new RuntimeException("Book not related to this library");
        }
    }

    public List<Library> getAllLibraries() {
        return libraryRepository.findAll();
    }

}
