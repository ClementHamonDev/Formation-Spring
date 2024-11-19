package com.formation.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.formation.spring.entities.Book;
import com.formation.spring.entities.BookDetails;
import com.formation.spring.entities.Library;
import com.formation.spring.repositories.BookRepository;
import com.formation.spring.repositories.LibraryRepository;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("Hello world");
	}

	// @Bean
	// public CommandLineRunner demo(BookRepository bookRepository, LibraryRepository libraryRepository) {
	// 	return (args) -> {
	// 		BookDetails bookDetails1 = new BookDetails();
	// 		bookDetails1.setPageCount(300);
	// 		bookDetails1.setPublisher("Publisher A");

	// 		Book book1 = new Book("Book Title 1", "Author A", 10, bookDetails1);

	// 		BookDetails bookDetails2 = new BookDetails();
	// 		bookDetails2.setPageCount(450);
	// 		bookDetails2.setPublisher("Publisher B");

	// 		Book book2 = new Book("Book Title 2", "Author B", 15, bookDetails2);

	// 		Library library = new Library();
	// 		library.setName("Central Library");

	// 		library.getBooks().add(book1);
	// 		library.getBooks().add(book2);

	// 		book1.getLibraries().add(library);
	// 		book2.getLibraries().add(library);

	// 		// Sauvegarder la bibliothèque
	// 		libraryRepository.save(library);
	// 		bookRepository.save(book1);
	// 		bookRepository.save(book2);

	// 		// Afficher les résultats
	// 		System.out.println("Books in library:");
	// 		library.getBooks().forEach(book -> System.out.println(book.getName()));

	// 		System.out.println("Libraries for book1:");
	// 		book1.getLibraries().forEach(lib -> System.out.println(lib.getName()));
	// 	};
	// }

}
