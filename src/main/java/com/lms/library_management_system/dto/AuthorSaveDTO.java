package com.lms.library_management_system.dto;

import lombok.Data;

@Data
public class AuthorSaveDTO {

    private String authorName;

    public AuthorSaveDTO (){

    }

    public AuthorSaveDTO(String authorName) {
        this.authorName = authorName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }
}
