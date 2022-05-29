package com.demo.DBProject.Controller;

import com.demo.DBProject.Model.User;
import com.demo.DBProject.Service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping
    public ResponseEntity getUsers() {
        return ResponseEntity.status(200).body(userService.getUsers());
    }

    @PostMapping
    public ResponseEntity addUser(@RequestBody @Valid User user) {
        userService.addUser(user);
        return ResponseEntity.status(200).body("New user added");
    }

    @PutMapping("/{id}")
    public ResponseEntity putUser(@RequestBody User user, @PathVariable Integer id) {
        userService.putUser(user, id);
        return ResponseEntity.status(200).body("New user updated");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return ResponseEntity.status(200).body("New user deleted");
    }
}
