package com.example.demo.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "employee",
        uniqueConstraints = @UniqueConstraint(columnNames = "document_number"))
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;

    @Column(name = "document_type", nullable = false)
    private String documentType;

    @Column(name = "document_number", nullable = false, unique = true)
    private String documentNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;

    // Relación bidireccional con ProjectAssignment
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ProjectAssignment> assignments = new ArrayList<>();

    public Employee() {
    }

    public Employee(Integer employeeId, String name, String lastName, String phoneNumber,
                    String documentType, String documentNumber, Status status) {
        this.employeeId = employeeId;
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.status = status;
    }

    // Getters & Setters

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public List<ProjectAssignment> getAssignments() {
        return assignments;
    }

    public void setAssignments(List<ProjectAssignment> assignments) {
        this.assignments = assignments;
    }

    // helpers for bidirectional relation
    public void addAssignment(ProjectAssignment pa) {
        assignments.add(pa);
        pa.setEmployee(this);
    }

    public void removeAssignment(ProjectAssignment pa) {
        assignments.remove(pa);
        pa.setEmployee(null);
    }
}
