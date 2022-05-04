package com.softvision.library.models;

import java.util.Date;

public class LibraryError {
    private String message;
    private int code;
    private Date timestamp;
    private String path;

    public LibraryError(String message, int code, Date timestamp, String path) {
        this.message = message;
        this.code = code;
        this.timestamp = timestamp;
        this.path = path;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
