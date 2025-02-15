package com.lms.library_management_system.dto;

import lombok.Data;

@Data
public class PublisherDTO {

    private int publisherId;
    private String publisherName;

    public PublisherDTO() {
    }

    public PublisherDTO(int publisherId, String publisherName) {
        this.publisherId = publisherId;
        this.publisherName = publisherName;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
}
