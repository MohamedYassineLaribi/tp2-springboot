package com.isetn.laribi.laribi_project.entities;
import jakarta.persistence.*;


@Entity
public class Classification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idClassification;

    private String libelle;
    private Double score;

    // Relation ManyToOne avec Etudiant
    @ManyToOne
    @JoinColumn(name = "etudiant_id")
    private Etudiant etudiant;

    // Constructeurs
    public Classification() {}

    public Classification(String libelle, Double score) {
        this.libelle = libelle;
        this.score = score;
    }

    // Getters & Setters
    public Long getIdClassification() {
        return idClassification;
    }

    public void setIdClassification(Long idClassification) {
        this.idClassification = idClassification;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Etudiant getEtudiant() {
        return etudiant;
    }

    public void setEtudiant(Etudiant etudiant) {
        this.etudiant = etudiant;
    }
}
