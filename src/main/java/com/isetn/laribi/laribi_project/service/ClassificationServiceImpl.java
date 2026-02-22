package com.isetn.laribi.laribi_project.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import com.isetn.laribi.laribi_project.entities.Classification;
import com.isetn.laribi.laribi_project.repos.ClassificationRepository;

@Service
public class ClassificationServiceImpl implements ClassificationService {

    @Autowired
    private ClassificationRepository classificationRepository;

    @Override
    public Classification saveClassification(Classification c) {
        return classificationRepository.save(c);
    }

    @Override
    public Classification updateClassification(Classification c) {
        return classificationRepository.save(c);
    }

    @Override
    public void deleteClassification(Classification c) {
        classificationRepository.delete(c);
    }

    @Override
    public void deleteClassificationById(Long id) {
        classificationRepository.deleteById(id);
    }

    @Override
    public Classification getClassification(Long id) {
        return classificationRepository.findById(id).get();
    }

    @Override
    public List<Classification> getAllClassifications() {
        return classificationRepository.findAll();
    }

    @Override
    public Page<Classification> getAllClassificationsParPage(int page, int size) {
        return classificationRepository.findAll(PageRequest.of(page, size));
    }
}
