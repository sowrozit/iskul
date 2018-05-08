package com.iskul.interceptors;

import com.iskul.model.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Sowrozit on 3/31/2017.
 */
public class AdminTeacherStudentInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handle) throws Exception{

        System.out.println("AdminTeacherStudent");
        String uri = request.getRequestURI();

        User user = (User) request.getSession().getAttribute("usr");

        if(user  != null){
            if( user.getUserType().equals("admin") || user.getUserType().equals("teacher") || user.getUserType().equals("student")) {

                return true;
            }
            else {

                response.getWriter().write("Sorry,You are not authorized to this page ");
                return false;
            }
        }
        else{
            response.sendRedirect("/login");
            return false;
        }
    }
}
