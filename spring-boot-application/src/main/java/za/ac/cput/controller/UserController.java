package za.ac.cput.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import za.ac.cput.domain.User;
import za.ac.cput.service.UserService;

import java.util.List;

/* UserController.java
   User Controller Class
   Author: Your Name (Your Student Number)
   Date: 17 September 2025
 */
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/read/{userId}")
    public User readUser(@PathVariable String userId) {
        return userService.readUser(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));
    }

    @PutMapping("/update")
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable String userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/test")
    public String test() {
        return "User controller works!";
    }
}
