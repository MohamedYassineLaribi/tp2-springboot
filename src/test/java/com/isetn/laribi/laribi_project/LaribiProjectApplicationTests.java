package com.isetn.laribi.laribi_project;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.isetn.laribi.laribi_project.entities.Classe;
import com.isetn.laribi.laribi_project.entities.Etudiant;
import com.isetn.laribi.laribi_project.repos.EtudiantRepository;

@SpringBootTest
class LaribiProjectApplicationTests {

	@Autowired
	private EtudiantRepository etudiantRepository;

	@Test
	void contextLoads() {
	}

	@Test
	public void testFindByNomEtudiant() {
		List<Etudiant> etudiants = etudiantRepository.findByNomEtudiant("Ben ali");
		System.out.println("=== findByNomEtudiant ===");
		for (Etudiant e : etudiants) {
			System.out.println(e);
		}
	}

	@Test
	public void testFindByNomEtudiantContains() {
		List<Etudiant> etudiants = etudiantRepository.findByNomEtudiantContains("al");
		System.out.println("=== findByNomEtudiantContains ===");
		for (Etudiant e : etudiants) {
			System.out.println(e);
		}
	}

	@Test
	public void testFindByNomPrenom() {
		List<Etudiant> etudiants = etudiantRepository.findByNomPrenom("ben salem", "amine");
		System.out.println("=== findByNomPrenom ===");
		for (Etudiant e : etudiants) {
			System.out.println(e);
		}
	}

	@Test
	public void testFindByClasse() {
		Classe c = new Classe();
		c.setIdClasse(1L);
		List<Etudiant> etudiants = etudiantRepository.findByClasse(c);
		System.out.println("=== findByClasse ===");
		for (Etudiant e : etudiants) {
			System.out.println(e);
		}
	}

	@Test
	public void testFindByClasseIdClasse() {
		List<Etudiant> etudiants = etudiantRepository.findByClasseIdClasse(1L);
		System.out.println("=== findByClasseIdClasse(1) ===");
		for (Etudiant e : etudiants) {
			System.out.println(e);
		}
	}

	@Test
	public void testFindByOrderByNomEtudiantAsc() {
		List<Etudiant> etudiants = etudiantRepository.findByOrderByNomEtudiantAsc();
		System.out.println("=== findByOrderByNomEtudiantAsc() ===");
		for (Etudiant e : etudiants) {
			System.out.println(e);
		}
	}

	@Test
	public void testTrierEtudiantsNomsPrenom() {
		List<Etudiant> etudiants = etudiantRepository.trierEtudiantsNomsPrenom();
		System.out.println("=== trierEtudiantsNomsPrenom() ===");
		for (Etudiant e : etudiants) {
			System.out.println(e);
		}
	}

	@Test
	public void testFindEtudiantByClasse() {
		List<Etudiant> etudiants = etudiantRepository.findEtudiantByClasse("DSI23");
		System.out.println("=== findEtudiantByClasse('DSI23') ===");
		for (Etudiant e : etudiants) {
			System.out.println(e);
		}
	}

	@Test
	public void testGetAllEtudiants() {
		List<Etudiant> etudiants = etudiantRepository.findAll();
		System.out.println("=== findAll() ===");
		for (Etudiant e : etudiants) {
			System.out.println(e);
		}
	}
}
