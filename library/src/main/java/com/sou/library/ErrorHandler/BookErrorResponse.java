package com.sou.library.ErrorHandler;

import java.util.List;

public class BookErrorResponse {
    private int status;
    private String message;
    private String errorCode;
    private String timestamp;
    private List<String> errors;

    public BookErrorResponse(int status, String message, String errorCode, String timestamp, List<String> errors) {
        this.status = status;
        this.message = message;
        this.errorCode = errorCode;
        this.timestamp = timestamp;
        this.errors = errors;
    }


    public BookErrorResponse(int status, String message, String errorCode, String timestamp) {
        this(status, message, errorCode, timestamp, null);
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setErrors(List<String> errors) {
        this.errors = errors;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public List<String> getErrors() {
        return errors;
    }
}