package com.example.demo.model.response;

import com.example.demo.model.request.UpdateUserRequestModel;
import com.example.demo.model.request.UserRequestModel;

public class UserRest {
    public UserRest() {
    }

    public UserRest(UserRequestModel model) {
        this.userName = model.getUserName();
        this.email = model.getEmail();
    }

    public void update(UpdateUserRequestModel model) {
        this.userName = model.getUserName();
        this.email = model.getEmail();
    }

    private String userName;
    private String email;
    private String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

}
