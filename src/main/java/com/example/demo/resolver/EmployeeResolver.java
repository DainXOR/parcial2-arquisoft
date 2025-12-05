package com.example.demo.resolver;

import com.example.demo.dto.EmployeeInput;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Status;
import com.example.demo.service.EmployeeService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class EmployeeResolver {

    private final EmployeeService employeeService;

    public EmployeeResolver(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @QueryMapping
    public List<Employee> employees() {
        return employeeService.findAll();
    }

    @QueryMapping
    public Employee employeeByDocument(@Argument String documentNumber) {
        return employeeService.findByDocumentNumber(documentNumber);
    }

    @MutationMapping
    public Employee createEmployee(@Argument EmployeeInput input) {
        Employee employee = new Employee();
        employee.setName(input.getName());
        employee.setLastName(input.getLastName());
        employee.setPhoneNumber(input.getPhoneNumber());
        employee.setDocumentType(input.getDocumentType());
        employee.setDocumentNumber(input.getDocumentNumber());
        employee.setStatus(input.getStatus() != null ? input.getStatus() : Status.Activo);
        return employeeService.create(employee);
    }

    @MutationMapping
    public Employee updateEmployee(@Argument Integer id, @Argument EmployeeInput input) {
        Employee updated = new Employee();
        updated.setName(input.getName());
        updated.setLastName(input.getLastName());
        updated.setPhoneNumber(input.getPhoneNumber());
        updated.setDocumentType(input.getDocumentType());
        updated.setDocumentNumber(input.getDocumentNumber());
        updated.setStatus(input.getStatus());
        return employeeService.update(id, updated);
    }

    @MutationMapping
    public Boolean deleteEmployee(@Argument Integer id) {
        employeeService.delete(id);
        return true;
    }
}
