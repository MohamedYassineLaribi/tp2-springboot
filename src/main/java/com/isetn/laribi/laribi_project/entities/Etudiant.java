package com.isetn.laribi.laribi_project.entities;

import java.util.Date;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Etudiant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idEtudiant;

	@NotBlank(message = "Le nom est obligatoire")
	@Size(min = 2, max = 30, message = "Le nom doit contenir entre 2 et 30 caractères")
	private String nomEtudiant;

	@NotBlank(message = "Le prénom est obligatoire")
	@Size(min = 2, max = 30, message = "Le prénom doit contenir entre 2 et 30 caractères")
	private String prenomEtudiant;

	@ManyToOne
	@JoinColumn(name = "idClasse")
	private Classe classe;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@Past(message = "La date de naissance doit être dans le passé")
	private Date dateNaissance;

	@NotBlank(message = "L'email est obligatoire")
	@Email(message = "L'email n'est pas valide")
	private String email;

	// Constructeur par défaut
	public Etudiant() {
		this.classe = new Classe();
	}

	// Constructeur avec paramètres
	public Etudiant(String nomEtudiant, String prenomEtudiant, Classe classe, Date dateNaissance, String email) {
		this.nomEtudiant = nomEtudiant;
		this.prenomEtudiant = prenomEtudiant;
		this.classe = classe;
		this.dateNaissance = dateNaissance;
		this.email = email;
	}

	// Getters et Setters
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

	public Classe getClasse() {
		return classe;
	}

	public void setClasse(Classe classe) {
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

	@Override
	public String toString() {
		return "Etudiant [idEtudiant=" + idEtudiant + ", nomEtudiant=" + nomEtudiant + ", prenomEtudiant=" 
				+ prenomEtudiant + ", email=" + email + "]";
	}
}
