package com.isetn.laribi.laribi_project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.isetn.laribi.laribi_project.entities.Classe;
import com.isetn.laribi.laribi_project.repos.ClasseRepository;

@Service
public class ClasseServiceImpl implements ClasseService {

    @Autowired
    private ClasseRepository classeRepository;

    @Override
    public Classe saveClasse(Classe c) {
        if (c == null)
            return null;
        return classeRepository.save(c);
    }

    @Override
    public Classe updateClasse(Classe c) {
        if (c == null)
            return null;
        return classeRepository.save(c);
    }

    @Override
    public void deleteClasse(Classe c) {
        if (c == null)
            return;
        classeRepository.delete(c);
    }

    @Override
    public void deleteClasseById(Long id) {
        if (id == null)
            return;
        classeRepository.deleteById(id);
    }

    @Override
    public Classe getClasse(Long id) {
        if (id == null)
            return null;
        return classeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Classe> getAllClasses() {
        return classeRepository.findAll();
    }

    @Override
    public Page<Classe> getAllClassesParPage(int page, int size) {
        return classeRepository.findAll(PageRequest.of(page, size));
    }
}
