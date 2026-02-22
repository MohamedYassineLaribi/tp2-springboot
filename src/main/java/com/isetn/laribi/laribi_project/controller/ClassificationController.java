package com.isetn.laribi.laribi_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.isetn.laribi.laribi_project.entities.Classification;
import com.isetn.laribi.laribi_project.entities.Etudiant;
import com.isetn.laribi.laribi_project.service.ClassificationService;
import com.isetn.laribi.laribi_project.service.EtudiantService;

import java.util.List;

@Controller
public class ClassificationController {

    @Autowired
    private ClassificationService classificationService;

    @Autowired
    private EtudiantService etudiantService;

    @RequestMapping("/showCreateClassification")
    public String showCreate(ModelMap modelMap) {
        List<Etudiant> etuds = etudiantService.getAllEtudiants();
        modelMap.addAttribute("classification", new Classification());
        modelMap.addAttribute("etudiants", etuds);
        modelMap.addAttribute("mode", "new");
        return "formClassification";
    }

    @RequestMapping("/saveClassification")
    public String saveClassification(@ModelAttribute("classification") Classification classification,
            ModelMap modelMap) {
        classificationService.saveClassification(classification);
        return "redirect:/ListeClassifications";
    }

    @RequestMapping("/ListeClassifications")
    public String listeClassifications(ModelMap modelMap,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {
        Page<Classification> classifs = classificationService.getAllClassificationsParPage(page, size);
        modelMap.addAttribute("classifications", classifs);
        modelMap.addAttribute("pages", new int[classifs.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        return "listeClassifications";
    }

    @RequestMapping("/supprimerClassification")
    public String supprimerClassification(@RequestParam("id") Long id,
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "2") int size) {
        classificationService.deleteClassificationById(id);
        return "redirect:/ListeClassifications?page=" + page + "&size=" + size;
    }

    @RequestMapping("/modifierClassification")
    public String editerClassification(@RequestParam("id") Long id, ModelMap modelMap) {
        Classification c = classificationService.getClassification(id);
        List<Etudiant> etuds = etudiantService.getAllEtudiants();
        modelMap.addAttribute("classification", c);
        modelMap.addAttribute("etudiants", etuds);
        modelMap.addAttribute("mode", "edit");
        return "formClassification";
    }

    @RequestMapping("/updateClassification")
    public String updateClassification(@ModelAttribute("classification") Classification classification) {
        classificationService.updateClassification(classification);
        return "redirect:/ListeClassifications";
    }
}
