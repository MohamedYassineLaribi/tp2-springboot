package com.isetn.laribi.laribi_project.dto;

import java.util.Date;

public class EtudiantDTO {
    private Long idEtudiant;
    private String nomEtudiant;
    private String prenomEtudiant;
    private Date dateNaissance;
    private String email;
    // Nom de la classe (au lieu d'envoyer tout l'objet Classe)
    private String nomClasse;

    public EtudiantDTO() {
    }

    public EtudiantDTO(Long idEtudiant, String nomEtudiant, String prenomEtudiant, Date dateNaissance, String email, String nomClasse) {
        this.idEtudiant = idEtudiant;
        this.nomEtudiant = nomEtudiant;
        this.prenomEtudiant = prenomEtudiant;
        this.dateNaissance = dateNaissance;
        this.email = email;
        this.nomClasse = nomClasse;
    }

    public Long getIdEtudiant() {
        return idEtudiant;
    }

    public void setIdEtudiant(Long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }

    public String getNomEtudiant() {
        return nomEtudiant;
    }

    public void setNomEtudiant(String nomEtudiant) {
        this.nomEtudiant = nomEtudiant;
    }

    public String getPrenomEtudiant() {
        return prenomEtudiant;
    }

    public void setPrenomEtudiant(String prenomEtudiant) {
        this.prenomEtudiant = prenomEtudiant;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNomClasse() {
        return nomClasse;
    }

    public void setNomClasse(String nomClasse) {
        this.nomClasse = nomClasse;
    }
}
