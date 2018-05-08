//package com.iskul.controllers;
//
//import com.iskul.model.User;
//import org.springframework.stereotype.Component;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Created by Sowrozit on 3/27/2017.
// */
//@Component
//public class authenticationInterceptor extends HandlerInterceptorAdapter
//{
//    @Override
//    public boolean preHandle(HttpServletRequest request,
//                             HttpServletResponse response, Object handler) throws Exception
//    {
//        System.out.println("PreHandle");
//        String uri = request.getRequestURI();
//        if(!uri.endsWith("loginform") && !uri.endsWith("login"))
//        {
//            User userData = (User) request.getSession().getAttribute("LOGGEDIN_USER");
//            if(userData == null)
//            {
//                response.sendRedirect("home");
//                return false;
//            }
//        }
//        return true;
//    }
//}