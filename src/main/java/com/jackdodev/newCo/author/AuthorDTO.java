package com.jackdodev.newCo.author;

import java.time.LocalDate;

public class AuthorDTO {
    public String firstName;
    public String lastName;
    public LocalDate dateOfBirth;

    public AuthorDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static AuthorDTO convertAuthorDTOFrommAuthor(Author author) {
        return new AuthorDTO(author.getFirstName(), author.getLastName());
    }
}
