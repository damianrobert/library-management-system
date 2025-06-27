package com.lms.library_management_system.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lms.library_management_system.dto.AuthorDTO;
import com.lms.library_management_system.dto.AuthorSaveDTO;
import com.lms.library_management_system.dto.AuthorUpdateDTO;
import com.lms.library_management_system.service.AuthorService;
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
public class AuthorControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AuthorService authorService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSaveAuthor() throws Exception {
        AuthorSaveDTO authorSaveDTO = new AuthorSaveDTO();
        authorSaveDTO.setAuthorName("Test Author");

        when(authorService.addAuthor(authorSaveDTO)).thenReturn("Test Author");

        mockMvc.perform(post("/api/v1/author/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(authorSaveDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllAuthors() throws Exception {
        AuthorDTO author1 = new AuthorDTO(1, "Test Author 1");
        AuthorDTO author2 = new AuthorDTO(2, "Test Author 2");
        List<AuthorDTO> authorList = Arrays.asList(author1, author2);

        when(authorService.getAllAuthors()).thenReturn(authorList);

        mockMvc.perform(get("/api/v1/author/getAllAuthors"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].authorName").value("Test Author 1"))
                .andExpect(jsonPath("$[1].authorName").value("Test Author 2"));
    }

    @Test
    public void testUpdateAuthor() throws Exception {
        AuthorUpdateDTO authorUpdateDTO = new AuthorUpdateDTO();
        authorUpdateDTO.setAuthorId(1);
        authorUpdateDTO.setAuthorName("Updated Author");

        when(authorService.updateAuthor(authorUpdateDTO)).thenReturn("Updated Author");

        mockMvc.perform(post("/api/v1/author/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(authorUpdateDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteAuthor() throws Exception {
        when(authorService.deleteAuthor(1)).thenReturn("Author deleted successfully");

        mockMvc.perform(delete("/api/v1/author/delete/1"))
                .andExpect(status().isOk());
    }
}
