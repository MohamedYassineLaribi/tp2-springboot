package com.isetn.laribi.laribi_project.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.isetn.laribi.laribi_project.entities.Etudiant;
import com.isetn.laribi.laribi_project.entities.Classe;

import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "rest")
public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {

    List<Etudiant> findByNomEtudiant(String nom);

    List<Etudiant> findByNomEtudiantContains(String nom);

    @Query("select e from Etudiant e where e.nomEtudiant like %:nom and e.prenomEtudiant like %:prenom")
    List<Etudiant> findByNomPrenom(@Param("nom") String nom, @Param("prenom") String prenom);

    @Query("select e from Etudiant e where e.classe = ?1")
    List<Etudiant> findByClasse(Classe classe);

    List<Etudiant> findByClasseIdClasse(Long id);

    List<Etudiant> findByOrderByNomEtudiantAsc();

    @Query("select e from Etudiant e order by e.nomEtudiant ASC, e.prenomEtudiant DESC")
    List<Etudiant> trierEtudiantsNomsPrenom();

    @Query("select e from Etudiant e where e.classe.nomClasse = :nomClasse")
    List<Etudiant> findEtudiantByClasse(@Param("nomClasse") String nomClasse);
}
