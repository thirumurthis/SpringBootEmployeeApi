package com.Application.App1.service;

import com.Application.App1.dao.EmployeeDao;
import com.Application.App1.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao tempEmployeeDaoImpl;

    //Constructor d-injection
    @Autowired
    public EmployeeServiceImpl(@Qualifier("tempEmpDao") EmployeeDao tempEmployeeDaoImpl) {
        this.tempEmployeeDaoImpl = tempEmployeeDaoImpl;
    }


    @Override
    public Employee getEmployeeById(UUID id) {
        return tempEmployeeDaoImpl.selectEmployeeById(id);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return tempEmployeeDaoImpl.selectAllEmployee();
    }

    @Override
    public void saveEmployee(UUID id, Employee employee) {
        tempEmployeeDaoImpl.insertEmployee(id,employee);
    }

    @Override
    public void updateEmployee(UUID id, Employee employee) {
        tempEmployeeDaoImpl.updateEmployee(id,employee);
    }

    @Override
    public void deleteEmployee(UUID id) {
        tempEmployeeDaoImpl.deleteEmployee(id);
    }
}
