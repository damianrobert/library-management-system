package com.lms.library_management_system.service;

import com.lms.library_management_system.dto.PublisherDTO;
import com.lms.library_management_system.dto.PublisherSaveDTO;
import com.lms.library_management_system.dto.PublisherUpdateDTO;

import java.util.List;

public interface PublisherService {
    String addPublisher(PublisherSaveDTO publisherSaveDTO);

    List<PublisherDTO> getAllPublishers();

    String updatePublisher(PublisherUpdateDTO publisherUpdateDTO);

    String deletePublisher(int id);
}
