package com.lms.library_management_system.service;

import com.lms.library_management_system.dto.UserDTO;
import com.lms.library_management_system.dto.UserSaveDTO;
import com.lms.library_management_system.dto.UserUpdateDTO;

import java.util.List;

public interface UserService {
    String addUser(UserSaveDTO userSaveDTO);

    List<UserDTO> getAllUsers();

    String updateUser(UserUpdateDTO userUpdateDTO);

    String deletePublisher(int id);
}
