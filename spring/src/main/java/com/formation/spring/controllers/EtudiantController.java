package com.formation.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.formation.spring.entities.Cours;
import com.formation.spring.entities.Etudiant;
import com.formation.spring.services.EtudiantService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/etudiants")
public class EtudiantController {

    @Autowired
    private EtudiantService etudiantService;

    @GetMapping
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.findAll();
    }

    @PostMapping
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.save(etudiant);
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteById(id);
    }

    @GetMapping("/{id}/cours")
    public Set<Cours> getCoursForEtudiant(@PathVariable Long id) {
        return etudiantService.findById(id).getCours();
    }
}
