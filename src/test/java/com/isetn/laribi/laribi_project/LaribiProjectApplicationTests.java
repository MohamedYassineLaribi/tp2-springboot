package com.isetn.laribi.laribi_project;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.isetn.laribi.laribi_project.entities.Etudiant;
import com.isetn.laribi.laribi_project.repos.EtudiantRepository;

@SpringBootTest
class LaribiProjectApplicationTests {
	 @Autowired
	    private EtudiantRepository etudiantRepository;

	    @Test
	    public void testCreateEtudiant() {
	        Etudiant e = new Etudiant(
	                "Ali",
	                "Ahmed",
	                "L3",
	                new Date(),
	                "ali@gmail.com"
	        );

	        etudiantRepository.save(e);
	    }
	    @Test
	    public void testUpdateEtudiant()
	    {
	        Etudiant e = etudiantRepository.findById(1L).get();

	        e.setNomEtudiant("NouveauNom");
	        e.setEmail("nouveau@email.com");

	        etudiantRepository.save(e);
	    }
	    @Test
	    public void testFindEtudiant()
	    {
	        Etudiant e = etudiantRepository.findById(1L).get();
	        System.out.println(e);

	        // Afficher ses classifications
	        if(e.getClassifications() != null) {
	            e.getClassifications().forEach(c -> {
	                System.out.println(c.getLibelle() + " : " + c.getScore());
	            });
	        }
	    }
	    @Test
	    public void testDeleteEtudiant()
	    {
	        etudiantRepository.deleteById(1L);
	    }

}
