package com.example.resumegeneratorbackend.payloads;

/*
 * This class is needed when we have a valid user and when we return back a jason webtoken
 * Response so we can pass to our react frontend
 * redux can keep the token and send it back with any request
 * As long as the token is valid the user will be able to use the app.
 */
public class JWTLoginSuccessRes {
    private boolean success;
    private String token;

    public JWTLoginSuccessRes(boolean success, String token) {

        this.success = success;
        this.token = token;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "JWTLoginSuccessRes{" +
                "success=" + success +
                ", token='" + token + '\'' +
                '}';
    }
}
