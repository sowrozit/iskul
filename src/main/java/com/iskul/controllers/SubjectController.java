package com.iskul.controllers;


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
public class SubjectController {

    private static final Logger logger = Logger
            .getLogger(SubjectController.class);

    public SubjectController() {
        System.out.println("SubjectController()");
    }

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private CategoryService categoryService;



    @RequestMapping(value = "/manage/adminTeacher/sub_manage")
    public ModelAndView listSubject(ModelAndView model,HttpServletRequest request) throws IOException {
        List<Subject> listSubject = subjectService.getAllSubjects();
        model.addObject("listSubject", listSubject);
        Subject s  = (Subject) request.getSession().getAttribute("sub");
        model.setViewName("sub_manage");
        return model;
    }

    @RequestMapping(value = "/manage/adminTeacher/newSubject", method = RequestMethod.GET)
    public ModelAndView newSubject(ModelAndView model) {
        Subject subject = new Subject();
        model.addObject("subject", subject);
        List<Category> listCategory = categoryService.getAllCategories();
        model.addObject("listCategory",listCategory);
        model.setViewName("subForm");
        return model;
    }

    @RequestMapping(value = "/manage/adminTeacher/newSubject", method = RequestMethod.POST)
    public ModelAndView saveSubject(@Valid @ModelAttribute Subject subject, BindingResult result, ModelAndView model){
        if(result.hasErrors()){
            List<Category> listCategory = categoryService.getAllCategories();
            model.addObject("listCategory", listCategory);
            model.setViewName("subForm");
            return model;
        }
        if (subject.getId() == 0) {
            subjectService.addSubject(subject);
        } else {
            subjectService.updateSubject(subject);
        }

        return new ModelAndView("redirect:/manage/adminTeacher/sub_manage");
    }

    @RequestMapping(value = "/manage/adminTeacher/deleteSubject", method = RequestMethod.GET)
    public ModelAndView deleteSubject(HttpServletRequest request) {
        int subjectId = Integer.parseInt(request.getParameter("id"));
        subjectService.deleteSubject(subjectId);
        return new ModelAndView("redirect:/manage/adminTeacher/sub_manage");
    }

    @RequestMapping(value = "/manage/adminTeacher/editSubject", method = RequestMethod.GET)
    public ModelAndView editSubject(HttpServletRequest request) {
        int subjectId = Integer.parseInt(request.getParameter("id"));
        Subject subject = subjectService.getSubject(subjectId);
        ModelAndView model = new ModelAndView("subForm");
        List<Category> listCategory = categoryService.getAllCategories();
        model.addObject("listCategory",listCategory);
        model.addObject("subject", subject);

        return model;
    }

    @Autowired
    private TopicDao topicDao;

    @RequestMapping(value = "/manage/adminTeacher/subjectDetails",method = RequestMethod.GET)
    public  ModelAndView showAllTopicsBySubject(ModelAndView model, HttpServletRequest request) throws IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Subject subject = subjectService.getSubject(id);
        model.addObject("subject",subject);
        List<Topic> topicList = topicDao.showAllTopicsBySubject(subject.getId());//Topics BY Subject
        model.addObject("topicList",topicList);
        Topic t = (Topic)request.getSession().getAttribute("tpc");
        model.setViewName("subjectDetails");
        return model;
    }



}