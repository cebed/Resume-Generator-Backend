package com.example.resumegeneratorbackend.ExceptionHandler;


/*
 * This class is a replace of jason object that we want to return when the response is invalid
 * This because we want to have a clearer message of what went wrong
 * This helps in frontend to response the frontend with relevant error instead of 401 unauthorized bad message
 */
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
