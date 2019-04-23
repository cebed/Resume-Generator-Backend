package com.example.resumegeneratorbackend.security;

import com.example.resumegeneratorbackend.model.Security;
import com.example.resumegeneratorbackend.service.UserDetailServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;

import static com.example.resumegeneratorbackend.security.SecurityCockpit.HEADER_STRING;
import static com.example.resumegeneratorbackend.security.SecurityCockpit.TOKEN_PREFIX;

public class JwtAuthenticationFilter extends OncePerRequestFilter {


    //we need this to validate the token and extract user id from the token
    @Autowired
    private JwtTokenProvider tokenProvider;

    @Autowired
    private UserDetailServices userDetailServices;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        try {

            //grab the jason web token from our request
            String jwt = getJWTFromRequest(request);

            //make sure that the grabbed token has text and is valid, other words look if its not null
            // and call method from tokenprovider to check if there is exceptions
            if(StringUtils.hasText(jwt)&& tokenProvider.validateToken(jwt)){
                Long userId = tokenProvider.getUserIdFromJWT(jwt);
                Security u = userDetailServices.loadUserById(userId);

                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        u, null, Collections.emptyList());

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);

            }

        }catch (Exception ex){
            logger.error("Could not set user authentication in security context", ex);
        }


        filterChain.doFilter(request, response);

    }



    private String getJWTFromRequest(HttpServletRequest request){
        String bearerToken = request.getHeader(HEADER_STRING);

        if(StringUtils.hasText(bearerToken)&&bearerToken.startsWith(TOKEN_PREFIX)){
            return bearerToken.substring(7, bearerToken.length());
        }

        return null;
    }
}
