package com.isetn.laribi.laribi_project.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.isetn.laribi.laribi_project.entities.Classification;

public interface ClassificationRepository extends JpaRepository<Classification, Long> {
}
