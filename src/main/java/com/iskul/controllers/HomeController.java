package com.iskul.controllers;

import com.iskul.model.Category;
import com.iskul.model.User;
import com.iskul.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;


/**
 * Created by Sowrozit on 2/16/2017.
 */
@Controller
public class HomeController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/manage/home")
    public ModelAndView home(ModelAndView model, HttpServletRequest request) throws IOException {
        User u = (User) request.getSession().getAttribute("usr");
        System.out.println(u.getUserName());
        model.addObject("username",u.getUserName());

        List<Category> listCategoryForAll = categoryService.getAllCategories();
        model.addObject("listCategoryForAll", listCategoryForAll);
        Category c = (Category) request.getSession().getAttribute("ctg");
        model.setViewName("home");
        return model;
    }
}
