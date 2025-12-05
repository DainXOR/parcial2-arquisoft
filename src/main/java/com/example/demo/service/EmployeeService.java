package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeService(EmployeeRepository repo) {
        this.repo = repo;
    }

    public List<Employee> findAll() {
        return repo.findAll();
    }

    public Employee findById(Integer id) {
        return repo.findById(id)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee id=" + id + " not found"));
    }

    public Employee findByDocumentNumber(String documentNumber) {
        return repo.findByDocumentNumber(documentNumber)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee document=" + documentNumber + " not found"));
    }

    @Transactional
    public Employee create(Employee employee) {
        // Puedes validar duplicados antes de guardar si lo deseas
        return repo.save(employee);
    }

    @Transactional
    public Employee update(Integer id, Employee updated) {
        Employee existing = findById(id);
        existing.setName(updated.getName());
        existing.setLastName(updated.getLastName());
        existing.setPhoneNumber(updated.getPhoneNumber());
        existing.setDocumentType(updated.getDocumentType());
        existing.setDocumentNumber(updated.getDocumentNumber());
        existing.setStatus(updated.getStatus());
        return repo.save(existing);
    }

    @Transactional
    public void delete(Integer id) {
        Employee existing = findById(id);
        repo.delete(existing);
    }
}
