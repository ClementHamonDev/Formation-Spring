package com.formation.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.formation.spring.entities.Library;

@Repository
public interface LibraryRepository extends JpaRepository<Library, Long>{
    
}