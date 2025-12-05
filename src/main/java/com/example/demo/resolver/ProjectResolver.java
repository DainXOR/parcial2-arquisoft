package com.example.demo.resolver;


import com.example.demo.entity.Project;
import com.example.demo.repository.ProjectRepository;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ProjectResolver {
     private final ProjectRepository projectRepository;

    public ProjectResolver(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    // Queries

    @QueryMapping
    public List<Project> projects() {
        return projectRepository.findAll();
    }

    @QueryMapping
    public Project projectById(@Argument Integer id) {
        return projectRepository.findById(id).orElse(null);
    }

    // Mutations

    @MutationMapping
    public Project createProject(
            @Argument String name,
            @Argument String description,
            @Argument LocalDate startDate,
            @Argument LocalDate endDate,
            @Argument Project.Status status
    ) {
        Project p = new Project();
        p.setName(name);
        p.setDescription(description);
        p.setStartDate(startDate);
        p.setEndDate(endDate);
        p.setStatus(status);
        return projectRepository.save(p);
    }

    @MutationMapping
    public Project updateProject(
            @Argument Integer id,
            @Argument String name,
            @Argument String description,
            @Argument LocalDate startDate,
            @Argument LocalDate endDate,
            @Argument Project.Status status
    ) {
        Project p = projectRepository.findById(id).orElseThrow();
        p.setName(name);
        p.setDescription(description);
        p.setStartDate(startDate);
        p.setEndDate(endDate);
        p.setStatus(status);
        return projectRepository.save(p);
    }

    @MutationMapping
    public Boolean deleteProject(@Argument Integer id) {
        if (!projectRepository.existsById(id)) return false;
        projectRepository.deleteById(id);
        return true;
    }
}
