package com.shantanu.foreign_key_example.service;

import com.shantanu.foreign_key_example.dto.EmailDTO;
import com.shantanu.foreign_key_example.dto.EmployeeDTO;
import com.shantanu.foreign_key_example.entity.EmailAccount;
import com.shantanu.foreign_key_example.entity.Employee;
import com.shantanu.foreign_key_example.repository.EmailRepository;
import com.shantanu.foreign_key_example.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private EmailRepository emailRepository;


    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        try {
            Employee employee = new Employee();
            employee.setName(employeeDTO.getName());

//             Map emails from DTO to entity
            Set<EmailAccount> emailAccounts = employeeDTO.getEmails().stream()
                    .map(emailDTO -> {
                        EmailAccount emailAccount = new EmailAccount();
                        emailAccount.setEmailAddress(emailDTO.getEmailAddress());  // Ensure emailAddress is set
                        emailAccount.setEmployee(employee); // Set the employee reference
                        return emailAccount;
                    })
                    .collect(Collectors.toSet());

            employee.setEmails(emailAccounts);

            // Save employee and associated emails
            Employee savedEmployee = employeeRepository.save(employee);

            return mapToDTO(savedEmployee);

        } catch (Exception e) {
            // Log and handle the exception
            e.printStackTrace();
            throw new RuntimeException("Failed to save employee", e);
        }
    }


    private EmployeeDTO mapToDTO(Employee employee) {
        EmployeeDTO dto = new EmployeeDTO();
        dto.setId(employee.getId());
        dto.setName(employee.getName());

        // Map emails from entity to DTO
        Set<EmailDTO> emailDTOs = employee.getEmails().stream()
                .map(emailAccount -> {
                    EmailDTO emailDTO = new EmailDTO();
                    emailDTO.setId(emailAccount.getId());
                    emailDTO.setEmailAddress(emailAccount.getEmailAddress());
                    return emailDTO;
                })
                .collect(Collectors.toSet());

        dto.setEmails(emailDTOs);

        return dto;
    }

    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> employees = employeeRepository.findAll();
        return employees.stream().map(this::mapToDTO).collect(Collectors.toList());
    }
}