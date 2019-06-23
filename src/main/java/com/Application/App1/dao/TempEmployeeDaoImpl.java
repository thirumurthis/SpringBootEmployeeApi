package com.Application.App1.dao;

import com.Application.App1.model.Employee;
import org.springframework.stereotype.Repository;

import java.util.*;

//the name provided to this is a best practise
//if there are multiple DAO implementer, the service layer can
//identify the specif DAO implementor using @Qualifier("tempEmpDap")
@Repository("tempEmpDao")
public class TempEmployeeDaoImpl implements EmployeeDao {

      private Map<UUID, Employee> tempMap;
    public TempEmployeeDaoImpl() {
        tempMap = new HashMap<>();
        populateData();
    }

    protected void populateData(){
      UUID uid =  generateUUID();
      tempMap.put(uid,new Employee(uid,"first-one","textile"));
      uid =  generateUUID();
      tempMap.put(uid,new Employee(uid,"second-one","finance"));
    }

    protected UUID generateUUID(){
        return UUID.randomUUID();
    }

    @Override
    public Employee selectEmployeeById(UUID id) {
        return tempMap.get(id);
    }

    @Override
    public List<Employee> selectAllEmployee() {
        return new ArrayList<>(tempMap.values());
    }

    @Override
    public int insertEmployee(UUID id, Employee employee) {
        UUID tempId = id ==null ? generateUUID() : id;
        employee.setId(tempId);
        tempMap.put(id,employee);
        return 1;
    }

    @Override
    public int updateEmployee(UUID id, Employee employee) {
        tempMap.put(id,employee);
        return 1;
    }

    @Override
    public int deleteEmployee(UUID id) {
        tempMap.remove(id);
        return 1;
    }
}
