package com.example.demo.service;

import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectService(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // === READ ===

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public Project findById(Long projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    // === CREATE ===

    public Project create(
            String name,
            String description,
            LocalDate startDate,
            LocalDate endDate,
            Project.Status status
    ) {
        Project p = new Project();
        p.setName(name);
        p.setDescription(description);
        p.setStartDate(startDate);
        p.setEndDate(endDate);
        p.setStatus(status);
        return projectRepository.save(p);
    }

    // === UPDATE ===

    public Project update(
            Long id,
            String name,
            String description,
            LocalDate startDate,
            LocalDate endDate,
            Project.Status status
    ) {
        Project p = projectRepository.findById(id).orElseThrow();
        p.setName(name);
        p.setDescription(description);
        p.setStartDate(startDate);
        p.setEndDate(endDate);
        p.setStatus(status);
        return projectRepository.save(p);
    }

    // === DELETE ===

    public boolean delete(Long id) {
        if (!projectRepository.existsById(id)) return false;
        projectRepository.deleteById(id);
        return true;
    }
}
