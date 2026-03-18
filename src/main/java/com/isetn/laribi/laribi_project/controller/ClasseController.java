package com.isetn.laribi.laribi_project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.isetn.laribi.laribi_project.entities.Classe;
import com.isetn.laribi.laribi_project.service.ClasseService;

@Controller
public class ClasseController {

    @Autowired
    private ClasseService classeService;

    @GetMapping("/showCreateClasse")
    public String showCreate(ModelMap modelMap) {
        modelMap.addAttribute("classe", new Classe());
        modelMap.addAttribute("mode", "new");
        return "formClasse";
    }

    @PostMapping("/saveClasse")
    public String saveClasse(@ModelAttribute("classe") Classe classe,
            ModelMap modelMap) {
        classeService.saveClasse(classe);
        return "redirect:/ListeClasses";
    }

    @GetMapping("/ListeClasses")
    public String listeClasses(ModelMap modelMap,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size) {
        Page<Classe> classes = classeService.getAllClassesParPage(page, size);
        modelMap.addAttribute("classes", classes);
        modelMap.addAttribute("pages", new int[classes.getTotalPages()]);
        modelMap.addAttribute("currentPage", page);
        modelMap.addAttribute("size", size);
        return "listeClasses";
    }

    @GetMapping("/supprimerClasse")
    public String supprimerClasse(@RequestParam Long id,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "2") int size) {
        classeService.deleteClasseById(id);
        return "redirect:/ListeClasses?page=" + page + "&size=" + size;
    }

    @GetMapping("/modifierClasse")
    public String editerClasse(@RequestParam Long id, ModelMap modelMap) {
        Classe c = classeService.getClasse(id);
        modelMap.addAttribute("classe", c);
        modelMap.addAttribute("mode", "edit");
        return "formClasse";
    }

    @PostMapping("/updateClasse")
    public String updateClasse(@ModelAttribute("classe") Classe classe) {
        classeService.updateClasse(classe);
        return "redirect:/ListeClasses";
    }
}
