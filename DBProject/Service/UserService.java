package com.demo.DBProject.Service;

import com.demo.DBProject.Model.User;
import com.demo.DBProject.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    
    private final UserRepository userRepository;


    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public boolean addUser(User user) {
        userRepository.save(user);
        return false;
    }


    public void putUser(User newUser, Integer id) {
        User oldUser = userRepository.findById(id).get();
        oldUser.setEmail(newUser.getEmail());
        oldUser.setUsername(newUser.getUsername());
        oldUser.setPassword(newUser.getPassword());
        userRepository.save(oldUser);
    }

    public void deleteUser(Integer id) {
        userRepository.deleteById(id);
    }
}
