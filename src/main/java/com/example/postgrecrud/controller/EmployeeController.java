package com.example.postgrecrud.controller;

import com.example.postgrecrud.exception.ResourceNotFoundException;
import com.example.postgrecrud.model.Employee;
import com.example.postgrecrud.repo.EmployeeRepo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    final
    EmployeeRepo employeeRepo;

    public EmployeeController(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepo.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("this employee is not found in our db"));
        return ResponseEntity.ok().body(employee);
    }

    @PostMapping("/employeess")
    public Employee createEmployee(@RequestBody Employee employee) {
       Employee employee1= employeeRepo.save(employee);
        return employee1;

    }


    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId, @Validated @RequestBody Employee employeeDetails) throws ResourceNotFoundException {
        Employee employee = this.employeeRepo.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found with this id"));

        employee.setEmail(employeeDetails.getEmail());
        employee.setFirstName(employee.getFirstName());
        employee.setLastName(employee.getLastName());

        return ResponseEntity.ok(this.employeeRepo.save(employee));
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws ResourceNotFoundException {
        Employee employee = this.employeeRepo.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found with this id"));
        this.employeeRepo.delete(employee);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted ", Boolean.TRUE);
        return response;
    }

    @PatchMapping("/employees/{id}")
    public ResponseEntity<Employee> updateUserPartially(
            @PathVariable(value = "id") Long userId,
            @Validated @RequestBody Employee userDetails) throws ResourceNotFoundException {
        Employee user = employeeRepo.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found on :: " + userId));

        user.setEmail(userDetails.getEmail());
        final Employee updatedUser = employeeRepo.save(user);
        return ResponseEntity.ok(updatedUser);
    }

}
