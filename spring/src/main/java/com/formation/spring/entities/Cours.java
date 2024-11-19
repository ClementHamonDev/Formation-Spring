package com.formation.spring.entities;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Cours {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "matiere")
    private String matiere;

    @Column(name = "horaire_debut")
    private LocalTime horaireDebut;

    @Column(name = "horaire_fin")
    private LocalTime horaireFin;

    @ManyToMany
    @JoinTable(
        name = "etudiant_cours",
        joinColumns = @JoinColumn(name = "cours_id"),
        inverseJoinColumns = @JoinColumn(name = "etudiant_id")
    )
    private Set<Etudiant> etudiants = new HashSet<>();

    public Cours() {
    }

    public Cours(String matiere, LocalTime horaireDebut, LocalTime horaireFin) {
        this.matiere = matiere;
        this.horaireDebut = horaireDebut;
        this.horaireFin = horaireFin;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMatiere() {
        return matiere;
    }

    public void setMatiere(String matiere) {
        this.matiere = matiere;
    }

    public LocalTime getHoraireDebut() {
        return horaireDebut;
    }

    public void setHoraireDebut(LocalTime horaireDebut) {
        this.horaireDebut = horaireDebut;
    }

    public LocalTime getHoraireFin() {
        return horaireFin;
    }

    public void setHoraireFin(LocalTime horaireFin) {
        this.horaireFin = horaireFin;
    }

    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
}
