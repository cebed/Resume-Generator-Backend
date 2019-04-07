package com.example.resumegeneratorbackend.payloads;

import javax.validation.constraints.NotBlank;

/*
 *  What the client is going to send to the server is a jason object
 *  Containing username and password
 *  This type of request is what we will get in our request body when user tries log in
 */
public class LoginRequests {

    @NotBlank(message = "email can not be blank!")
    private String username;

    @NotBlank(message = "Password can not be blank!")
    private String password;

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
