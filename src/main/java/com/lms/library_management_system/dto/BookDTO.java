package com.lms.library_management_system.dto;

import com.lms.library_management_system.entity.Author;
import com.lms.library_management_system.entity.Publisher;
import lombok.Data;

@Data
public class BookDTO {

    private int bookId;

    private String bookTitle;

    private int authorId;

    private int publisherId;

    public BookDTO() {}

    public BookDTO(int bookId, String bookTitle, int authorId, int publisherId) {
        this.bookId = bookId;
        this.bookTitle = bookTitle;
        this.authorId = authorId;
        this.publisherId = publisherId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
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
