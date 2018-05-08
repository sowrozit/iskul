//package com.iskul.interceptors;
//
//import com.iskul.model.User;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Created by Sowrozit on 3/28/2017.
// */
//public class StudentInterceptor extends HandlerInterceptorAdapter {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handle) throws Exception{
//
//        System.out.println("Student");
//        String uri = request.getRequestURI();
//        if (!uri.endsWith("loginform")&& !uri.endsWith("login")) {
//            User user = (User) request.getSession().getAttribute("usr");
//            if(user  != null){
//                if(user.getUserType().equals("student")) {
//                    return true;
//                }
//                else {
//                    return false;
//                }
//            }
//            else{
//                response.sendRedirect("/login");
//                return false;
//            }
//
//        }
//        return false;
//    }
//}
