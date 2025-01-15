package com.lms.library_management_system.controller;

import com.lms.library_management_system.dto.PublisherDTO;
import com.lms.library_management_system.dto.PublisherSaveDTO;
import com.lms.library_management_system.dto.PublisherUpdateDTO;
import com.lms.library_management_system.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/publisher")
public class PublisherController {

    @Autowired
    private PublisherService publisherService;

    @PostMapping(path = "/save")
    public String savePublisher(@RequestBody PublisherSaveDTO publisherSaveDTO){

        String publisherName = publisherService.addPublisher(publisherSaveDTO);
        return publisherName;
    }

    @GetMapping(path = "/getAllPublishers")
    public List<PublisherDTO> getAllPublishers(){
        List<PublisherDTO> allPublishers = publisherService.getAllPublishers();
        return allPublishers;
    }

    @PostMapping(path = "/update")
    public String updatePublisher(@RequestBody PublisherUpdateDTO publisherUpdateDTO){
        String publisherName = publisherService.updatePublisher(publisherUpdateDTO);
        return publisherName;
    }

    @DeleteMapping(path = "/delete/{id}")
    public String deletePublisher(@PathVariable(value = "id") int id){
        String publisherName = publisherService.deletePublisher(id);
        return "Publisher deleted successfully";
    }
}
