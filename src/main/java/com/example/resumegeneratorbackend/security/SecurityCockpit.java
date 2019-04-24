package com.example.resumegeneratorbackend.security;

/*
 * Cockpit class to pass this values to our configuration for jwt in other classes
 */
public class SecurityCockpit {

    //constants
    public static final String SIGN_UP_URLS = "/api/users/auth/**";
    public static final String SECRET ="SecretKeyToGenJWTs";
    public static final String TOKEN_PREFIX= "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final long EXPIRATION_TIME = 300_000; //5 minutes TOKEN EXPIRATION TIME = 300_000 && 24hours =86400000ms

}
