package com.QuickBlood.Service.impl;

import com.QuickBlood.Entity.User;
import com.QuickBlood.Exception.QuickBloodUtilsException;
import com.QuickBlood.Repository.UserRepository;
import com.QuickBlood.Service.UserService;
import com.QuickBlood.Utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User addUser(User user) {
        Optional<User> user1= userRepository.findByEmail(user.getEmail());
        Optional<User> user2= userRepository.findByMobileNumber(user.getMobileNumber());
        if(user1.isPresent()) {
            QuickBloodUtilsException.propogateBadRequestExcetpion("Email is already present", ResponseCode.BAD_REQUEST);
        }
        if(user2.isPresent()) {
            QuickBloodUtilsException.propogateBadRequestExcetpion("Mobile Number is already present", ResponseCode.BAD_REQUEST);
        }
        userRepository.save(user);
        return user;
    }


    @Override
    public String updateUser(String name, User u) {
        Optional<User> user1=userRepository.findByName(name);
        if(user1.isEmpty()){
            QuickBloodUtilsException.propogateBadRequestExcetpion("User is not present", ResponseCode.BAD_REQUEST);
        }
        User user=user1.get();
        if(u.getName()!=null)user.setName(u.getName());
        if(u.getBloodType()!=null)user.setBloodType(u.getBloodType());
        if(u.getLocation()!=null)user.setLocation(u.getLocation());
        if(u.getMobileNumber()!=null)user.setMobileNumber(u.getMobileNumber());
        userRepository.save(user);

        return "User is updated";
    }

    @Override
    public User findUserByName(String name) {
        Optional<User> user1=userRepository.findByName(name);
        if(user1.isEmpty()){
            QuickBloodUtilsException.propogateBadRequestExcetpion("User is not present", ResponseCode.BAD_REQUEST);
        }
        return userRepository.findByName(name).get();
    }

    @Override
    public List<User> findUserByBloodType(String bloodType) {
        if(bloodType.length()==3 &&bloodType.charAt(2)!='-'){
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
        if(bloodType.length()==3 &&bloodType.charAt(2)!='-'){
            char arr[]=bloodType.toCharArray();
            arr[2]='+';
            bloodType=String.valueOf(arr);
        }
        return userRepository.findByBloodTypeAndLocation(bloodType,location);
    }
}
