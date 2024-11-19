package com.formation.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.formation.spring.entities.Cours;
import com.formation.spring.entities.Etudiant;
import com.formation.spring.services.CoursService;
import com.formation.spring.services.EtudiantService;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/cours")
public class CoursController {

    @Autowired
    private CoursService coursService;

    @Autowired
    EtudiantService etudiantService;

    @GetMapping
    public List<Cours> getAllCours() {
        return coursService.findAll();
    }

    @PostMapping
    public Cours createCours(@RequestBody Cours cours) {
        return coursService.save(cours);
    }

    @DeleteMapping("/{id}")
    public void deleteCours(@PathVariable Long id) {
        coursService.deleteById(id);
    }

    @GetMapping("/{id}/etudiants")
    public Set<Etudiant> getEtudiantsForCours(@PathVariable Long id) {
        return coursService.findById(id).getEtudiants();
    }

    @GetMapping("/communs")
    public Set<Cours> getCoursCommuns(@RequestParam Long etudiant1Id, @RequestParam Long etudiant2Id) {
        Set<Cours> cours1 = etudiantService.findById(etudiant1Id).getCours();
        Set<Cours> cours2 = etudiantService.findById(etudiant2Id).getCours();
        cours1.retainAll(cours2);
        return cours1;
    }

    @GetMapping("/popular")
    public List<Cours> getPopularCours(@RequestParam int seuil) {
        return coursService.findAll().stream()
                .filter(cours -> cours.getEtudiants().size() > seuil)
                .toList();
    }
}
