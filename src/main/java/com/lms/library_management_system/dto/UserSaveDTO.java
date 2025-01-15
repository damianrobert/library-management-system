package com.lms.library_management_system.dto;

import lombok.Data;

@Data
public class UserSaveDTO {

    private String userName;

    private String userEmail;

    public UserSaveDTO() {}

    public UserSaveDTO(String userName, String userEmail) {
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
