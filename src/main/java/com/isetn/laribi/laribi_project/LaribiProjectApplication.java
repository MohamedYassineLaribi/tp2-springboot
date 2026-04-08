package com.isetn.laribi.laribi_project;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.isetn.laribi.laribi_project.entities.AppRole;
import com.isetn.laribi.laribi_project.entities.AppUser;
import com.isetn.laribi.laribi_project.entities.Classe;
import com.isetn.laribi.laribi_project.entities.Etudiant;
import com.isetn.laribi.laribi_project.service.EtudiantService;
import com.isetn.laribi.laribi_project.service.UserService;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class LaribiProjectApplication implements CommandLineRunner {

	@Autowired
	EtudiantService etudiantService;

	@Autowired
	UserService userService;

	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;

	public static void main(String[] args) {
		SpringApplication.run(LaribiProjectApplication.class, args);
	}

	@PostConstruct
	public void init_users() {
		if (userService.findUserByUsername("admin") != null) return;

		userService.addRole(new AppRole(null, "ADMIN"));
		userService.addRole(new AppRole(null, "AGENT"));
		userService.addRole(new AppRole(null, "USER"));

		userService.saveUser(new AppUser(null, "admin",  "123", true, new ArrayList<>()));
		userService.saveUser(new AppUser(null, "user1",  "123", true, new ArrayList<>()));
		userService.saveUser(new AppUser(null, "user2",  "123", true, new ArrayList<>()));

		userService.addRoleToUser("admin",  "ADMIN");
		userService.addRoleToUser("user1",  "AGENT");
		userService.addRoleToUser("user1",  "USER");
		userService.addRoleToUser("user2",  "USER");
	}

	@Override
	public void run(String... args) throws Exception {
		repositoryRestConfiguration.exposeIdsFor(Etudiant.class, Classe.class);
		if (etudiantService.getAllEtudiants().isEmpty()) {
			etudiantService.saveEtudiant(new Etudiant("Laribi",   "Ahmed",  null, new Date(), "ahmed.laribi@isetn.tn"));
			etudiantService.saveEtudiant(new Etudiant("Ben Ali",  "Sonia",  null, new Date(), "sonia.benali@isetn.tn"));
			etudiantService.saveEtudiant(new Etudiant("Trabelsi", "Mohamed",null, new Date(), "m.trabelsi@isetn.tn"));
		}
	}
}
