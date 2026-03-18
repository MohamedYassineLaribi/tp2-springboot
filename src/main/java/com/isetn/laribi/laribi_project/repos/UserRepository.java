package com.isetn.laribi.laribi_project.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isetn.laribi.laribi_project.entities.AppUser;

public interface UserRepository extends JpaRepository<AppUser, Long> {
    AppUser findByUsername(String username);
}
