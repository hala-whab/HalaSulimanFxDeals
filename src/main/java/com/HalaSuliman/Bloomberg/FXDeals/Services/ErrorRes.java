package com.HalaSuliman.Bloomberg.FXDeals.Services;

import java.time.LocalDateTime;
public class ErrorRes {
    private String error;
    private String message;
    private LocalDateTime timestamp;
    private int status;
    public ErrorRes(String error, String message, LocalDateTime timestamp, int status) {
        this.error = error;
        this.message = message;
        this.timestamp = timestamp;
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}