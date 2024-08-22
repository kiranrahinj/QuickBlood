package com.QuickBlood.Service.impl;

import com.QuickBlood.Entity.User;
import com.QuickBlood.Repository.UserRepository;
import com.QuickBlood.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public String updateUser(String name, User u) {
        User user=findUserByName(name);

        if(u.getName()!=null)user.setName(u.getName());
        if(u.getBloodType()!=null)user.setBloodType(u.getBloodType());
        if(u.getLocation()!=null)user.setLocation(u.getLocation());
        if(u.getMobileNumber()!=null)user.setMobileNumber(u.getMobileNumber());
        userRepository.save(user);

        return "User is updated";
    }

    @Override
    public User findUserByName(String name) {
        return userRepository.findByName(name);
    }

    @Override
    public List<User> findUserByBloodType(String bloodType) {
        if(bloodType.charAt(2)!='-'){
            char arr[]=bloodType.toCharArray();
            arr[2]='+';
            bloodType=String.valueOf(arr);
        }
        return userRepository.findByBloodType(bloodType);
    }

    public List<User> findUsers() {
        return userRepository.findAll();
    }

    @Override
    public List<User> findUserByBloodTypeAndLocation(String bloodType,String location) {
        if(bloodType.charAt(2)!='-'){
            char arr[]=bloodType.toCharArray();
            arr[2]='+';
            bloodType=String.valueOf(arr);
        }
        return userRepository.findByBloodTypeAndLocation(bloodType,location);
    }
}
