package com.example.airline_systems.security;

import com.example.airline_systems.enums.TokenClaims;
import com.example.airline_systems.model.User;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class JwtTokenProvider {

    private String jwtSecret = "35448b734e6159c4fdd39ce996ecbcd783548aa5f75ed00d75e29749ff6c3783,";
    private long jwtExpirationDate = 3600000; //1h = 3600s and 3600*1000 = 3600000 milliseconds



    public String generateToken(User user){
        HashMap<String,Object> claim  = new HashMap<>();

        claim.put(TokenClaims.USER_ID.getValue(),user.getId());
        claim.put(TokenClaims.USERNAME.getValue(), user.getUsername());
        claim.put(TokenClaims.ROLE_NAME.getValue(),user.getRole().name());

        return generateToken(claim, user);
    }

    public String generateToken(Map<String,Object> extraClaims, User user) {
        return buildToken(extraClaims, user, jwtExpirationDate);

    }

    private String buildToken(
            Map<String, Object> extraClaims,
            User user,
            long expiration
    ) {

        return Jwts
                .builder()
                .setHeaderParam(TokenClaims.JWT_ID.getValue(), UUID.randomUUID().toString())
                .setHeaderParam(TokenClaims.TYPE.getValue(), TokenClaims.TYPE.getValue())
                .setClaims(extraClaims)
                .setSubject(user.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expiration))
                .signWith(key(), SignatureAlgorithm.HS256)
                .compact();

    }

    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }

    public Claims extractAllClaims(String token){
        return Jwts.parser().setSigningKey(key()).build().parseClaimsJws(token).getBody();
    }


    // validate JWT token
    public boolean validateToken(String token) {
        try {
            Jwts.parser()
                    .setSigningKey(key())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return true;
        } catch (MalformedJwtException | ExpiredJwtException exception) {
            throw new RuntimeException(token, exception);
        }
    }
}