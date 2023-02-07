package com.realcoders.realcoderlinkedinspring2.web.security.filter;

import com.realcoders.realcoderlinkedinspring2.web.security.authentication.JwtAuthenticator;
import jakarta.servlet.Filter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class RequestFilterRegister {
    private final JwtAuthenticator jwtAuthenticator;

    @Bean
    public FilterRegistrationBean<Filter> registerPostCommentsRateLimiter(){
        FilterRegistrationBean<Filter> registrationBean  = new FilterRegistrationBean<>();

        registrationBean.setFilter(new JwtFilter(jwtAuthenticator));
        registrationBean.addUrlPatterns("/companies");

        return registrationBean;
    }
}
