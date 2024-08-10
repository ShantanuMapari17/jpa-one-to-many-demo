package com.shantanu.foreign_key_example.controller;

import com.shantanu.foreign_key_example.dto.EmployeeDTO;
import com.shantanu.foreign_key_example.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public ResponseEntity<EmployeeDTO> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        System.out.println(employeeDTO.getEmails());
        EmployeeDTO createdEmployee = employeeService.addEmployee(employeeDTO);

        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED);
    }
}