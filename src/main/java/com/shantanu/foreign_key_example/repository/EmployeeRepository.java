package com.shantanu.foreign_key_example.repository;

import com.shantanu.foreign_key_example.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}