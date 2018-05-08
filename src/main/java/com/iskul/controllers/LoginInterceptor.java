//package com.iskul.controllers;
//
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
///**
// * Created by Sowrozit on 3/24/2017.
// */
//@Controller
//@RequestMapping("/login")
//public class LoginInterceptor extends HandlerInterceptorAdapter {
//
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler ) throws IOException{
//        String uri = request.getRequestURI();
//        System.out.println("pre-handle");
//        if (!uri.endsWith("loginform")){
//            if (request.getSession().getAttribute("usr")== null){
//                response.sendRedirect("loginform");
//                return false;
//            }
//        }
//        return  true;
//    }
//}
