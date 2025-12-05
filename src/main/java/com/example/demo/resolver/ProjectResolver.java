package com.example.demo.resolver;

import com.example.demo.entity.Project;
import com.example.demo.service.ProjectService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.time.LocalDate;
import java.util.List;

@Controller
public class ProjectResolver {

    private final ProjectService projectService;

    public ProjectResolver(ProjectService projectService) {
        this.projectService = projectService;
    }

    // Queries

    @QueryMapping
    public List<Project> projects() {
        return projectService.findAll();
    }

    @QueryMapping
    public Project projectById(@Argument Integer id) {
        return projectService.findById(id);
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
        return projectService.create(name, description, startDate, endDate, status);
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
        return projectService.update(id, name, description, startDate, endDate, status);
    }

    @MutationMapping
    public Boolean deleteProject(@Argument Integer id) {
        return projectService.delete(id);
    }
}
