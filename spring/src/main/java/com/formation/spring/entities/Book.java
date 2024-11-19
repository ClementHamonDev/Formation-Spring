package com.formation.spring.entities;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private Integer price;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "detail_id", referencedColumnName = "id", nullable = false)
    private BookDetails bookDetails;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(nullable = true)
    private List<Review> reviews;

    @ManyToMany
    @JoinTable(name = "book_library", joinColumns = @JoinColumn(name = "book_id"), inverseJoinColumns = @JoinColumn(name = "library_id"))
    @JsonIgnoreProperties("books")
    private Set<Library> libraries = new HashSet<>();

    public Book() {
    }

    public Book(String name, String author, Integer price, BookDetails bookDetails) {
        this.name = name;
        this.author = author;
        this.price = price;
        this.bookDetails = bookDetails;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAuthor() {
        return author;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public void setAuthor(String newAuthor) {
        this.author = newAuthor;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public BookDetails getDetails() {
        return bookDetails;
    }

    public void setBookDetails(BookDetails details) {
        this.bookDetails = details;
    }

    public List<Review> getReviews() {
        return this.reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public Set<Library> getLibraries() {
        return this.libraries;
    }

    public void setLibrairies(Set<Library> libraries) {
        this.libraries = libraries;
    }

}
