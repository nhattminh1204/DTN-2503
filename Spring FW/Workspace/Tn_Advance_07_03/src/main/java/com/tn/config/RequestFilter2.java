package com.tn.config;

import com.tn.service.AccountService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

// luôn chạy RequestFilter2 để kiểm tra Jwt
// trước khi vào api
@Configuration
public class RequestFilter2 extends OncePerRequestFilter {

    @Autowired
    private AccountService accountService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String token = request.getHeader("Authorization");

        if (token == null) {
            // do nothing
        }
        if (token != null && token.contains("Bearer ")) {
            token = token.replace("Bearer ", "");

            try {
                Jws<Claims> claimsJws = Jwts.parser()
                        .setSigningKey("railway12SecretKeyrailway12SecretKeyrailway12SecretKey").parseClaimsJws(token);

                String username = claimsJws.getBody().getSubject();

                UserDetails userDetails = accountService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(authentication);
            } catch (ExpiredJwtException e) {
                System.out.println(e.getMessage());
            }
        }

        filterChain.doFilter(request, response);
    }
}
