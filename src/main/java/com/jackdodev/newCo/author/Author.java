package com.jackdodev.newCo.author;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    private UUID id;

    private String firstName;

    private String lastName;

    private LocalDate dateOfBirth;

    public Author() {}

    public Author(UUID id, String firstName, String lastName, LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }

    public static Author convertAuthorFromAuthorDTO(AuthorDTO dto) {
        UUID id = UUID.randomUUID();
        return new Author(id, dto.firstName, dto.lastName, dto.dateOfBirth);
    }

    public UUID getId() {
        return this.id;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }
}
