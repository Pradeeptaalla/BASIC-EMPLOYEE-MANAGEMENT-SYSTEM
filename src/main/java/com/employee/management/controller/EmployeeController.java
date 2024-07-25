package com.employee.management.controller;

import com.employee.management.entity.Employee;
import com.employee.management.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService service;

    @PostMapping("/addEmployee")
    public Employee addEmployee(@RequestBody Employee Employee) {
        return service.saveEmployee(Employee);
    }

    

    @GetMapping("/Employees")
    public List<Employee> findAllEmployees() {
        return service.getEmployees();
    }

    @GetMapping("/EmployeeById/{id}")
    public Employee findEmployeeById(@PathVariable int id) {
        return service.getEmployeeById(id);
    }

    @GetMapping("/Employee/{name}")
    public Employee findEmployeeByName(@PathVariable String name) {
        return service.getEmployeeByName(name);
    }

    @PutMapping("/update")
    public Employee updateEmployee(@RequestBody Employee Employee) {
        return service.updateEmployee(Employee);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id) {
        return service.deleteEmployee(id);
    }
}
