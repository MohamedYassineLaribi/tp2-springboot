package com.isetn.laribi.laribi_project.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.isetn.laribi.laribi_project.entities.Etudiant;
import com.isetn.laribi.laribi_project.service.EtudiantService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class EtudiantRESTController {

    @Autowired
    EtudiantService etudiantService;

    @GetMapping()
    public List<Etudiant> getAllEtudiants() {
        return etudiantService.getAllEtudiants();
    }

    @GetMapping("/{id}")
    public Etudiant getEtudiantById(@PathVariable("id") Long id) {
        return etudiantService.getEtudiant(id);
    }

    @PostMapping()
    public Etudiant createEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.saveEtudiantEntity(etudiant);
    }

    @PutMapping("/{id}")
    public Etudiant updateEtudiant(@PathVariable("id") Long id, @RequestBody Etudiant etudiant) {
        etudiant.setIdEtudiant(id);
        return etudiantService.updateEtudiantEntity(etudiant);
    }

    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable("id") Long id) {
        etudiantService.deleteEtudiantById(id);
    }

    @GetMapping("/etudscat/{idCat}")
    public List<Etudiant> getEtudiantsByCatId(@PathVariable("idCat") Long idCat) {
        return etudiantService.findByClasseIdClasse(idCat);
    }
}
