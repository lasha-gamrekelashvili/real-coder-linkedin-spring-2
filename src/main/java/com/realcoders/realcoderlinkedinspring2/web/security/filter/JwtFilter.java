package com.realcoders.realcoderlinkedinspring2.web.security.filter;

import com.realcoders.realcoderlinkedinspring2.storage.model.UserEntity;
import com.realcoders.realcoderlinkedinspring2.web.security.authentication.JwtAuthenticator;
import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.IOException;

@RequiredArgsConstructor
@Component
public class JwtFilter implements Filter {

    private final JwtAuthenticator jwtAuthenticator;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        String key = req.getHeader("Bearer");

        UserEntity userEntity = jwtAuthenticator.verify(key);

        if(userEntity==null){
            ((HttpServletResponse) response).setStatus(401);
            response.getOutputStream().write("The provided JWT is invalid or has expired".getBytes());
            return;
        }
        chain.doFilter(request, response);
    }
}
