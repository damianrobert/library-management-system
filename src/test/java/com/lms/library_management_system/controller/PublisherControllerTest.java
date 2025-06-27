package com.lms.library_management_system.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lms.library_management_system.dto.PublisherDTO;
import com.lms.library_management_system.dto.PublisherSaveDTO;
import com.lms.library_management_system.dto.PublisherUpdateDTO;
import com.lms.library_management_system.service.PublisherService;
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
public class PublisherControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PublisherService publisherService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void testSavePublisher() throws Exception {
        PublisherSaveDTO publisherSaveDTO = new PublisherSaveDTO();
        publisherSaveDTO.setPublisherName("Test Publisher");

        when(publisherService.addPublisher(publisherSaveDTO)).thenReturn("Test Publisher");

        mockMvc.perform(post("/api/v1/publisher/save")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(publisherSaveDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void testGetAllPublishers() throws Exception {
        PublisherDTO publisher1 = new PublisherDTO(1, "Test Publisher 1");
        PublisherDTO publisher2 = new PublisherDTO(2, "Test Publisher 2");
        List<PublisherDTO> publisherList = Arrays.asList(publisher1, publisher2);

        when(publisherService.getAllPublishers()).thenReturn(publisherList);

        mockMvc.perform(get("/api/v1/publisher/getAllPublishers"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].publisherName").value("Test Publisher 1"))
                .andExpect(jsonPath("$[1].publisherName").value("Test Publisher 2"));
    }

    @Test
    public void testUpdatePublisher() throws Exception {
        PublisherUpdateDTO publisherUpdateDTO = new PublisherUpdateDTO();
        publisherUpdateDTO.setPublisherId(1);
        publisherUpdateDTO.setPublisherName("Updated Publisher");

        when(publisherService.updatePublisher(publisherUpdateDTO)).thenReturn("Updated Publisher");

        mockMvc.perform(post("/api/v1/publisher/update")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(publisherUpdateDTO)))
                .andExpect(status().isOk());
    }

    @Test
    public void testDeletePublisher() throws Exception {
        when(publisherService.deletePublisher(1)).thenReturn("Publisher deleted successfully");

        mockMvc.perform(delete("/api/v1/publisher/delete/1"))
                .andExpect(status().isOk());
    }
}
