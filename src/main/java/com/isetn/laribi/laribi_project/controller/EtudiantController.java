package com.isetn.laribi.laribi_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import java.util.List;
import com.isetn.laribi.laribi_project.entities.Etudiant;
import com.isetn.laribi.laribi_project.entities.Classe;
import com.isetn.laribi.laribi_project.service.EtudiantService;
import com.isetn.laribi.laribi_project.service.ClasseService;

@Controller
public class EtudiantController {

	@Autowired
	private EtudiantService etudiantService;

	@GetMapping("/")
	public String welcome() {
		return "index";
	}

	@Autowired
	private ClasseService classeService;

	// --- Afficher le formulaire de création ---
	@GetMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		List<Classe> classes = classeService.getAllClasses();
		modelMap.addAttribute("etudiant", new Etudiant());
		modelMap.addAttribute("classes", classes);
		modelMap.addAttribute("mode", "new");
		return "formEtudiant";
	}

	// --- Sauvegarder (ajout ou modification) avec validation ---
	@PostMapping("/saveEtudiant")
	public String saveEtudiant(@Valid @ModelAttribute("etudiant") Etudiant etudiant,
			BindingResult bindingResult,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "2") int size,
			ModelMap modelMap) {

		if (bindingResult.hasErrors()) {
			modelMap.addAttribute("classes", classeService.getAllClasses());
			modelMap.addAttribute("mode", etudiant.getIdEtudiant() == null ? "new" : "edit");
			return "formEtudiant";
		}

		// Récupérer la classe persistante pour éviter le TransientObjectException
		if (etudiant.getClasse() != null && etudiant.getClasse().getIdClasse() != null) {
			Classe c = classeService.getClasse(etudiant.getClasse().getIdClasse());
			etudiant.setClasse(c);
		} else {
			etudiant.setClasse(null);
		}

		boolean isNew = (etudiant.getIdEtudiant() == null);
		// saveEtudiant returns an EtudiantDTO (DTO pattern), result unused for redirect
		etudiantService.saveEtudiant(etudiant);

		int currentPage;
		if (isNew) {
			Page<Etudiant> etuds = etudiantService.getAllEtudiantsParPage(page, size);
			currentPage = etuds.getTotalPages() - 1;
		} else {
			currentPage = page;
		}

		return "redirect:/ListeEtudiants?page=" + currentPage + "&size=" + size;
	}

	// --- Liste paginée ---
	@GetMapping("/ListeEtudiants")
	public String listeEtudiants(ModelMap modelMap,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "2") int size) {
		Page<Etudiant> etuds = etudiantService.getAllEtudiantsParPage(page, size);
		modelMap.addAttribute("etudiants", etuds);
		modelMap.addAttribute("pages", new int[etuds.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeEtudiants";
	}

	// --- Supprimer un étudiant ---
	@GetMapping("/supprimerEtudiant")
	public String supprimerEtudiant(@RequestParam Long id,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "2") int size) {
		etudiantService.deleteEtudiantById(id);
		return "redirect:/ListeEtudiants?page=" + page + "&size=" + size;
	}

	// --- Afficher le formulaire de modification ---
	@GetMapping("/modifierEtudiant")
	public String editerEtudiant(@RequestParam Long id,
			@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "2") int size,
			ModelMap modelMap) {
		Etudiant e = etudiantService.getEtudiant(id);
		if (e.getClasse() == null) {
			e.setClasse(new Classe());
		}
		List<Classe> classes = classeService.getAllClasses();
		modelMap.addAttribute("etudiant", e);
		modelMap.addAttribute("classes", classes);
		modelMap.addAttribute("mode", "edit");
		modelMap.addAttribute("page", page);
		modelMap.addAttribute("size", size);
		return "formEtudiant";
	}
}
