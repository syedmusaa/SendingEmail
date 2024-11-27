package com.project.LibraryManagementSystem.Entity;

import java.time.LocalDateTime;

import jakarta.persistence.*;
import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SentEmails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String recipient;
    private String subject;
    private String body;
    private String fromEmailId;
    private LocalDateTime sentAt;

    // Getters and setters
}

