package com.isetn.laribi.laribi_project.entities;

	import java.util.Date;
	import java.util.List;

	import jakarta.persistence.*;

	@Entity
	public class Etudiant {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long idEtudiant;

	    private String nomEtudiant;
	    private String prenomEtudiant;
	    private String classe;

	    @SuppressWarnings("deprecation")
		@Temporal(TemporalType.DATE)
	    private Date dateNaissance;

	    private String email;

	    // Relation OneToMany avec Classification
	    @OneToMany(mappedBy = "etudiant", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	    private List<Classification> classifications;

	    // Constructeurs
	    public Etudiant() {}

	    public Etudiant(String nomEtudiant, String prenomEtudiant, String classe, Date dateNaissance, String email) {
	        this.nomEtudiant = nomEtudiant;
	        this.prenomEtudiant = prenomEtudiant;
	        this.classe = classe;
	        this.dateNaissance = dateNaissance;
	        this.email = email;
	    }

	    // Getters & Setters
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

	    public String getClasse() {
	        return classe;
	    }

	    public void setClasse(String classe) {
	        this.classe = classe;
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

	    public List<Classification> getClassifications() {
	        return classifications;
	    }

	    public void setClassifications(List<Classification> classifications) {
	        this.classifications = classifications;
	    }
	}


