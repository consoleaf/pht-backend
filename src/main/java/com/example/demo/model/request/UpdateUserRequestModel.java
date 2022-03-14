package com.example.demo.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UpdateUserRequestModel {
    @NotNull
    private String userName;
    @NotNull
    @Email
    private String email;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
