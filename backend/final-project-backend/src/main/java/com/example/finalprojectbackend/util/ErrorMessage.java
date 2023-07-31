package com.example.finalprojectbackend.util;

public enum ErrorMessage {

    EMAIL_NOT_SENT("Error sending email"),
    EMAIL_SENT("Email sent successfully"),
    INFORMATION_NOT_FOUND("Information not found"),
    INVALID_CREDENTIALS("Invalid credentials");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
