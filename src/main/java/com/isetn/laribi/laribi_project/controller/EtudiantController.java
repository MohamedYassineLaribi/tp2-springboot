package com.isetn.laribi.laribi_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.isetn.laribi.laribi_project.entities.Etudiant;
import com.isetn.laribi.laribi_project.service.EtudiantService;

@Controller
public class EtudiantController {
	@Autowired
	private EtudiantService etudiantService;

	@RequestMapping("/showCreate")
	public String showCreate(ModelMap modelMap) {
		modelMap.addAttribute("etudiant", new Etudiant());
		return "createEtudiant";
	}

	@RequestMapping("/saveEtudiant")
	public String saveEtudiant(@ModelAttribute("etudiant") Etudiant etudiant,
			@RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		// Conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateNaissance = dateformat.parse(String.valueOf(date));
		etudiant.setDateNaissance(dateNaissance);

		Etudiant saveEtudiant = etudiantService.saveEtudiant(etudiant);
		String msg = "Etudiant enregistré avec l'ID " + saveEtudiant.getIdEtudiant();
		modelMap.addAttribute("msg", msg);
		return "createEtudiant";
	}

	@RequestMapping("/ListeEtudiants")
	public String listeEtudiants(ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		Page<Etudiant> etuds = etudiantService.getAllEtudiantsParPage(page, size);
		modelMap.addAttribute("etudiants", etuds);
		modelMap.addAttribute("pages", new int[etuds.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeEtudiants";
	}

	@RequestMapping("/supprimerEtudiant")
	public String supprimerEtudiant(@RequestParam("id") Long id,
			ModelMap modelMap,
			@RequestParam(name = "page", defaultValue = "0") int page,
			@RequestParam(name = "size", defaultValue = "2") int size) {
		etudiantService.deleteEtudiantById(id);
		Page<Etudiant> etuds = etudiantService.getAllEtudiantsParPage(page, size);
		modelMap.addAttribute("etudiants", etuds);
		modelMap.addAttribute("pages", new int[etuds.getTotalPages()]);
		modelMap.addAttribute("currentPage", page);
		modelMap.addAttribute("size", size);
		return "listeEtudiants";
	}

	@RequestMapping("/modifierEtudiant")
	public String editerEtudiant(@RequestParam("id") Long id, ModelMap modelMap) {
		Etudiant e = etudiantService.getEtudiant(id);
		modelMap.addAttribute("etudiant", e);
		return "editerEtudiant";
	}

	@RequestMapping("/updateEtudiant")
	public String updateEtudiant(@ModelAttribute("etudiant") Etudiant etudiant,
			@RequestParam("date") String date,
			ModelMap modelMap) throws ParseException {
		// Conversion de la date
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		Date dateNaissance = dateformat.parse(String.valueOf(date));
		etudiant.setDateNaissance(dateNaissance);

		etudiantService.updateEtudiant(etudiant);
		return "redirect:/ListeEtudiants";
	}
}
