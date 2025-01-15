package com.lms.library_management_system.dto;


import lombok.Data;

@Data
public class BookSaveDTO {

    private String bookTitle;

    private int authorId;

    private int publisherId;

    public BookSaveDTO() {}

    public BookSaveDTO(String bookTitle, int authorId, int publisherId) {
        this.bookTitle = bookTitle;
        this.authorId = authorId;
        this.publisherId = publisherId;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public int getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(int publisherId) {
        this.publisherId = publisherId;
    }
}
