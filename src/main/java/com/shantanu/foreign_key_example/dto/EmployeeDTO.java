package com.shantanu.foreign_key_example.dto;

import java.util.Set;

public class EmployeeDTO {
    private Integer id;
    private String name;
    private Set<EmailDTO> emails;

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

    public Set<EmailDTO> getEmails() {
        return emails;
    }

    public void setEmails(Set<EmailDTO> emails) {
        this.emails = emails;
    }
}
