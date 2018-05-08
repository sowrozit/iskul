package com.iskul.controllers;


import com.iskul.dao.*;
import com.iskul.model.*;
import com.iskul.services.CategoryService;
import com.iskul.services.SubjectService;
import com.iskul.services.TopicService;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.persistence.Id;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Sowrozit on 3/31/2017.
 */

@Controller
public class AdminTeacherStudentController {

    private static final Logger logger = org.jboss.logging.Logger
            .getLogger(QuizController.class);

    public AdminTeacherStudentController()
    {
        System.out.println("QuizController");
    }

    @Autowired
    private TopicService topicService;

//    @RequestMapping(value = "/manage/quiz")
//    public ModelAndView listTopic(ModelAndView model, HttpServletRequest request) throws IOException {
//        List<Topic> listTopicForQuiz = topicService.getAllTopics();
//        model.addObject("listTopicForQuiz", listTopicForQuiz);
//        Topic t = (Topic) request.getSession().getAttribute("tpc");
//        model.setViewName("quiz");
//        return model;
//    }

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(value = "/manage/adminTeacherStudent/atsCategory")
    public ModelAndView listCategory(ModelAndView model,HttpServletRequest request) throws IOException {
        List<Category> listCategoryForAll = categoryService.getAllCategories();
        model.addObject("listCategoryForAll", listCategoryForAll);
        Category c = (Category) request.getSession().getAttribute("ctg");
        model.setViewName("atsCategory");
        return model;
    }

//    CategoryDetails For Admin Teacher and Student

    @Autowired
    private SubjectDao subjectDao;

    @Autowired
    private SubjectService subjectService;

    @Autowired
    private TopicDao topicDao;


    @RequestMapping(value = "/manage/adminTeacherStudent/atsCategoryDetails", method = RequestMethod.GET)
    public ModelAndView showAllSubjectsByCategory(ModelAndView model,HttpServletRequest request) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Category category = categoryService.getCategory(id);
        model.addObject("category", category);
        List<Subject> subjectListForAll = subjectDao.showAllSubjectsByCategory(category.getId());//Subjects By Category ID
        model.addObject("subjectListForAll",subjectListForAll);
        Subject subject = subjectService.getSubject(id);
        model.addObject("subject",subject);
        List<Topic> topicListForAll = topicDao.showAllTopicsBySubject(subject.getId());//Topics BY Subject
        model.addObject("topicListForAll",topicListForAll);
        Topic t = (Topic)request.getSession().getAttribute("tpc");
        model.setViewName("atsSubjectDetails");
        Subject s = (Subject) request.getSession().getAttribute("sub");
        model.setViewName("atsCategoryDetails");
        return model;
    }


    @RequestMapping(value = "/manage/adminTeacherStudent/atsSubjectDetails",method = RequestMethod.GET)
    public  ModelAndView showAllTopicsBySubject(ModelAndView model, HttpServletRequest request) throws IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        Subject subject = subjectService.getSubject(id);
        model.addObject("subject",subject);
        List<Topic> topicListForAll = topicDao.showAllTopicsBySubject(subject.getId());//Topics BY Subject
        model.addObject("topicListForAll",topicListForAll);
        Topic t = (Topic)request.getSession().getAttribute("tpc");
        model.setViewName("atsSubjectDetails");
        return model;
    }


    //    Start Quiz For Admin Teacher and Student

    @Autowired
    private QuestionDao questionDao;


    @Autowired
    private ExamDao examDao;

    @RequestMapping(value = "/manage/adminTeacherStudent/startQuiz", method = RequestMethod.GET)
    public ModelAndView startQuiz(ModelAndView model,HttpServletRequest request)throws IOException{

        int id = Integer.parseInt(request.getParameter("id"));
        Topic topic  = topicService.getTopic(id);
        model.addObject("topic",topic);
        List<Questions> listOfQuestion = questionDao.showLimitedQuestionByTopicId(topic.getId());
        model.addObject("listOfQuestion",listOfQuestion);
        Questions qs = (Questions) request.getSession().getAttribute("qst");
        model.setViewName("startQuiz");

        Exams exam = new Exams();
        exam.setUser((User)request.getSession().getAttribute("usr"));
        exam.setTopic(topic);

        UUID uuid = UUID.randomUUID();
        String randomUUIDString = uuid.toString();
        exam.setUnique_id(randomUUIDString); //Generate Automatic ID

        Date d = new Date();
        exam.setStart_time(d);

        model.addObject("exam",exam);
        examDao.saveExam(exam);

        return model;
    }


}
