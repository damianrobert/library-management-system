package com.lms.library_management_system.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lms.library_management_system.dto.UserDTO;
import com.lms.library_management_system.dto.UserSaveDTO;
import com.lms.library_management_system.dto.UserUpdateDTO;
import com.lms.library_management_system.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserService userService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSaveUser() throws Exception {
        UserSaveDTO userSaveDTO = new UserSaveDTO();
        userSaveDTO.setUserName("Test User");
        userSaveDTO.setUserEmail("test@example.com");

        when(userService.addUser(userSaveDTO)).thenReturn("Test User");

        mockMvc.perform(post("/api/v1/user/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userSaveDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllUsers() throws Exception {
        UserDTO user1 = new UserDTO(1, "Test User 1", "test1@example.com");
        UserDTO user2 = new UserDTO(2, "Test User 2", "test2@example.com");
        List<UserDTO> userList = Arrays.asList(user1, user2);

        when(userService.getAllUsers()).thenReturn(userList);

        mockMvc.perform(get("/api/v1/user/getAllUsers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].userName").value("Test User 1"))
                .andExpect(jsonPath("$[1].userName").value("Test User 2"));
    }

    @Test
    public void testUpdateUser() throws Exception {
        UserUpdateDTO userUpdateDTO = new UserUpdateDTO();
        userUpdateDTO.setUserId(1);
        userUpdateDTO.setUserName("Updated User");
        userUpdateDTO.setUserEmail("updated@example.com");

        when(userService.updateUser(userUpdateDTO)).thenReturn("Updated User");

        mockMvc.perform(post("/api/v1/user/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(userUpdateDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteUser() throws Exception {
        when(userService.deletePublisher(1)).thenReturn("User deleted successfully");

        mockMvc.perform(delete("/api/v1/user/delete/1"))
                .andExpect(status().isOk());
    }
}
