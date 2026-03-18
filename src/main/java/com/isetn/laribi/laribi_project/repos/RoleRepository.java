package com.isetn.laribi.laribi_project.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isetn.laribi.laribi_project.entities.AppRole;

public interface RoleRepository extends JpaRepository<AppRole, Long> {
    AppRole findByRole(String role);
}
