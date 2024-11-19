package com.formation.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.formation.spring.entities.Cours;

public interface CoursRepository extends JpaRepository<Cours, Long> {
}
