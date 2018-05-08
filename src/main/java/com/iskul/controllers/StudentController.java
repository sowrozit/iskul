package com.iskul.controllers;

import com.iskul.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Sowrozit on 2/24/2017.
 */

@Controller
public class StudentController {

    @RequestMapping("/manage/student")
    public ModelAndView listUser(ModelAndView model, HttpServletRequest request) throws IOException{
        User u  = (User) request.getSession().getAttribute("usr");
        System.out.println(u.getUserName());
        model.addObject("username",u.getUserName());
        model.setViewName("student");
        return model;
    }
}
