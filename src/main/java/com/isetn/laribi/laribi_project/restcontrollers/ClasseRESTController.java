package com.isetn.laribi.laribi_project.restcontrollers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.isetn.laribi.laribi_project.entities.Classe;
import com.isetn.laribi.laribi_project.repos.ClasseRepository;

@RestController
@RequestMapping("/api/classes")
@CrossOrigin(origins = "http://localhost:4200")
public class ClasseRESTController {

    @Autowired
    private ClasseRepository classeRepository;

    @GetMapping
    public List<Classe> getAllClasses() {
        return classeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Classe getClasseById(@PathVariable Long id) {
        return classeRepository.findById(id).orElseThrow();
    }

    @PostMapping
    public Classe createClasse(@RequestBody Classe classe) {
        return classeRepository.save(classe);
    }

    @PutMapping("/{id}")
    public Classe updateClasse(@PathVariable Long id, @RequestBody Classe classe) {
        classe.setIdClasse(id);
        return classeRepository.save(classe);
    }

    @DeleteMapping("/{id}")
    public void deleteClasse(@PathVariable Long id) {
        classeRepository.deleteById(id);
    }
}
