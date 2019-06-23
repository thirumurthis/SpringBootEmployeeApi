package com.Application.App1.dao;

import com.Application.App1.model.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeDao {

    Employee selectEmployeeById(UUID id);
    List<Employee> selectAllEmployee();
    int insertEmployee(UUID id, Employee employee);
    int updateEmployee(UUID id, Employee employee);
    int deleteEmployee(UUID id);
}
