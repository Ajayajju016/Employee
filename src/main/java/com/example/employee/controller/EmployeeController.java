package com.example.employee.controller;

import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.employee.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.employee.service.EmployeeJpaService;

@RestController
public class EmployeeController{
    
    @Autowired
    public EmployeeJpaService employeeservice;

    @GetMapping("/employees")
    public ArrayList<Employee> getEmployees(){
        return employeeservice.getEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable("employeeId") int employeeId){
        return employeeservice.getEmployeeById(employeeId);
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){
        return employeeservice.addEmployee(employee);
    }

    @PutMapping("/employees/{employeeId}")
    public Employee updateEmployee(@PathVariable("employeeId") int employeeId , @RequestBody Employee employee){
        return employeeservice.updateEmployee(employeeId , employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable("employeeId") int employeeId){
        employeeservice.deleteEmployee(employeeId);
    }

}

