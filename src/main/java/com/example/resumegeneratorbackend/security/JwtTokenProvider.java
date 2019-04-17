package com.example.resumegeneratorbackend.security;

import com.example.resumegeneratorbackend.model.Users;
import io.jsonwebtoken.*;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.example.resumegeneratorbackend.security.SecurityCockpit.EXPIRATION_TIME;
import static com.example.resumegeneratorbackend.security.SecurityCockpit.SECRET;

/*
 * In this class we do 3 things
 * Generate the token
 * Validate the token
 * And last get the user ID from the token
 */
@Component
public class JwtTokenProvider {

    //Generate token
    //This method generate a token when we have a valid username and password
    public String generateToken(Authentication authentication){
        //extract the user that is authenticated
        Users users = (Users)authentication.getPrincipal();
        Date rightNow = new Date(System.currentTimeMillis());

        Date expire = new Date(rightNow.getTime()+EXPIRATION_TIME);

       //we need to cast our user id to string because the token is a string.
        //So the user id is one of the things we pass with the token
        String userId = Long.toString(users.getId());

        Map<String, Object> claims = new HashMap<>();
        claims.put("id", (Long.toString(users.getId())));
        claims.put("username", users.getUsername());
        claims.put("fullName", users.getFullName());
        claims.put("address", users.getAddress());
        claims.put("phone", users.getPhone());
        //throw roles here in future

        return Jwts.builder()
                .setSubject(userId)
                // claims is information about the user
                .setClaims(claims)
                .setIssuedAt(rightNow)
                .setExpiration(expire)
                //Secret comes from jwt key in cockpit
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
    }

    //Validate the token
    public boolean validateToken(String token){
        try{
            Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token);
            return true;

        }catch (SignatureException ex){
            System.out.println("Invalid JWT signature");

        }catch (MalformedJwtException ex){
            System.out.println("Invalid JWT token");
        }catch (ExpiredJwtException ex){
         System.out.println("Expired JWT token");
        }
        catch (UnsupportedJwtException ex){
            System.out.println("Unsupported JWT token");
        }catch(IllegalArgumentException ex){
            System.out.println("JWT claims string is empty");
        }
        return false;

    }

    //Get user id from token

    public Long getUserIdFromJWT(String token){
        //decoding token
        Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        String id = (String)claims.get("id");

        return Long.parseLong(id);
    }
}
