package com.isetn.laribi.laribi_project.entities;

import java.util.List;
import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Classe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClasse;

    private String nomClasse;

    @JsonIgnore
    @OneToMany(mappedBy = "classe", cascade = CascadeType.ALL)
    private List<Etudiant> etudiants;

    public Classe() {
    }

    public Classe(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public Long getIdClasse() {
        return idClasse;
    }

    public void setIdClasse(Long idClasse) {
        this.idClasse = idClasse;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }

    public List<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(List<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }
}
