package com.QuickBlood.Service;

import com.QuickBlood.Entity.User;
import org.springframework.stereotype.Service;

import java.util.*;

public interface UserService {

    public void addUser(User user);
    public String updateUser(String name, User u);
    public User findUserByName(String name);
    public List<User> findUserByBloodType(String name);
    public List<User> findUserByBloodTypeAndLocation(String name,String location);

}
