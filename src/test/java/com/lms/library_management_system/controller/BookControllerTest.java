package com.lms.library_management_system.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lms.library_management_system.dto.BookDTO;
import com.lms.library_management_system.dto.BookSaveDTO;
import com.lms.library_management_system.dto.BookUpdateDTO;
import com.lms.library_management_system.service.BookService;
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
public class BookControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BookService bookService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSaveBook() throws Exception {
        BookSaveDTO bookSaveDTO = new BookSaveDTO();
        bookSaveDTO.setBookTitle("Test Book");

        when(bookService.addBook(bookSaveDTO)).thenReturn("Test Book");

        mockMvc.perform(post("/api/v1/book/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bookSaveDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllBooks() throws Exception {
        BookDTO book1 = new BookDTO(1, "Test Book 1", 1, 1);
        BookDTO book2 = new BookDTO(2, "Test Book 2", 2, 2);
        List<BookDTO> bookList = Arrays.asList(book1, book2);

        when(bookService.getAllBooks()).thenReturn(bookList);

        mockMvc.perform(get("/api/v1/book/getAllBooks"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].bookTitle").value("Test Book 1"))
                .andExpect(jsonPath("$[1].bookTitle").value("Test Book 2"));
    }

    @Test
    public void testUpdateBook() throws Exception {
        BookUpdateDTO bookUpdateDTO = new BookUpdateDTO();
        bookUpdateDTO.setBookId(1);
        bookUpdateDTO.setBookTitle("Updated Book");

        when(bookService.updateBook(bookUpdateDTO)).thenReturn("Updated Book");

        mockMvc.perform(post("/api/v1/book/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(bookUpdateDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteBook() throws Exception {
        when(bookService.deleteBook(1)).thenReturn("Book deleted successfully");

        mockMvc.perform(delete("/api/v1/book/delete/1"))
                .andExpect(status().isOk());
    }
}
