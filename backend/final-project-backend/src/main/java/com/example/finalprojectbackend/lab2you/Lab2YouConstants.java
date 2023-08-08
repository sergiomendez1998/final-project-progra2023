package com.example.finalprojectbackend.lab2you;

public class Lab2YouConstants {

    public static final String _LAB2YOU_REASON_CODE_UNEXPECTED_EXCEPTION = "there was an unexpected exception";
    public enum lab2YouErrorCodes {

       USER_ALREADY_EXISTS("The user already exists"),
         USER_NOT_FOUND("The user was not found"),

        EMAIL_NOT_SENT("The registration email was not sent"),

        USER_NOT_CREATED("The user was not created"),

        USER_NOT_UPDATED("The user was not updated"),

        USER_NOT_DELETED("The user was not deleted"),

        USER_NOT_AUTHENTICATED("The user was not authenticated"),
        ACTION_UNSUPPORTED("The action is not supported");

        String description;

        public String getDescription() {
            return this.description;
        }

        lab2YouErrorCodes(String description) {
            this.description = description;
        }
    }

    public enum lab2YouSuccessCodes {
        EMAIL_SENT("The registration email was sent successfully"),
        USER_CREATED("The user was created successfully");

        String description;

        public String getDescription() {
            return this.description;
        }

        lab2YouSuccessCodes(String description) {
            this.description = description;
        }


    }

    public enum lab2YouRoles {
        ADMIN("ROLE_ADMIN"),
        USER("ROLE_USER"),
        ANALYST("ROLE_ANALYST");

        private String role;

        lab2YouRoles(String role) {
            this.role = role;
        }

        public String getRole() {
            return role;
        }

    }

}
