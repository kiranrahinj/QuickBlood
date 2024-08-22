package com.QuickBlood.Service;

import com.QuickBlood.DTO.UserDTO;
import com.QuickBlood.Entity.User;
import org.springframework.stereotype.Service;

import java.util.*;

public interface UserService {

    public UserDTO addUser(UserDTO user);
    public String updateUser(String name, UserDTO u);
    public UserDTO findUserByName(String name);
    public List<UserDTO> findUserByBloodType(String name);
    public List<UserDTO> findUserByBloodTypeAndLocation(String name,String location);

}
