package com.isetn.laribi.laribi_project.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.isetn.laribi.laribi_project.entities.Etudiant;

public interface EtudiantService {
	Etudiant saveEtudiant(Etudiant e);

	Etudiant updateEtudiant(Etudiant e);

	void deleteEtudiant(Etudiant e);

	void deleteEtudiantById(Long id);

	Etudiant getEtudiant(Long id);

	List<Etudiant> getAllEtudiants();

	Page<Etudiant> getAllEtudiantsParPage(int page, int size);
}
