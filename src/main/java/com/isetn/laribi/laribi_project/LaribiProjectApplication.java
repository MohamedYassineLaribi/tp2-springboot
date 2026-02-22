package com.isetn.laribi.laribi_project;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.isetn.laribi.laribi_project.entities.Etudiant;
import com.isetn.laribi.laribi_project.service.EtudiantService;

@SpringBootApplication
public class LaribiProjectApplication implements CommandLineRunner {

	@Autowired
	EtudiantService etudiantService;

	public static void main(String[] args) {
		SpringApplication.run(LaribiProjectApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Seeding sample data if the table is empty
		if (etudiantService.getAllEtudiants().isEmpty()) {
			etudiantService.saveEtudiant(new Etudiant("Laribi", "Ahmed", "DSI23", new Date(), "ahmed.laribi@isetn.tn"));
			etudiantService.saveEtudiant(new Etudiant("Ben Ali", "Sonia", "SEM4", new Date(), "sonia.benali@isetn.tn"));
			etudiantService
					.saveEtudiant(new Etudiant("Trabelsi", "Mohamed", "MTI1", new Date(), "m.trabelsi@isetn.tn"));
		}
	}
}
