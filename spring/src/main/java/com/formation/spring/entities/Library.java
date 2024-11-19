package com.formation.spring.entities;

import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Library {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ManyToMany(mappedBy = "libraries")
    @JsonIgnoreProperties("libraries")
    private Set<Book> books = new HashSet<>();

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Set<Book> getBooks(){
        return this.books;
    }

    public void setBooks(Set<Book> books){
        this.books = books;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
