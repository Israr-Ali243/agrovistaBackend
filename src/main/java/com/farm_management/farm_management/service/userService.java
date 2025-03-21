package com.farm_management.farm_management.service;

import com.farm_management.farm_management.DTO.UserDTO;
import com.farm_management.farm_management.entity.User;

import java.util.List;

public interface userService {
    UserDTO registerUser (User user);
    UserDTO getUserById(int id);
    List<UserDTO> getAllUsers();
    UserDTO updateUser(UserDTO userDTO);
}
