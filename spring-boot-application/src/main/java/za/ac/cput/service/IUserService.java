package za.ac.cput.service;

import za.ac.cput.domain.User;
import java.util.List;
import java.util.Optional;

public interface IUserService {
    User createUser(User user);
    Optional<User> readUser(String id);
    User updateUser(User user);
    void deleteUser(String id);
    List<User> getAllUsers();
}
