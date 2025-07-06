package com.tn.controller;

import com.tn.req.AuthRequest;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class TokenController {

    private final AuthenticationManager authenticationManager;

    public TokenController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @Value("${SECRET_KEY}")
    private String SECRET_KEY;

    @PostMapping("genToken")
    public ResponseEntity<?> genToken(@RequestBody AuthRequest authRequest) {
        String username = authRequest.getUsername();
        String password = authRequest.getPassword();

        // check username, password đúng không
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(username, password));

        // Tạo JWT với user name + iat + exp
        if (authentication.isAuthenticated()) {
            String token = Jwts.builder()
                    .setSubject(username)
                    .setIssuedAt(new Date()) // thời gian hiện tại
                    // thời gian hết hạn
                    .setExpiration(new Date((new Date()).getTime() + 30 * 60 * 1000))
                    .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
                    .compact();

            // Trả về token
            return new ResponseEntity<>(token, HttpStatus.OK);
        }

        return new ResponseEntity<>("Wrong username or password", HttpStatus.UNAUTHORIZED);
    }

}
