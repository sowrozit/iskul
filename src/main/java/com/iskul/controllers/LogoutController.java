package com.iskul.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Sowrozit on 2/16/2017.
 */
@Controller
//@RequestMapping("admin/logout")

public class LogoutController {

        @RequestMapping(value = "manage/logout", method= { RequestMethod.POST, RequestMethod.GET})
        public String logout(HttpSession session, HttpServletRequest request) {
            System.out.println("logout");
            request.getSession().invalidate();
            return "redirect:/login";
        }


//    @RequestMapping(value = "student/logout", method = {RequestMethod.GET,RequestMethod.POST})
//    public String StudentLogout(HttpSession session,HttpServletRequest request){
//            System.out.println("StudentLogout");
//            request.getSession().invalidate();
//            return "redirect:/login";
//    }
//
//    @RequestMapping(value = "teacher/logout", method = {RequestMethod.GET,RequestMethod.POST})
//    public String TeacherLogout(HttpSession session,HttpServletRequest request){
//        System.out.println("TeacherLogout");
//        request.getSession().invalidate();
//        return "redirect:/login";
//    }
}
