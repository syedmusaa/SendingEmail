package com.project.LibraryManagementSystem.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.LibraryManagementSystem.Entity.SentEmails;
public interface SentEmailsRepository extends JpaRepository<SentEmails, Long> {
}

