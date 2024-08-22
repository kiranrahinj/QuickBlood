package com.QuickBlood.Controller;

import com.QuickBlood.Entity.User;
import com.QuickBlood.Service.UserService;
import com.QuickBlood.Service.impl.UserServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/addUser")
    public void addUser(@RequestBody User u) {
        userService.addUser(u);
    }

    @PutMapping("/upadateUser")
    public String updateUser(@RequestParam String name, @RequestBody User u) {
        return userService.updateUser(name, u);
    }

    @GetMapping("/userName")
    public User getUser(@RequestParam String name) {
        return userService.findUserByName(name);
    }
    @GetMapping
    public List<User> getUsers() {
        return userService.findUsers();
    }
    @GetMapping("/bloodType")
    public List<User> getUserByBloodType(@RequestParam String bloodType) {
        return userService.findUserByBloodType(bloodType);
    }

    @GetMapping("/locationAndBloodType")
    public List<User> locationAndBloodTYpe(@RequestParam String bloodType, @RequestParam String location) {
        return userService.findUserByBloodTypeAndLocation(bloodType, location);
    }

}
