package com.example.resumegeneratorbackend.ExceptionHandler;

public class LoginInvalidResponse {

    private String username;
    private String password;

    public LoginInvalidResponse() {
        this.username = "Wrong Username";
        this.password = "Wrong Password";
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
