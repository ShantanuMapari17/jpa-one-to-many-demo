package com.shantanu.foreign_key_example.entity;

import jakarta.persistence.*;

@Entity
//@Table(name = "Email")
public class EmailAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "emailAddress", nullable = false)  // Ensure this is NOT NULL
    private String emailAddress;

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)  // Ensure this is NOT NULL
    private Employee employee;

    // Getters and Setters


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}