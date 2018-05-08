package com.iskul.controllers;

/**
 * Created by Sowrozit on 2/6/2017.
 */

import com.iskul.forms.LoginForm;
import com.iskul.model.User;
import com.iskul.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;


@Controller
@RequestMapping("/login")
public class LoginController {


    @Autowired
    public LoginService loginService;

    @RequestMapping(method = RequestMethod.GET)
    public String showForm(Map model) {
        LoginForm loginForm = new LoginForm();
        model.put("loginForm", loginForm);
        return "loginform";
    }

    @RequestMapping(value = "",method = RequestMethod.POST)
    public String processForm(@Valid LoginForm loginForm, @RequestParam String userName, @RequestParam String password, HttpServletRequest request, BindingResult result,
                              ModelMap model, HttpSession session) {

        System.out.println("here");
        if (result.hasErrors()) {
            model.put("loginForm", loginForm);
            return "loginform";
        }

        User u  = loginService.checkLogin(loginForm.getUserName(),loginForm.getPassword());
        if(u!=null){
            request.getSession().setAttribute("usr",u);
//            session.setMaxInactiveInterval(60);

            User user = (User)request.getSession().getAttribute("usr");

            if(u.getUserType().equals("admin")){

                model.put("usr", u.getUserName());
                return "redirect:/manage/home";
            }

            else if(u.getUserType().equals("teacher")) {
                model.put("usr", u.getUserName());
                return "redirect:/manage/teacher";
            }

            else {
                model.put("usr", u.getUserName());
                return "redirect:/manage/student";
            }
        } else if(u == null)
        {
            result.rejectValue("userName","invaliduser");
            return "loginform";
        } else{
            result.rejectValue("userName","invaliduser");
            return "loginform";
        }

    }

}