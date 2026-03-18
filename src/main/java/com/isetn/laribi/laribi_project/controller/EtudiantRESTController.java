package com.isetn.laribi.laribi_project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.isetn.laribi.laribi_project.dto.EtudiantDTO;
import com.isetn.laribi.laribi_project.entities.Etudiant;
import com.isetn.laribi.laribi_project.service.EtudiantService;

@RestController
@RequestMapping("/api/etudiants")
public class EtudiantRESTController {

    @Autowired
    EtudiantService etudiantService;

    /** GET /api/etudiants — retourne tous les étudiants en DTO */
    @GetMapping
    public List<EtudiantDTO> getAllEtudiants() {
        return etudiantService.getAllEtudiantsDTO();
    }

    /** GET /api/etudiants/{id} — retourne un étudiant en DTO */
    @GetMapping("/{id}")
    public EtudiantDTO getEtudiantById(@PathVariable Long id) {
        Etudiant e = etudiantService.getEtudiant(id);
        return etudiantService.convertEntityToDto(e);
    }

    /** POST /api/etudiants — crée un étudiant (reçoit et retourne un DTO) */
    @PostMapping
    public EtudiantDTO createEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantService.saveEtudiant(etudiant);
    }

    /** PUT /api/etudiants — modifie un étudiant (reçoit et retourne un DTO) */
    @PutMapping
    public EtudiantDTO updateEtudiant(@RequestBody EtudiantDTO etudiantDTO) {
        return etudiantService.updateEtudiant(etudiantDTO);
    }

    /** DELETE /api/etudiants/{id} — supprime un étudiant */
    @DeleteMapping("/{id}")
    public void deleteEtudiant(@PathVariable Long id) {
        etudiantService.deleteEtudiantById(id);
    }
}
