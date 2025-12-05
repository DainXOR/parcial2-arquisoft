package com.example.demo.resolver;

import java.util.List;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.example.demo.service.EmployeeService;
import com.example.demo.service.ProjectAssignmentService;
import com.example.demo.service.ProjectService;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Project;
import com.example.demo.entity.ProjectAssignment;
import com.example.demo.entity.ProjectAssignment.AssignmentStatus;

@Controller
public class ProjectAssignmentResolver {
    private final ProjectAssignmentService projectAssignmentService;
    private final EmployeeService employeeService;
    private final ProjectService projectService;

    public ProjectAssignmentResolver(ProjectAssignmentService projectAssignmentService,
                                     EmployeeService employeeService,
                                     ProjectService projectService) {
        this.projectAssignmentService = projectAssignmentService;
        this.employeeService = employeeService;
        this.projectService = projectService;
    }

    @QueryMapping
    public List<ProjectAssignment> listAllAssigments(){
        return projectAssignmentService.listAllAssigments();
    }

    @QueryMapping
    public List<ProjectAssignment> findProjectsbyEmployeeDoc(@Argument String document){
        return projectAssignmentService.findProjectsbyEmployeeDoc(document);
        
    }

    @MutationMapping
    public ProjectAssignment assignToProject(@Argument Integer employeeId,
                                             @Argument Long projectId, 
                                             @Argument String rol ){
        
       Employee employee = employeeService.findById(employeeId);
       Project project = projectService.findById(projectId);
       if(project == null){
        throw new RuntimeException("Proyecto no encontrado");
       }

       ProjectAssignment assignment = new ProjectAssignment();
       assignment.setEmployeeRol(rol);
       assignment.setStatus(AssignmentStatus.Activo);

       return projectAssignmentService.createAssignment(assignment);
    }

}
