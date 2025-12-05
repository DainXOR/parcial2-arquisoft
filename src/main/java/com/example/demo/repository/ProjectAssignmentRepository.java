package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ProjectAssignment;
import com.example.demo.entity.ProjectAssignment.AssignmentStatus;

public interface ProjectAssignmentRepository extends JpaRepository<ProjectAssignment, Long> {

    public List<ProjectAssignment> findProjectsByEmployeeId(Long employeeId);
    public List<ProjectAssignment> findProjectsbyEmployeeDoc(String document, AssignmentStatus status);
}
