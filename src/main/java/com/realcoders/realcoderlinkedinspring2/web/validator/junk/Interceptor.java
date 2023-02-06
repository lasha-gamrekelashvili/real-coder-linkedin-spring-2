//package com.realcoders.realcoderlinkedinspring2.web.validator;
//
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.util.ContentCachingRequestWrapper;
//
//import java.util.stream.Collectors;
//
//public class Interceptor implements HandlerInterceptor {
//
//    @Override
//    public boolean preHandle(HttpServletRequest requestServlet, HttpServletResponse responseServlet, Object handler) throws Exception
//    {
//        ContentCachingRequestWrapper request = new ContentCachingRequestWrapper(requestServlet);
//
//        request.se
//        System.out.println(request.getReader().lines().collect(Collectors.toList()));
//
//        return true;
//    }
//}
