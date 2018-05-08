package com.iskul.controllers;

import com.iskul.model.User;
import com.iskul.services.UserService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

@Controller
public class UserController {

    private static final Logger logger = Logger
            .getLogger(UserController.class);

    public UserController() {
        System.out.println("UserController()");
    }

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/manage/admin/usr_manage")
    public ModelAndView listUser(ModelAndView model,HttpServletRequest request) throws IOException {
        List<User> listUser = userService.getAllUsers();
        model.addObject("listUser", listUser);
        User u = (User) request.getSession().getAttribute("usr");
        System.out.println(u.getUserName());
        model.addObject("username",u.getUserName());
        model.setViewName("usr_manage");
        return model;
    }

    @RequestMapping(value = "/manage/admin/newUser", method = RequestMethod.GET)
    public ModelAndView newContact(ModelAndView model) {
        User user = new User();
        model.addObject("user", user);
        model.setViewName("userForm");
        return model;
    }

    @RequestMapping(value = "/manage/admin/saveUser", method = RequestMethod.POST)
    public ModelAndView saveUser(@ModelAttribute User user) {
        if (user.getId() == 0) { // if user id is 0 then creating the
            // user other updating the user
            userService.addUser(user);
        } else {
            userService.updateUser(user);
        }
        return new ModelAndView("redirect:/manage/admin/usr_manage");
    }

    @RequestMapping(value = "/manage/admin/deleteUser", method = RequestMethod.GET)
    public ModelAndView deleteUser(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        userService.deleteUser(userId);
        return new ModelAndView("redirect:/manage/admin/usr_manage");
    }

    @RequestMapping(value = "/manage/admin/editUser", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int userId = Integer.parseInt(request.getParameter("id"));
        User user = userService.getUser(userId);
        ModelAndView model = new ModelAndView("userForm");
        model.addObject("user", user);
        return model;
    }

}