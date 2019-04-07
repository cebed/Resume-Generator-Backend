package com.example.resumegeneratorbackend.ExceptionHandler;

public class UsernameOrEmailExistResponse {

    private String username;

    public UsernameOrEmailExistResponse(String username) {
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
