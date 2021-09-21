package com.example.listingapp.endPoint;

import com.example.listingapp.entity.User;
import com.example.listingapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserEndPoint {

    private final UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getById(int id) {
        return userService.getUserById(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @PutMapping
    public ResponseEntity<User> updateUser(@RequestBody User user) {
        User userById = userService.getUserById(user.getId());
        if (userById != null) {
            User body = userService.addUser(user);
            return ResponseEntity
                    .ok().body(body);
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{id}")
    public void deleteUSer(@PathVariable("id") int id) {
        userService.deleteUserByID(id);
    }

}
