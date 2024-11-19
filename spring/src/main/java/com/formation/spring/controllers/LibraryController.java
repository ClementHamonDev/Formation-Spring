package com.formation.spring.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formation.spring.entities.Library;
import com.formation.spring.services.LibraryService;

@RestController
@RequestMapping("/api/libraries")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping
    public List<Library> getAllLibraries() {
        return libraryService.getAllLibraries();
    }

    @PostMapping("/addBook/{libraryID}/{bookID}")
    public Library addBookToLibrary(@PathVariable Long libraryID, @PathVariable Long bookID) {
        Library updatedLibrary = libraryService.addBookTLibrary(libraryID, bookID);
        return updatedLibrary;
    }

    @PostMapping("/removeBook/{libraryID}/{bookID}")
    public Library removeBookFromLibrary(@PathVariable Long libraryID, @PathVariable Long bookID) {
        Library updatedLibrary = libraryService.removeBookFromLibrary(libraryID, bookID);
        return updatedLibrary;
    }

}
