//package com.realcoders.realcoderlinkedinspring2.web.validator;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.boot.web.servlet.FilterRegistrationBean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//@RequiredArgsConstructor
//public class UserFilter {
//
//    public FilterRegistrationBean<UserValidator> validateUser(){
//        FilterRegistrationBean<UserValidator> registrationBean = new FilterRegistrationBean<>();
//        registrationBean.setFilter(new UserValidator());
//        registrationBean.addUrlPatterns("/auth/register");
//
//        return registrationBean;
//    }
//}
