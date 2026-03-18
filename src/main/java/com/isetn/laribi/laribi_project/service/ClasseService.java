package com.isetn.laribi.laribi_project.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.isetn.laribi.laribi_project.entities.Classe;

public interface ClasseService {
    Classe saveClasse(Classe c);

    Classe updateClasse(Classe c);

    void deleteClasse(Classe c);

    void deleteClasseById(Long id);

    Classe getClasse(Long id);

    List<Classe> getAllClasses();

    Page<Classe> getAllClassesParPage(int page, int size);
}
