package com.example.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="project_assignment")
public class ProjectAssignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="project_assignment_id")
    private Long projectAssignmentId;

    @Column(name="employee_rol", nullable = false)
    private String employeeRol;
    
    @Enumerated(EnumType.STRING)
    @Column(name="status", nullable = false)
    private AssignmentStatus status;

    @ManyToOne
  
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public ProjectAssignment() {
    }

    public ProjectAssignment(Long projectAssignmentId, String employeeRol, Project project, Employee employee) {
        this.projectAssignmentId = projectAssignmentId;
        this.employeeRol = employeeRol;
        this.project = project;
        this.employee = employee;
    }

    public Long getProjectAssignmentId() {
        return projectAssignmentId;
    }

    public void setProjectAssignmentId(Long projectAssignmentId) {
        this.projectAssignmentId = projectAssignmentId;
    }

    public String getEmployeeRol() {
        return employeeRol;
    }

    public void setEmployeeRol(String employeeRol) {
        this.employeeRol = employeeRol;
    }

    public AssignmentStatus getStatus() {
        return status;
    }

    public void setStatus(AssignmentStatus status) {
        this.status = status;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public enum AssignmentStatus{
        Activo,
        Inactivo,
    }


}
