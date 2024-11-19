package com.formation.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.spring.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}

