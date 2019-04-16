package com.example.resumegeneratorbackend.security;

import com.example.resumegeneratorbackend.ExceptionHandler.LoginInvalidResponse;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import java.io.IOException;

/*
 * AuthenticationEntrypoint is a interface provides the implementation for method call commence
 */

@Component
public class JwtAuthentication implements AuthenticationEntryPoint{

    //This is called whenever an exception is thrown
    // because a user is trying to access a resource that requires authentication
    //exvis när vi gör GET för en api/users så kan vi få unauthorized i postman i form av 401 fel meddelande
    //vi vill ha ett bättre meddelande som vi kan använda i frontenden
    @Override
    public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
                         AuthenticationException e) throws IOException, ServletException {

        LoginInvalidResponse loginResponse = new LoginInvalidResponse();
        //we turn the invalidresponse to a jason object
        String jsonLoginResponse = new Gson().toJson(loginResponse);


        httpServletResponse.setContentType("application/json");
        httpServletResponse.setStatus(401);
        httpServletResponse.getWriter().print(jsonLoginResponse);


    }
}
