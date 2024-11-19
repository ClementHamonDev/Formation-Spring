package com.formation.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.formation.spring.entities.Cours;
import com.formation.spring.repositories.CoursRepository;

import java.util.List;

@Service
public class CoursService {

    @Autowired
    private CoursRepository coursRepository;

    public List<Cours> findAll() {
        return coursRepository.findAll();
    }

    public Cours findById(Long id) {
        return coursRepository.findById(id).orElse(null);
    }

    public Cours save(Cours cours) {
        return coursRepository.save(cours);
    }

    public void deleteById(Long id) {
        coursRepository.deleteById(id);
    }
}
