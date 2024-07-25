package com.employee.management.service;

import com.employee.management.entity.Employee;
import com.employee.management.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository repository;

    public Employee saveEmployee(Employee Employee) {
        return repository.save(Employee);
    }

    public List<Employee> saveEmployees(List<Employee> Employees) {
        return repository.saveAll(Employees);
    }

    public List<Employee> getEmployees() {
        return repository.findAll();
    }

    public Employee getEmployeeById(int id) {
        return repository.findById(id).orElse(null);
    }

    public Employee getEmployeeByName(String name) {
        return repository.findByName(name);
    }

    public String deleteEmployee(int id) {
        repository.deleteById(id);
        return "Employee removed !! " + id;
    }

    public Employee updateEmployee(Employee Employee) {
        Employee existingEmployee = repository.findById(Employee.getId()).orElse(null);
        existingEmployee.setName(Employee.getName());
        existingEmployee.setDepartment(Employee.getDepartment());
        existingEmployee.setSalary(Employee.getSalary());
        return repository.save(existingEmployee);
    }


}
