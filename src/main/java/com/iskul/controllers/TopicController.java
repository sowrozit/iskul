package com.iskul.controllers;

import com.iskul.dao.QuestionDao;
import com.iskul.dao.SubjectDao;
import com.iskul.dao.TopicDao;
import com.iskul.forms.TopicForm;
import com.iskul.model.*;

import com.iskul.services.CategoryService;
import com.iskul.services.SubjectService;
import com.iskul.services.TopicService;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * Created by Sowrozit on 2/27/2017.
 */
@Controller
public class TopicController {

    private static final Logger logger = Logger
            .getLogger(TopicController.class);

    public TopicController() {
        System.out.println("TopicController()");
    }

    @Autowired
    private TopicService topicService;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubjectDao subjectDao;

    @RequestMapping(value = "/manage/adminTeacher/topic_manage")
    public ModelAndView listTopic(ModelAndView model, HttpServletRequest request) throws IOException {
        List<Topic> listTopic = topicService.getAllTopics();
        model.addObject("listTopic", listTopic);
        Topic t = (Topic) request.getSession().getAttribute("tpc");
        model.setViewName("topic_manage");
        return model;
    }



    @RequestMapping(value = "/manage/adminTeacher/newTopic", method = RequestMethod.GET)
    public ModelAndView newTopic(ModelAndView model) {
        Topic topic = new Topic();
        model.addObject("topic", topic);
        List<Category> listCategory = categoryService.getAllCategories();
        model.addObject("listCategory", listCategory);
        model.setViewName("topicForm");
        return model;
    }

    @RequestMapping(value = "/manage/adminTeacher/newTopic", method = RequestMethod.POST)
    public ModelAndView saveTopic(@Valid @ModelAttribute Topic topic, BindingResult result, ModelAndView model){
        if(result.hasErrors()){
            List<Category> listCategory = categoryService.getAllCategories();
            model.addObject("listCategory", listCategory);
            model.setViewName("topicForm");
            return model;
        }
        if (topic.getId() == 0) {
            topicService.addTopic(topic);
        } else {
            topicService.updateTopic(topic);
        }

        return new ModelAndView("redirect:/manage/adminTeacher/topic_manage");
    }


    @RequestMapping(value = "/manage/adminTeacher/deleteTopic", method = RequestMethod.GET)
    public ModelAndView deleteTopic(HttpServletRequest request) {
        int topicId = Integer.parseInt(request.getParameter("id"));
        topicService.deleteTopic(topicId);
        return new ModelAndView("redirect:/manage/adminTeacher/topic_manage");
    }

    @RequestMapping(value = "/manage/adminTeacher/editTopic", method = RequestMethod.GET)
    public ModelAndView editTopic(HttpServletRequest request) {
        int topicId = Integer.parseInt(request.getParameter("id"));
        Topic topic = topicService.getTopic(topicId);
        ModelAndView model = new ModelAndView("topicForm");
        List<Subject> listSubject = subjectService.getAllSubjects();
        model.addObject("listSubject", listSubject);
        List<Category> listCategory = categoryService.getAllCategories();
        model.addObject("listCategory", listCategory);
        model.addObject("topic", topic);

        return model;
    }


    @Autowired
    private TopicDao topicDao;

    @ResponseBody
    @RequestMapping(value = "/manage/adminTeacher/getSubjects", method = RequestMethod.GET)
    public String getSubjectsForCategory(ModelAndView model,HttpServletRequest request)throws IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        List<Subject> listSubject = topicDao.getAllSubjectsByCategory(id);
        String optionHtml = "";
        for(int i = 0; i < listSubject.size(); i++){
            optionHtml += "<option value="+ listSubject.get(i).getId()+">" +
                    listSubject.get(i).getSub_title() +"</option>";
        }
        return optionHtml;
    }

    @Autowired
    private QuestionDao questionDao;


    @RequestMapping("/manage/adminTeacher/topicDetails")
    public ModelAndView quiz(ModelAndView model, HttpServletRequest request) throws IOException{
        int topicId = Integer.parseInt(request.getParameter("id"));
        List<Questions> questionsList = questionDao.showAllQuestionsByTopicId(topicId);
        model.addObject("questionList",questionsList);
        model.setViewName("topicDetails");
        return  model;
    }

    //    For Admin Teacher and Student

//    @Autowired
//    private QuestionDao questionDao;
//
//    @RequestMapping(value = "/manage/adminTeacherStudent/startQuiz", method = RequestMethod.GET)
//    public ModelAndView startQuiz(ModelAndView model,HttpServletRequest request)throws IOException{
//
//        int id = Integer.parseInt(request.getParameter("id"));
//        Topic topic  = topicService.getTopic(id);
//        model.addObject("topic",topic);
//        List<Questions> listOfQuestion = questionDao.showAllQuestionsByTopicId(topic.getId());
//        model.addObject("listOfQuestion",listOfQuestion);
//        Questions qs = (Questions) request.getSession().getAttribute("qst");
//        model.setViewName("startQuiz");
//        return model;
//    }



}