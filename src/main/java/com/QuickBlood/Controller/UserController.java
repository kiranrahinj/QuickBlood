package com.QuickBlood.Controller;

import com.QuickBlood.DTO.UserDTO;
import com.QuickBlood.Entity.User;
import com.QuickBlood.Exception.QuickBloodException;
import com.QuickBlood.Service.UserService;
import com.QuickBlood.Service.impl.UserServiceImpl;
import com.QuickBlood.Utils.ResponseCode;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Slf4j
@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
public class UserController {
    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/addUser")
    public ResponseEntity<?> addUser(@RequestBody @Valid UserDTO u) {
        try {
            return ResponseEntity.ok(userService.addUser(u));
        } catch (QuickBloodException exception) {
            throw exception;
        } catch (Exception ex) {
            throw new QuickBloodException(ex.getMessage(), HttpStatus.BAD_REQUEST, ResponseCode.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/upadateUser")
    public ResponseEntity<?> updateUser(@RequestParam @Valid String name, @RequestBody @Valid UserDTO u) {
        try {
            return ResponseEntity.ok(userService.updateUser(name, u));
        } catch (QuickBloodException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new QuickBloodException(ex.getMessage(), HttpStatus.BAD_REQUEST, ResponseCode.BAD_REQUEST);
        }

    }

    @GetMapping("/userName")
    public ResponseEntity<?> getUser(@RequestParam @Valid String name) {
        try{
            return ResponseEntity.ok(userService.findUserByName(name));
        }
        catch (QuickBloodException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new QuickBloodException(ex.getMessage(), HttpStatus.BAD_REQUEST, ResponseCode.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<?> getUsers() {
        try{
            return ResponseEntity.ok(userService.findUsers());
        }
        catch (QuickBloodException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new QuickBloodException(ex.getMessage(), HttpStatus.BAD_REQUEST, ResponseCode.BAD_REQUEST);
        }
    }

    @GetMapping("/bloodType")
    public ResponseEntity<?> getUserByBloodType(@RequestParam @Valid String bloodType) {
        try{
            return ResponseEntity.ok(userService.findUserByBloodType(bloodType));
        }
        catch (QuickBloodException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new QuickBloodException(ex.getMessage(), HttpStatus.BAD_REQUEST, ResponseCode.BAD_REQUEST);
        }
    }

    @GetMapping("/locationAndBloodType")
    public ResponseEntity<?> locationAndBloodTYpe(@RequestParam @Valid String bloodType, @RequestParam @Valid String location) {
        try{
            return ResponseEntity.ok(userService.findUserByBloodTypeAndLocation(bloodType, location));
        }
        catch (QuickBloodException ex) {
            throw ex;
        } catch (Exception ex) {
            throw new QuickBloodException(ex.getMessage(), HttpStatus.BAD_REQUEST, ResponseCode.BAD_REQUEST);
        }
    }

}
