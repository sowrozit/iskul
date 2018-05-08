package com.iskul.controllers;



import com.iskul.dao.CategoryDao;
import com.iskul.dao.SubjectDao;
import com.iskul.dao.TopicDao;
import com.iskul.model.Category;

import com.iskul.model.Subject;
import com.iskul.model.Topic;
import com.iskul.services.CategoryService;

import com.iskul.services.SubjectService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@Controller
public class CategoryController {

    private static final Logger logger = Logger
            .getLogger(UserController.class);

    public CategoryController()
    {
        System.out.println("CategoryController()");
    }

    @Autowired
    private CategoryService categoryService;


    @RequestMapping(value = "/manage/admin/ctg_manage")
    public ModelAndView listCategory(ModelAndView model,HttpServletRequest request) throws IOException {
        List<Category> listCategory = categoryService.getAllCategories();
        model.addObject("listCategory", listCategory);
        Category c = (Category) request.getSession().getAttribute("ctg");
        model.setViewName("ctg_manage");
        return model;
    }

    @RequestMapping(value = "/manage/admin/newCategory", method = RequestMethod.GET)
    public ModelAndView newCategory(ModelAndView model) {
        Category category  = new Category();
        model.addObject("category", category);
        model.setViewName("ctgForm");
        return model;
    }

    @RequestMapping(value = "/manage/admin/newCategory", method = RequestMethod.POST)
    public ModelAndView saveCategory(@Valid @ModelAttribute Category category, BindingResult result, ModelAndView model){
        if(result.hasErrors()){
            model.setViewName("ctgForm");
            return model;
        }
        if (category.getId() == 0) {
            categoryService.addCategory(category);
        } else {
            categoryService.updateCategory(category);
        }

        return new ModelAndView("redirect:/manage/admin/ctg_manage");
    }

    @RequestMapping(value = "/manage/admin/deleteCategory", method = RequestMethod.GET)
    public ModelAndView deleteCategory(HttpServletRequest request) {
        int categoryId = Integer.parseInt(request.getParameter("id"));
        categoryService.deleteCategory(categoryId);
        return new ModelAndView("redirect:/manage/admin/ctg_manage");
    }

    @RequestMapping(value = "/manage/admin/editCategory", method = RequestMethod.GET)
    public ModelAndView editContact(HttpServletRequest request) {
        int categoryId = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.getCategory(categoryId);
        ModelAndView model = new ModelAndView("ctgForm");
        model.addObject("category", category);
        return model;
    }

//    View Categories

    @Autowired
    private CategoryDao categoryDao;
    @Autowired
    private SubjectDao subjectDao;
    @Autowired
    private TopicDao topicDao;
    @Autowired
    private SubjectService subjectService;

    @RequestMapping(value = "/manage/admin/categoryDetails", method = RequestMethod.GET)
    public ModelAndView showAllSubjectsByCategory(ModelAndView model,HttpServletRequest request) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.getCategory(id);
        model.addObject("category", category);
        List<Subject> subjectList = subjectDao.showAllSubjectsByCategory(category.getId());//Subjects By Category ID
        model.addObject("subjectList",subjectList);
        model.setViewName("categoryDetails");
        return model;
    }


}