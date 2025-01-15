package com.lms.library_management_system.dto;

import lombok.Data;

@Data
public class PublisherSaveDTO {

    private String publisherName;

    public PublisherSaveDTO() {
    }

    public PublisherSaveDTO(String publisherName) {
        this.publisherName = publisherName;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
}
