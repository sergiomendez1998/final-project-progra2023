package com.example.finalprojectbackend.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.util.*;

public class TokenUtils {

    private final static String ACCESS_TOKEN_SECRET = "0fhqd2mnCqlSTGSOTfZhbg7rXfaStyPc";
    private final static Long EXPIRATION_TIME = 2_592_000_000L;

    /*
    * This method will create a token with the email and name of the user.
    * The token will expire in 30 days.
    * The token will be signed with the ACCESS_TOKEN_SECRET.
    * The token will have the email as subject.
    * The token will have the name as extra information.
    * The token will have the expiration date.
     */
    public static String createToken(String name, String email) {
        long expirationTime = EXPIRATION_TIME*1000;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("name", name);

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    /*
    * This method will return the Authentication object with the username, password and authorities.
    * if the token is not valid will return null.
     */
    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCESS_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        } catch (JwtException e) {
            return null;
        }

    }
}
