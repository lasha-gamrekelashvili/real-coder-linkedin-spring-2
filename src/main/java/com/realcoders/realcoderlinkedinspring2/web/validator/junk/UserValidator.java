//package com.realcoders.realcoderlinkedinspring2.web.validator;
//import jakarta.servlet.*;
//import jakarta.servlet.http.HttpServletRequest;
//import org.springframework.stereotype.Component;
//import org.springframework.web.util.ContentCachingRequestWrapper;
//
//import java.io.IOException;
//import java.util.stream.Collectors;
//
//
//@Component
//public class UserValidator implements Filter {
//
//    @Override
//    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        ContentCachingRequestWrapper req = new ContentCachingRequestWrapper((HttpServletRequest) request);
//        System.out.println(req.getReader().lines().collect(Collectors.toList()));
//        chain.doFilter(request,response);
//    }
//}
