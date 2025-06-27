package com.lms.library_management_system.service.IMPL;

import com.lms.library_management_system.dto.UserDTO;
import com.lms.library_management_system.dto.UserSaveDTO;
import com.lms.library_management_system.dto.UserUpdateDTO;
import com.lms.library_management_system.entity.User;
import com.lms.library_management_system.repo.UserRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class UserServiceIMPLTest {

    @Mock
    private UserRepo userRepo;

    @InjectMocks
    private UserServiceIMPL userService;

    @Test
    public void testAddUser() {
        UserSaveDTO userSaveDTO = new UserSaveDTO();
        userSaveDTO.setUserName("Test User");
        userSaveDTO.setUserEmail("test@example.com");

        User user = new User(userSaveDTO.getUserName(), userSaveDTO.getUserEmail());

        when(userRepo.save(any(User.class))).thenReturn(user);

        String result = userService.addUser(userSaveDTO);

        assertEquals("Test User", result);
        verify(userRepo, times(1)).save(any(User.class));
    }

    @Test
    public void testGetAllUsers() {
        User user1 = new User(1, "Test User 1", "test1@example.com");
        User user2 = new User(2, "Test User 2", "test2@example.com");
        List<User> userList = Arrays.asList(user1, user2);

        when(userRepo.findAll()).thenReturn(userList);

        List<UserDTO> result = userService.getAllUsers();

        assertEquals(2, result.size());
        assertEquals("Test User 1", result.get(0).getUserName());
        assertEquals("Test User 2", result.get(1).getUserName());
        verify(userRepo, times(1)).findAll();
    }

    @Test
    public void testUpdateUser() {
        UserUpdateDTO userUpdateDTO = new UserUpdateDTO();
        userUpdateDTO.setUserId(1);
        userUpdateDTO.setUserName("Updated User");
        userUpdateDTO.setUserEmail("updated@example.com");

        User existingUser = new User(1, "Test User", "test@example.com");

        when(userRepo.existsById(1)).thenReturn(true);
        when(userRepo.getById(1)).thenReturn(existingUser);

        String result = userService.updateUser(userUpdateDTO);

        assertEquals("Updated User", result);
        verify(userRepo, times(1)).existsById(1);
        verify(userRepo, times(1)).getById(1);
        verify(userRepo, times(1)).save(any(User.class));
    }

    @Test
    public void testDeleteUser() {
        when(userRepo.existsById(1)).thenReturn(true);

        userService.deletePublisher(1);

        verify(userRepo, times(1)).existsById(1);
        verify(userRepo, times(1)).deleteById(1);
    }
}
