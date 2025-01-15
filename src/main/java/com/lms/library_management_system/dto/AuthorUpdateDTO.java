package com.lms.library_management_system.dto;

import lombok.Data;

@Data
public class AuthorUpdateDTO {

    private int authorId;

    private String authorName;

    public AuthorUpdateDTO() {}

    public AuthorUpdateDTO(int authorId, String authorName) {
        this.authorId = authorId;
        this.authorName = authorName;
    }

    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
