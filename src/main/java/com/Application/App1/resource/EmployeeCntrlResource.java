package com.Application.App1.resource;

import com.Application.App1.model.Employee;
import com.Application.App1.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.MediaTypeEditor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping ("employee-api/v1/employee")
public class EmployeeCntrlResource {

    private EmployeeService employeeService;
    @Autowired
    //performing setter injection
    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @RequestMapping(method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Employee> getAllEmployee(){
        return employeeService.getAllEmployee();
    }

   @RequestMapping(method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE,
    path = "{id}")
    public Employee getEmployee(@RequestBody @PathVariable("id") UUID id){
        return employeeService.getEmployeeById(id);
    }

    @RequestMapping (method=RequestMethod.DELETE,
    path ="{id}")
    public void deleteEmployee(@PathVariable("id")UUID id){
        employeeService.deleteEmployee(id);
    }
    //updating the data and payload should be the json payload usign
    //@RequestBody
    //1. approach to just use the pay load to perform the update
    @RequestMapping (method=RequestMethod.PUT)
    public void updateEmployee(@RequestBody Employee employee){
        UUID id = employee.getId();
        employeeService.updateEmployee(id,employee);
    }
    //2. approach to perfrom update passing the id and the pay load from the client
    //to this end-point
    @RequestMapping (method=RequestMethod.PUT,
    consumes = MediaType.APPLICATION_JSON_VALUE,
    path="{id}")
    public void updateEmployeeWithId(@PathVariable("id") UUID id , @RequestBody Employee employee){
        employeeService.updateEmployee(id,employee);
    }

    //usage of the @RequestBody annotation to map the request value to the object
    @RequestMapping(method = RequestMethod.POST,
     consumes = MediaType.APPLICATION_JSON_VALUE)
    public void insertEmployee(@RequestBody Employee employee){
        UUID id = UUID.randomUUID();
        employeeService.saveEmployee(id,employee);
    }
}
