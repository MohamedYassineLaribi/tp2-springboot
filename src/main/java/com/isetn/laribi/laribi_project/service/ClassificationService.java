package com.isetn.laribi.laribi_project.service;

import java.util.List;
import org.springframework.data.domain.Page;
import com.isetn.laribi.laribi_project.entities.Classification;

public interface ClassificationService {
    Classification saveClassification(Classification c);

    Classification updateClassification(Classification c);

    void deleteClassification(Classification c);

    void deleteClassificationById(Long id);

    Classification getClassification(Long id);

    List<Classification> getAllClassifications();

    Page<Classification> getAllClassificationsParPage(int page, int size);
}
