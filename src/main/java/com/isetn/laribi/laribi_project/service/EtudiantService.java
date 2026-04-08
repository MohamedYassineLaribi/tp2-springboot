package com.isetn.laribi.laribi_project.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.isetn.laribi.laribi_project.dto.EtudiantDTO;
import com.isetn.laribi.laribi_project.entities.Etudiant;
import com.isetn.laribi.laribi_project.entities.Classe;

public interface EtudiantService {
	EtudiantDTO saveEtudiant(Etudiant e);
	Etudiant saveEtudiantEntity(Etudiant e);

	EtudiantDTO updateEtudiant(EtudiantDTO dto);
	Etudiant updateEtudiantEntity(Etudiant e);

	void deleteEtudiant(Etudiant e);

	void deleteEtudiantById(Long id);

	Etudiant getEtudiant(Long id);

	List<Etudiant> getAllEtudiants();

	Page<Etudiant> getAllEtudiantsParPage(int page, int size);

	List<Etudiant> findByNomEtudiant(String nom);

	List<Etudiant> findByNomEtudiantContains(String nom);

	List<Etudiant> findByNomPrenom(String nom, String prenom);

	List<Etudiant> findByClasse(Classe classe);

	List<Etudiant> findByClasseIdClasse(Long id);

	List<Etudiant> findByOrderByNomEtudiantAsc();

	List<Etudiant> trierEtudiantsNomsPrenom();

	List<Etudiant> findEtudiantByClasse(String nomClasse);

	// ---- DTO Pattern ----
	EtudiantDTO convertEntityToDto(Etudiant etudiant);

	Etudiant convertDtoToEntity(EtudiantDTO dto);

	List<EtudiantDTO> getAllEtudiantsDTO();
}
