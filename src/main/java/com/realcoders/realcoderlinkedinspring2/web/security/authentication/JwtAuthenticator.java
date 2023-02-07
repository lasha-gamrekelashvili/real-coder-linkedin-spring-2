package com.realcoders.realcoderlinkedinspring2.web.security.authentication;

import com.realcoders.realcoderlinkedinspring2.core.AppException;
import com.realcoders.realcoderlinkedinspring2.storage.model.UserEntity;
import com.realcoders.realcoderlinkedinspring2.storage.repository.user.UserRepository;
import com.realcoders.realcoderlinkedinspring2.web.security.configuration.JwtConfigurationProvider;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JwtAuthenticator implements Authenticator{
    private final JwtConfigurationProvider jwtConfigurationProvider;
    private final UserRepository userRepository;

    @Override
    public UserEntity verify(String idTokenString) {

        Jws<Claims> jws = jwtConfigurationProvider.parseJwt(idTokenString);

        if(jws==null){
            return null;
        }

        String email = jws.getBody().getSubject();

        return userRepository.getByEmail(email);
    }
}
