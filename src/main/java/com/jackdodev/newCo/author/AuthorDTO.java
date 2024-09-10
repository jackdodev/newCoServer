package com.jackdodev.newCo.author;

import java.time.LocalDate;
import java.util.UUID;

public class AuthorDTO {
    public String firstName;
    public String lastName;
    public LocalDate dateOfBirth;

    public void AuthorDTO(String firstName, String lastName, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
    }
}
