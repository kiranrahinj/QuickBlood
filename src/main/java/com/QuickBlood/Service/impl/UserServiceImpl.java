package com.QuickBlood.Service.impl;

import com.QuickBlood.DTO.UserDTO;
import com.QuickBlood.Entity.User;
import com.QuickBlood.Exception.QuickBloodUtilsException;
import com.QuickBlood.Repository.UserRepository;
import com.QuickBlood.Service.UserService;
import com.QuickBlood.Utils.ResponseCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO addUser(UserDTO user) {
        Optional<User> user1 = userRepository.findByEmail(user.getEmail());
        Optional<User> user2 = userRepository.findByMobileNumber(user.getMobileNumber());
        if (user1.isPresent()) {
            QuickBloodUtilsException.propogateBadRequestExcetpion("Email is already present", ResponseCode.BAD_REQUEST);
        }
        if (user2.isPresent()) {
            QuickBloodUtilsException.propogateBadRequestExcetpion("Mobile Number is already present", ResponseCode.BAD_REQUEST);
        }
        userRepository.save(User.builder().name(user.getName()).email(user.getEmail()).bloodType(user.getBloodType()).
                            location(user.getLocation()).mobileNumber(user.getMobileNumber()).build());
        return user;
    }

    @Override
    public String updateUser(String name, UserDTO u) {
        Optional<User> user1 = userRepository.findByName(name);
        if (user1.isEmpty()) {
            QuickBloodUtilsException.propogateBadRequestExcetpion("User is not present", ResponseCode.BAD_REQUEST);
        }
        User user = user1.get();
        if (u.getName() != null) user.setName(u.getName());
        if (u.getBloodType() != null) user.setBloodType(u.getBloodType());
        if (u.getLocation() != null) user.setLocation(u.getLocation());
        if (u.getMobileNumber() != null) user.setMobileNumber(u.getMobileNumber());
        userRepository.save(user);

        return "User is updated";
    }

    @Override
    public UserDTO findUserByName(String name) {
        Optional<User> user1 = userRepository.findByName(name);
        if (user1.isEmpty()) {
            QuickBloodUtilsException.propogateBadRequestExcetpion("User is not present", ResponseCode.BAD_REQUEST);
        }
        User user=user1.get();

        return UserDTO.builder().name(user.getName()).email(user.getEmail()).location(user.getLocation()).bloodType(user.getBloodType())
                .mobileNumber(user.getMobileNumber()).build();
    }

    @Override
    public List<UserDTO> findUserByBloodType(String bloodType) {
        if (bloodType.length() == 3 && bloodType.charAt(2) != '-') {
            char arr[] = bloodType.toCharArray();
            arr[2] = '+';
            bloodType = String.valueOf(arr);
        }
        if (bloodType.length() == 2 && bloodType.charAt(1) != '-') {
            char arr[] = bloodType.toCharArray();
            arr[1] = '+';
            bloodType = String.valueOf(arr);
        }
        List<User> user=userRepository.findByBloodType(bloodType);

        List<UserDTO> userDTOS=new ArrayList<>();
        for(var k:user){
            userDTOS.add(
                    UserDTO.builder().name(k.getName()).email(k.getEmail()).location(k.getLocation()).bloodType(k.getBloodType())
                    .mobileNumber(k.getMobileNumber()).build()
            );
        }

        return userDTOS;
    }

    public List<UserDTO> findUsers() {
        List<User> user=userRepository.findAll();

        List<UserDTO> userDTOS=new ArrayList<>();
        for(var k:user){
            userDTOS.add(
                    UserDTO.builder().name(k.getName()).email(k.getEmail()).location(k.getLocation()).bloodType(k.getBloodType())
                            .mobileNumber(k.getMobileNumber()).build()
            );
        }
        return userDTOS;
    }

    @Override
    public List<UserDTO> findUserByBloodTypeAndLocation(String bloodType, String location) {
        if (bloodType.length() == 3 && bloodType.charAt(2) != '-') {
            char arr[] = bloodType.toCharArray();
            arr[2] = '+';
            bloodType = String.valueOf(arr);
        }
        if (bloodType.length() == 2 && bloodType.charAt(1) != '-') {
            char arr[] = bloodType.toCharArray();
            arr[1] = '+';
            bloodType = String.valueOf(arr);
        }
        List<User> user=userRepository.findByBloodTypeAndLocation(bloodType, location);

        List<UserDTO> userDTOS=new ArrayList<>();
        for(var k:user){
            userDTOS.add(
                    UserDTO.builder().name(k.getName()).email(k.getEmail()).location(k.getLocation()).bloodType(k.getBloodType())
                            .mobileNumber(k.getMobileNumber()).build()
            );
        }
        return userDTOS;
    }
}
