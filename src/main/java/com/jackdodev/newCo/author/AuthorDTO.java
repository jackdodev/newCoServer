package com.jackdodev.newCo.author;

import java.time.LocalDate;

public class AuthorDTO {
    public String firstName;
    public String lastName;
    public LocalDate dateOfBirth;

    public void AuthorDTO(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
