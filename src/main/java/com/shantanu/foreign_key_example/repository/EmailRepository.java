package com.shantanu.foreign_key_example.repository;

import com.shantanu.foreign_key_example.entity.EmailAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<EmailAccount, Long> {
}
