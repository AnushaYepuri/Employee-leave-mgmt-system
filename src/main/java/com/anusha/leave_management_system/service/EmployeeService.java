package com.anusha.leave_management_system.service;

import com.anusha.leave_management_system.entity.Employee;
import com.anusha.leave_management_system.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    // Constructor Injection
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    // Add Employee
    public Employee addEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    // Get Employee By ID
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }

    // Get All Employees
    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    // Update Employee
    public Employee updateEmployee(Long id, Employee updatedEmployee) {

        Employee existingEmployee = employeeRepository.findById(id).orElse(null);

        if (existingEmployee != null) {

            existingEmployee.setName(updatedEmployee.getName());
            existingEmployee.setEmail(updatedEmployee.getEmail());
            existingEmployee.setDepartment(updatedEmployee.getDepartment());
            existingEmployee.setProject(updatedEmployee.getProject());
            existingEmployee.setRole(updatedEmployee.getRole());

            return employeeRepository.save(existingEmployee);
        }

        return null;
    }

    // Delete Employee
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }
}