package com.iskul.controllers;

import com.iskul.dao.ProfileDao;
import com.iskul.dao.UserDao;
import com.iskul.model.User;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by Sowrozit on 4/28/2017.
 */
@Controller
public class ProfileController {

    private static final Logger logger = Logger
            .getLogger(UserController.class);

    public ProfileController() {
        System.out.println("UserController()");
    }

    @Autowired
    private ProfileDao profileDao;

    @Autowired
    private UserDao userDao;


    @RequestMapping(value = "/manage/adminTeacherStudent/profile")
    public ModelAndView userProfile(ModelAndView model, HttpServletRequest request) throws IOException{

        User u = (User) request.getSession().getAttribute("usr");
        System.out.println(u.getUserName());
        model.addObject("username",u.getUserName());
        User user = userDao.getUser(u.getId());
//        int usrid = Integer.parseInt(request.getParameter("id"));
//        User user = userDao.getUser(usrid);
        model.addObject("user",user);
        model.setViewName("profile");
        return model;
    }


}
