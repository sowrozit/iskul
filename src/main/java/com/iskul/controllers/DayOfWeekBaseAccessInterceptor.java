//package com.iskul.controllers;
//
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.util.Calendar;
//
///**
// * Created by Sowrozit on 3/27/2017.
// */
//public class DayOfWeekBaseAccessInterceptor extends HandlerInterceptorAdapter {
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
//
//        Calendar calendar = Calendar.getInstance();
//
//        int dayOfWeek = calendar.get(calendar.DAY_OF_WEEK);
//        if ( dayOfWeek == 1){
//            response.getWriter().write("The website is closed on Sunday");
//            return false;
//        }
//
//
//        return true;
//    }
//}
