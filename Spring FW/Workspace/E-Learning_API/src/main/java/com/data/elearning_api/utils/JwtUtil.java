package com.data.elearning_api.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;

public class JwtUtil {

    private static final String SECRET_KEY = "elearning_secret_key_123";
    private static final long EXPIRATION_TIME = 86400000; // 1 ngày


    // Tạo token
    public static String generateToken(String username) {
        return JWT.create()
                .withSubject(username)
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .sign(Algorithm.HMAC256(SECRET_KEY));
    }

    // Giải mã token và lấy username
    public String extractUsername(String token) {
        return getDecodedJWT(token).getSubject();
    }


    // Kiểm tra token hợp lệ (hết hạn, sai chữ ký...)
    public boolean isTokenValid(String token) {
        try {
            getDecodedJWT(token); // nếu lỗi sẽ throw
            return true;
        } catch (Exception e) {
            return false;
        }
    }


    // Giải mã token
    private DecodedJWT getDecodedJWT(String token) {
        JWTVerifier verifier = JWT.require(algorithm).build();
        return verifier.verify(token);
    }
}
