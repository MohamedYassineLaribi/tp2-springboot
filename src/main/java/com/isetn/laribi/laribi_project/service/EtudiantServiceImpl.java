package com.isetn.laribi.laribi_project.service;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.isetn.laribi.laribi_project.dto.EtudiantDTO;
import com.isetn.laribi.laribi_project.entities.Classe;
import com.isetn.laribi.laribi_project.entities.Etudiant;
import com.isetn.laribi.laribi_project.repos.EtudiantRepository;

@Service
public class EtudiantServiceImpl implements EtudiantService {

	@Autowired
	private EtudiantRepository etudiantRepository;

	@Autowired
	private ModelMapper modelMapper;

	// ---- DTO conversion (ModelMapper with LOOSE strategy for nomClasse) ----

	@Override
	public EtudiantDTO convertEntityToDto(Etudiant etudiant) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper.map(etudiant, EtudiantDTO.class);
	}

	@Override
	public Etudiant convertDtoToEntity(EtudiantDTO dto) {
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
		return modelMapper.map(dto, Etudiant.class);
	}

	@Override
	public List<EtudiantDTO> getAllEtudiantsDTO() {
		return etudiantRepository.findAll().stream()
				.map(this::convertEntityToDto)
				.collect(Collectors.toList());
	}

	// ---- CRUD ----

	@Override
	public EtudiantDTO saveEtudiant(Etudiant e) {
		if (e == null) return null;
		return convertEntityToDto(etudiantRepository.save(e));
	}

	@Override
	public EtudiantDTO updateEtudiant(EtudiantDTO dto) {
		if (dto == null) return null;
		Etudiant e = convertDtoToEntity(dto);
		return convertEntityToDto(etudiantRepository.save(e));
	}

	@Override
	public void deleteEtudiant(Etudiant e) {
		if (e == null) return;
		etudiantRepository.delete(e);
	}

	@Override
	public void deleteEtudiantById(Long id) {
		if (id == null) return;
		etudiantRepository.deleteById(id);
	}

	@Override
	public Etudiant getEtudiant(Long id) {
		if (id == null) return null;
		return etudiantRepository.findById(id).orElse(null);
	}

	@Override
	public List<Etudiant> getAllEtudiants() {
		return etudiantRepository.findAll();
	}

	@Override
	public Page<Etudiant> getAllEtudiantsParPage(int page, int size) {
		return etudiantRepository.findAll(PageRequest.of(page, size));
	}

	@Override
	public List<Etudiant> findByNomEtudiant(String nom) {
		return etudiantRepository.findByNomEtudiant(nom);
	}

	@Override
	public List<Etudiant> findByNomEtudiantContains(String nom) {
		return etudiantRepository.findByNomEtudiantContains(nom);
	}

	@Override
	public List<Etudiant> findByNomPrenom(String nom, String prenom) {
		return etudiantRepository.findByNomPrenom(nom, prenom);
	}

	@Override
	public List<Etudiant> findByClasse(Classe classe) {
		return etudiantRepository.findByClasse(classe);
	}

	@Override
	public List<Etudiant> findByClasseIdClasse(Long id) {
		return etudiantRepository.findByClasseIdClasse(id);
	}

	@Override
	public List<Etudiant> findByOrderByNomEtudiantAsc() {
		return etudiantRepository.findByOrderByNomEtudiantAsc();
	}

	@Override
	public List<Etudiant> trierEtudiantsNomsPrenom() {
		return etudiantRepository.trierEtudiantsNomsPrenom();
	}

	@Override
	public List<Etudiant> findEtudiantByClasse(String nomClasse) {
		return etudiantRepository.findEtudiantByClasse(nomClasse);
	}
}
