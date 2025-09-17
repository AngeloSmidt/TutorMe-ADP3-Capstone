package za.ac.cput.service;

/*  UserService.java
    User Service class
    Author: Hope - 221174109
    Date: 25 May 2025
 */

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.User;
import za.ac.cput.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements IUserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User createUser(User user) {
        return this.repository.save(user);
    }

    @Override
    public Optional<User> readUser(String id) {
        return this.repository.findById(id);
    }

    @Override
    public User updateUser(User user) {
        return this.repository.save(user);
    }

    @Override
    public void deleteUser(String id) {
        this.repository.deleteById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return this.repository.findAll();
    }
}
