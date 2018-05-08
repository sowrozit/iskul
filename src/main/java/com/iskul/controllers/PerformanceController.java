package com.iskul.controllers;

import com.iskul.dao.ExamDao;
import com.iskul.dao.ResultDao;
import com.iskul.dao.TopicDao;
import com.iskul.model.Exams;
import com.iskul.model.Result;
import com.iskul.model.Topic;
import com.iskul.model.User;
import com.iskul.services.TopicService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;

/**
 * Created by Sowrozit on 4/19/2017.
 */
@Controller
public class PerformanceController {

    private static final Logger logger = org.jboss.logging.Logger
            .getLogger(QuizController.class);

    public PerformanceController()
    {
        System.out.println("PerformanceController");
    }

    @Autowired
    private ExamDao examDao;

    @Autowired
    private TopicService topicService;

    @Autowired
    private ResultDao resultDao;



    @RequestMapping(value = "manage/adminTeacherStudent/performanceHistory")
    public ModelAndView Performance(ModelAndView model, HttpServletRequest request) throws IOException{
        User u = (User) request.getSession().getAttribute("usr");
        System.out.println(u.getUserName());
        model.addObject("username",u.getUserName());
        model.setViewName("performanceHistory");

        List<Result> results = resultDao.resultByUser(u);
        model.addObject("results",results);
        return model;
    }

    @RequestMapping(value ="/manage/adminTeacher/studentPerformance")
    public ModelAndView StudentPerformance(ModelAndView model, HttpServletRequest request) throws IOException{

        User u = (User) request.getSession().getAttribute("usr");
        System.out.println(u.getUserName());
        model.addObject("username",u.getUserName());
        model.setViewName("studentPerformance");

        int id = Integer.parseInt(request.getParameter("id"));
        Topic topic  = topicService.getTopic(id);
        model.addObject("topic",topic);

        List<Result> performance = resultDao.resultByTopic(topic);
        model.addObject("performance",performance);
        return model;
    }

    @RequestMapping(value = "/manage/adminTeacher/viewPerformance")
    public ModelAndView listTopic(ModelAndView model, HttpServletRequest request) throws IOException {
        List<Topic> listTopic = topicService.getAllTopics();
        model.addObject("listTopic", listTopic);
        Topic t = (Topic) request.getSession().getAttribute("tpc");
        model.setViewName("viewPerformance");
        return model;
    }
}
