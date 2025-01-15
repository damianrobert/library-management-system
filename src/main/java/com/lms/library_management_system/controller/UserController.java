package com.lms.library_management_system.controller;

import com.lms.library_management_system.dto.*;
import com.lms.library_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping(path = "/save")
    public String saveUser(@RequestBody UserSaveDTO userSaveDTO){
        String userName = userService.addUser(userSaveDTO);
        return userName;
    }

    @GetMapping(path = "/getAllUsers")
    public List<UserDTO> getAllUsers(){
        List<UserDTO> allUsers = userService.getAllUsers();
        return allUsers;
    }

    @PostMapping(path = "/update")
    public String updateUser(@RequestBody UserUpdateDTO userUpdateDTO){
        String userName = userService.updateUser(userUpdateDTO);
        return userName;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deleteUser(@PathVariable(value = "id") int id){
        String userName = userService.deletePublisher(id);
        return "User deleted successfully";
    }

}
