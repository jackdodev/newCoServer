package com.jackdodev.newCo.project;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "projects")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;

    private String subject;

    private String category;

    private String content;

    private LocalDate createdAt;

    private LocalDate lastModified;

    private UUID authorId;

    public Project(UUID id, String subject, String category, String content) {
        this.id = id;
        this.subject = subject;
        this.category = category;
        this.content = content;
    }

    public static Project convertProjectFromProjectDTO(ProjectDTO projectDto) {
        UUID id = UUID.randomUUID();
        return new Project(id, projectDto.subject, projectDto.category, projectDto.content);
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public void setAuthorId(UUID authorId) {
        this.authorId = authorId;
    }
}
