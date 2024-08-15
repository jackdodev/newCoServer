package com.jackdodev.newCo.user;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User createUser(UserDto userDto) {
        User user = new User(userDto.firstName, userDto.lastName, userDto.dateOfBirth);
        userRepository.save(user);
        return null;
    }

    @Transactional
    public User getUserById(long id) {
        return null;
    }

    public List<User> getAllUsers() {
        Iterable<User> allUsers = userRepository.findAll();
        allUsers.forEach(user -> System.out.println(user.getFirstName()));

        return null;
    }
}
