package com.shantanu.foreign_key_example.entity;

import jakarta.persistence.*;

import java.util.Set;

@Entity
//@Table(name = "Employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<EmailAccount> emailAccounts;

    // Getters and Setters

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<EmailAccount> getEmails() {
        return emailAccounts;
    }

    public void setEmails(Set<EmailAccount> emailAccounts) {
        this.emailAccounts = emailAccounts;
    }
}
