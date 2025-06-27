package com.lms.library_management_system.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lms.library_management_system.dto.BorrowDTO;
import com.lms.library_management_system.dto.BorrowSaveDTO;
import com.lms.library_management_system.dto.BorrowUpdateDTO;
import com.lms.library_management_system.service.BorrowService;
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
public class BorrowControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private BorrowService borrowService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSaveBorrow() throws Exception {
        BorrowSaveDTO borrowSaveDTO = new BorrowSaveDTO();
        borrowSaveDTO.setBookId(1);
        borrowSaveDTO.setUserId(1);
        borrowSaveDTO.setBorrowDate("2025-06-27");
        borrowSaveDTO.setReturnDate("2025-07-27");

        when(borrowService.addBorrow(borrowSaveDTO)).thenReturn("Borrowed Successfully");

        mockMvc.perform(post("/api/v1/borrow/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(borrowSaveDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllBorrows() throws Exception {
        BorrowDTO borrow1 = new BorrowDTO(1, 1, 1, "2025-06-27", "2025-07-27");
        BorrowDTO borrow2 = new BorrowDTO(2, 2, 2, "2025-06-28", "2025-07-28");
        List<BorrowDTO> borrowList = Arrays.asList(borrow1, borrow2);

        when(borrowService.getAllBorrows()).thenReturn(borrowList);

        mockMvc.perform(get("/api/v1/borrow/getAllBorrows"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].borrowId").value(1))
                .andExpect(jsonPath("$[1].borrowId").value(2));
    }

    @Test
    public void testUpdateBorrow() throws Exception {
        BorrowUpdateDTO borrowUpdateDTO = new BorrowUpdateDTO();
        borrowUpdateDTO.setBorrowId(1);
        borrowUpdateDTO.setReturnDate("2025-08-27");

        when(borrowService.updateBorrow(borrowUpdateDTO)).thenReturn("Borrow updated successfully");

        mockMvc.perform(post("/api/v1/borrow/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(borrowUpdateDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeleteBorrow() throws Exception {
        when(borrowService.deleteBorrow(1)).thenReturn("Borrow deleted successfully");

        mockMvc.perform(delete("/api/v1/borrow/delete/1"))
                .andExpect(status().isOk());
    }
}
