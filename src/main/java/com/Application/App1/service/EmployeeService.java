package com.Application.App1.service;

import com.Application.App1.model.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {

    Employee getEmployeeById(UUID id);
    List<Employee> getAllEmployee();
    void saveEmployee(UUID id, Employee employee);
    void updateEmployee(UUID id, Employee employee);
    void deleteEmployee(UUID id);
}
