package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.ProjectAssignment;
import com.example.demo.entity.ProjectAssignment.AssignmentStatus;
import com.example.demo.repository.ProjectAssignmentRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ProjectAssignmentService {

    private final ProjectAssignmentRepository projectAssignmentRepository;

    public ProjectAssignmentService(ProjectAssignmentRepository projectAssignmentRepository) {
        this.projectAssignmentRepository = projectAssignmentRepository;
    }

    public List<ProjectAssignment> listAllAssigments(){
        return projectAssignmentRepository.findAll();
    }

    public List<ProjectAssignment> findProjectsbyEmployeeDoc(String document){
        return projectAssignmentRepository.findProjectsbyEmployeeDoc(document, AssignmentStatus.Activo);
    }


}
