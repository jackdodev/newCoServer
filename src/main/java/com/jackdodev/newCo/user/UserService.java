package com.jackdodev.newCo.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(UserDto userDto) {
        User user = new User(userDto.firstName, userDto.lastName, userDto.dateOfBirth);
        return null;
    }

    @Transactional
    public User getUserById(long id) {
        return null;
    }
}
