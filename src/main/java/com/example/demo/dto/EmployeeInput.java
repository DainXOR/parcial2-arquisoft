package com.example.demo.dto;

import com.example.demo.entity.Status;

public class EmployeeInput {

    private String name;
    private String lastName;
    private String phoneNumber;
    private String documentType;
    private String documentNumber;
    private Status status;

    public EmployeeInput() {}

    public EmployeeInput(String name, String lastName, String phoneNumber,
                         String documentType, String documentNumber, Status status) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.status = status;
    }

    // getters & setters

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
}
