package com.example.airline_systems.security;

import com.example.airline_systems.enums.TokenClaims;
import io.jsonwebtoken.Claims;
import org.springframework.security.oauth2.jwt.Jwt;
import io.jsonwebtoken.SignatureAlgorithm;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.time.Instant;
import java.util.List;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {
    private final JwtTokenProvider jwtTokenProvider;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = getTokenFromRequest(request);
        System.out.println("Token: " + token); // Debug Log

        // Validate Token
        if(StringUtils.hasText(token) && jwtTokenProvider.validateToken(token)){
            final Claims claims = jwtTokenProvider.extractAllClaims(token);
            final String role = claims.get(TokenClaims.ROLE_NAME.getValue(), String.class);
            System.out.println("Role: " + role); // Debug Log

            final Jwt jwt = new Jwt(
                    token,
                    Instant.ofEpochSecond(claims.getIssuedAt().getTime()),
                    Instant.ofEpochSecond(claims.getExpiration().getTime()),
                    Map.of(TokenClaims.ALGORITHM.getValue(), SignatureAlgorithm.HS256.getValue()),
                    claims
            );
            UsernamePasswordAuthenticationToken authToken = UsernamePasswordAuthenticationToken
                    .authenticated(jwt, null, List.of(new SimpleGrantedAuthority(role)));
            System.out.println("AuthToken: " + authToken);

            SecurityContextHolder.getContext().setAuthentication(authToken);
        }else{
            System.out.println("Token validation failed or missing.");
            filterChain.doFilter(request, response);
            return;
        }
        filterChain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");

        if(StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")){
            return bearerToken.substring(7, bearerToken.length());
        }

        return null;
    }

}
