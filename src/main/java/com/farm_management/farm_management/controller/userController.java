package com.farm_management.farm_management.controller;

import com.farm_management.farm_management.DTO.UserDTO;
import com.farm_management.farm_management.entity.User;
import com.farm_management.farm_management.utils.RoleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import  com.farm_management.farm_management.service.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {
    @Autowired
    private userService userService;

    @PostMapping("/save")
    public ResponseEntity<UserDTO> registerUser(@RequestBody User user){
        return ResponseEntity.ok(userService.registerUser(user));
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable("id") int id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @GetMapping("/findAll")
    public ResponseEntity<List<UserDTO>> getAllUsers(){
        return ResponseEntity.ok(userService.getAllUsers());
    }
    @PutMapping("/update")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDTO){
        return ResponseEntity.ok(userService.updateUser(userDTO));
    }

}
