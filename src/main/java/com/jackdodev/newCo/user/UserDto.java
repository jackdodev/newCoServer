package com.jackdodev.newCo.user;

import java.time.LocalDate;

public class UserDto {
    public int id;

    public String firstName;

    public String lastName;

    public LocalDate dateOfBirth;

    static public User toEntity(UserDto userDto) {
        return new User(userDto.firstName, userDto.lastName, userDto.dateOfBirth);
    }
}
