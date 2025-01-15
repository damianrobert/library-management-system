package com.lms.library_management_system.service.IMPL;

import com.lms.library_management_system.dto.UserDTO;
import com.lms.library_management_system.dto.UserSaveDTO;
import com.lms.library_management_system.dto.UserUpdateDTO;
import com.lms.library_management_system.entity.User;
import com.lms.library_management_system.repo.UserRepo;
import com.lms.library_management_system.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceIMPL implements UserService {

    @Autowired
    UserRepo userRepo;

    @Override
    public String addUser(UserSaveDTO userSaveDTO) {

        User user = new User(
                userSaveDTO.getUserName(),
                userSaveDTO.getUserEmail()
        );
        userRepo.save(user);
        return user.getUserName();
    }

    @Override
    public List<UserDTO> getAllUsers() {
        List<User> getUsers = userRepo.findAll();
        List<UserDTO> userDTOList = new ArrayList<>();

        for (User user : getUsers) {
            UserDTO userDTO = new UserDTO(
                    user.getUserId(),
                    user.getUserName(),
                    user.getUserEmail()
            );
            userDTOList.add(userDTO);
        }
        return userDTOList;
    }

    @Override
    public String updateUser(UserUpdateDTO userUpdateDTO) {
        if (userRepo.existsById(userUpdateDTO.getUserId())) {
            User user = userRepo.getById(userUpdateDTO.getUserId());
            user.setUserName(userUpdateDTO.getUserName());
            user.setUserEmail(userUpdateDTO.getUserEmail());

            userRepo.save(user);
            return user.getUserName();
        } else {
            System.out.println("User not found");
        }
        return null;
    }

    @Override
    public String deletePublisher(int id) {
        if(userRepo.existsById(id)) {
            userRepo.deleteById(id);
        } else {
            System.out.println("User not found");
        }
        return null;
    }
}
