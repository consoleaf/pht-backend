package com.example.demo.contract;

import java.util.Date;

public class ErrorResponse {
    public ErrorResponse() {
        this.timestamp = new Date();
    }

    public ErrorResponse(String message) {
        this();
        this.message = message;
    }

    public ErrorResponse(Exception e) {
        this(e.getMessage());
    }

    private String message;
    private Date timestamp;
    private Object data;

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
