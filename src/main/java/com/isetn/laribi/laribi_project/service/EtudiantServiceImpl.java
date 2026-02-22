package com.isetn.laribi.laribi_project.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.isetn.laribi.laribi_project.entities.Etudiant;
import com.isetn.laribi.laribi_project.repos.EtudiantRepository;

@Service
public class EtudiantServiceImpl implements EtudiantService {
	@Autowired
	private EtudiantRepository etudiantRepository;

	@Override
	public Etudiant saveEtudiant(Etudiant e) {
		return etudiantRepository.save(e);
	}

	@Override
	public Etudiant updateEtudiant(Etudiant e) {
		return etudiantRepository.save(e);
	}

	@Override
	public void deleteEtudiant(Etudiant e) {
		etudiantRepository.deleteById(e.getIdEtudiant());
	}

	@Override
	public void deleteEtudiantById(Long id) {
		etudiantRepository.deleteById(id);
	}

	@Override
	public Etudiant getEtudiant(Long id) {
		return etudiantRepository.findById(id).get();
	}

	@Override
	public List<Etudiant> getAllEtudiants() {
		return etudiantRepository.findAll();
	}

	@Override
	public Page<Etudiant> getAllEtudiantsParPage(int page, int size) {
		return etudiantRepository.findAll(PageRequest.of(page, size));
	}
}
