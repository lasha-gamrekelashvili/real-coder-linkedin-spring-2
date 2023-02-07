package com.realcoders.realcoderlinkedinspring2.web.security.configuration;

import com.realcoders.realcoderlinkedinspring2.storage.model.UserEntity;
import io.jsonwebtoken.*;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.Key;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.UUID;

@Component
public class JwtConfigurationProvider {
    private final String secret = "CgMq1nfB78.D/UUwVrDffuDUL+8+WSh20.Z95sYYcw/v8=";

    private final Key hmacKey = new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8),
            SignatureAlgorithm.HS256.getJcaName());

    public String generateJWT(UserEntity user) {
        Instant now = Instant.now();
        return Jwts.builder()
                .claim("id", user.getId())
                .claim("username", user.getUsername())
                .setSubject(user.getEmail())
                .setId(UUID.randomUUID().toString())
                .setIssuedAt(Date.from(now))
                .setHeaderParam(JwsHeader.TYPE, Header.JWT_TYPE)
                .setExpiration(Date.from(now.plus(100, ChronoUnit.MINUTES)))
                .signWith(hmacKey)
                .compact();
    }

    public Jws<Claims> parseJwt(String jwtString) {
        try{
            return Jwts.parserBuilder()
                    .setSigningKey(hmacKey)
                    .build()
                    .parseClaimsJws(jwtString);
        } catch (Exception e){
            return null;
        }
    }
}
