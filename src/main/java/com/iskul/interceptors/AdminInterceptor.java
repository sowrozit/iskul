package com.iskul.interceptors;

import com.iskul.model.User;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Sowrozit on 3/28/2017.
 */
public class AdminInterceptor extends HandlerInterceptorAdapter {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handle) throws Exception{
        System.out.println("Admin");
        String uri = request.getRequestURI();

        User user = (User) request.getSession().getAttribute("usr");

        if(user  != null){
            if(!user.getUserType().equals("admin")) {

                response.getWriter().write("Sorry,You are not authorized to this page ");
                return false;
            }
            else {
                return true;
            }
        }
        else{
            response.sendRedirect("/login");
            return false;
        }
    }
}
