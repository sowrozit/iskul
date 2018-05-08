package com.iskul.controllers;

import com.iskul.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Sowrozit on 4/21/2017.
 */
@Controller
public class AdminController {

    @RequestMapping(value = "/manage/adminManagement")
    public ModelAndView admin(ModelAndView model, HttpServletRequest request) throws IOException {
        User u = (User) request.getSession().getAttribute("usr");
        System.out.println(u.getUserName());
        model.addObject("username",u.getUserName());
        model.setViewName("adminManagement");
        return model;
    }
}