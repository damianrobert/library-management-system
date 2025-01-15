package com.lms.library_management_system.service.IMPL;

import com.lms.library_management_system.dto.PublisherDTO;
import com.lms.library_management_system.dto.PublisherSaveDTO;
import com.lms.library_management_system.dto.PublisherUpdateDTO;
import com.lms.library_management_system.entity.Publisher;
import com.lms.library_management_system.repo.PublisherRepo;
import com.lms.library_management_system.service.PublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class PublisherServiceIMPL implements PublisherService {

    @Autowired
    PublisherRepo publisherRepo;

    @Override
    public String addPublisher(PublisherSaveDTO publisherSaveDTO) {

        Publisher publisher = new Publisher(
                publisherSaveDTO.getPublisherName()
        );
        publisherRepo.save(publisher);
        return publisher.getPublisherName();
    }

    @Override
    public List<PublisherDTO> getAllPublishers() {
        List<Publisher> getPublishers = publisherRepo.findAll();
        List<PublisherDTO> publisherDTOList = new ArrayList<>();

        for (Publisher publisher : getPublishers) {
            PublisherDTO publisherDTO = new PublisherDTO(
                    publisher.getPublisherId(),
                    publisher.getPublisherName()
            );
            publisherDTOList.add(publisherDTO);
        }

        return publisherDTOList;
    }

    @Override
    public String updatePublisher(PublisherUpdateDTO publisherUpdateDTO) {

        if(publisherRepo.existsById(publisherUpdateDTO.getPublisherId())) {
            Publisher publisher = publisherRepo.getById(publisherUpdateDTO.getPublisherId());
            publisher.setPublisherName(publisherUpdateDTO.getPublisherName());

            publisherRepo.save(publisher);
            return publisher.getPublisherName();
        } else {
            System.out.println("Publisher not found");
        }

        return null;
    }

    @Override
    public String deletePublisher(int id) {
        if(publisherRepo.existsById(id)) {
            publisherRepo.deleteById(id);
        } else {
            System.out.println("Publisher not found");
        }

        return null;
    }
}
