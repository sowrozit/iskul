package com.iskul.controllers;


import com.iskul.dao.*;
import com.iskul.forms.QuestionsForm;
import com.iskul.model.*;
import com.iskul.services.CategoryService;
import com.iskul.services.TopicService;

import org.json.simple.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.jboss.logging.Logger;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

import javax.validation.Valid;

import java.io.IOException;

import java.util.ArrayList;

import java.util.Collection;
import java.util.Date;
import java.util.List;


import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 * Created by Sowrozit on 3/7/2017.
 */
@Controller
public class QuizController {

    private static final Logger logger = org.jboss.logging.Logger
            .getLogger(QuizController.class);

    public QuizController()
    {
        System.out.println("QuizController");
    }


    @Autowired
    private TopicDao topicDao;

    @Autowired
    private QuestionDao questionDao;

    @Autowired
    private OptionDao optionDao;

    @Autowired
    private AnswerDao answerDao;

    @Autowired
    private TopicService topicService;

    @Autowired
    private ExamDao examDao;

    @Autowired
    private ResultDao resultDao;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private CategoryDao categoryDao;


    @RequestMapping(value = "/manage/adminTeacher/quiz_manage")
    public ModelAndView listQuestions(ModelAndView model, HttpServletRequest request) throws IOException{
        List<Questions> questionsList = questionDao.getAllQuestions();
        model.addObject("questionList",questionsList);
        model.setViewName("quiz_manage");
        return  model;
    }


    @RequestMapping(value = "/manage/adminTeacher/addQuestion",method = RequestMethod.GET)
    public ModelAndView showQuizForm( ModelAndView model,@ModelAttribute("question") Questions questions)throws IOException{
        QuestionsForm questionsForm = new QuestionsForm();
        model.addObject("questionForm",questionsForm);
        List<Topic> topicList = topicDao.getAllTopics();
        model.addObject("topicList",topicList);
        List<Category> listCategoryForQuiz = categoryDao.getAllCategories();
        model.addObject("listCategoryForQuiz", listCategoryForQuiz);
        model.addObject("question",questions);
        model.setViewName("quizForm");
        return model;
    }

    @RequestMapping(value = "/manage/adminTeacher/addQuestion",method = RequestMethod.POST)
    public ModelAndView addQuestion(@Valid @ModelAttribute("questionForm")  QuestionsForm questionsForm, BindingResult result, HttpServletRequest request, ModelAndView model,Model model1) {

        if (result.hasErrors()) {
            System.out.println("if");

            model.addObject("questionForm", questionsForm);
            List<Topic> topicList = topicDao.getAllTopics();
            model.addObject("topicList", topicList);
            model.setViewName("quizForm");

            return model;

        }
        else {
            System.out.println("else");

            Questions questions;

            if (questionsForm.getId() == 0)
            {
                System.out.println("addQuestion");
                questions = new Questions();


                Topic topic = topicDao.getTopic(questionsForm.getTopic());
                questions.setQuestion(questionsForm.getQuestion());
                questions.setTopic(topic);

                questionDao.addQuestion(questions);

                Options options1 = new Options(questionsForm.getOption1(), questions);
                Options options2 = new Options(questionsForm.getOption2(), questions);
                Options options3 = new Options(questionsForm.getOption3(), questions);
                Options options4 = new Options(questionsForm.getOption4(), questions);

                optionDao.addOption(options1);
                optionDao.addOption(options2);
                optionDao.addOption(options3);
                optionDao.addOption(options4);

                Answers answers = new Answers();
                answers.setQuestions(questions);

                if(questionsForm.getCorrectAnswer().equals("1")){
                    answers.setOptions(options1);
                }else if (questionsForm.getCorrectAnswer().equals("2")){
                    answers.setOptions(options2);
                }else if (questionsForm.getCorrectAnswer().equals("3")){
                    answers.setOptions(options3);
                }else if (questionsForm.getCorrectAnswer().equals("4")){
                    answers.setOptions(options4);
                }
                answerDao.addAnswer(answers);
                questionDao.addQuestion(questions);
            }
            else {
                questions = questionDao.getQuestion(questionsForm.getId());


                List<Options> optionList = (List<Options>)questions.getOptions();
                Options option1 = optionList.get(0);
                option1.setOption(questionsForm.getOption1());
                optionDao.updateOption(option1);
                Options option2 = optionList.get(1);
                option2.setOption(questionsForm.getOption2());
                optionDao.updateOption(option2);
                Options option3 = optionList.get(2);
                option3.setOption(questionsForm.getOption3());
                optionDao.updateOption(option3);
                Options option4 = optionList.get(3);
                option4.setOption(questionsForm.getOption4());
                optionDao.updateOption(option4);

                questions.setQuestion(questionsForm.getQuestion());
                Topic topic = topicDao.getTopic(questionsForm.getTopic());
                questions.setTopic(topic);

                questionDao.updateQuestion(questions);


                Answers answers = questions.getAnswers();
                if(questionsForm.getCorrectAnswer().equals("1")){
                    answers.setOptions(option1);
                }else if (questionsForm.getCorrectAnswer().equals("2")){
                    answers.setOptions(option2);
                }else if (questionsForm.getCorrectAnswer().equals("3")){
                    answers.setOptions(option3);
                }else if (questionsForm.getCorrectAnswer().equals("4")){
                    answers.setOptions(option4);
                }
                answerDao.updateAnswer(answers);

                System.out.println("editQuestion");

            }

            return new ModelAndView("redirect:/manage/adminTeacher/quiz_manage");
        }
    }


//    @ResponseBody
    @RequestMapping(value = "/manage/adminTeacherStudent/quizSubmission", method = RequestMethod.POST)
    public String quizSubmission(@ModelAttribute("questionForm") QuestionsForm questionsForm, BindingResult result, Model model, HttpServletRequest request) throws IOException{
        try {
        String jsonString = request.getParameter("questions");
        String uid = request.getParameter("id");

        Exams exams = examDao.getUniqueId(uid);

        Date now = new Date();

        Date checkDate = new Date(System.currentTimeMillis()-1*60*1000);


        if(exams.getStart_time().after(checkDate)){
            System.out.print("ex");
            JSONParser parser = new JSONParser();

            Object object = parser.parse(jsonString);

            JSONArray array = (JSONArray) object;

            ArrayList<Integer> questionIds = new ArrayList<Integer>();
            for(int i = 0; i<array.size();i++){
                JSONObject jsonObject = (JSONObject) array.get(i);
                questionIds.add(Integer.parseInt(jsonObject.get("questionId").toString()));
            }

            System.out.println("here");
            List<Answers> answersList = answerDao.getAllAnswersByQuestionId(questionIds);
            int marks = 0;

            for (int i = 0;i<array.size();i++)
            {
                JSONObject jsonObject = (JSONObject)array.get(i);
                int qId = Integer.parseInt(jsonObject.get("questionId").toString());

                int oId = 0;

                if(jsonObject.get("optionId")!=null){
                    oId = Integer.parseInt(jsonObject.get("optionId").toString());
                }

                for (int j= 0; j<answersList.size();j++)
                {
                    if (answersList.get(j).getQuestions().getId() == qId && answersList.get(j).getOptions().getId() == oId){
                        marks ++;
                    }
                }

            }

            int full_marks = 10;
            model.addAttribute("jsonObject",array);
            model.addAttribute("answers", answersList);
            model.addAttribute("marks", marks);
            model.addAttribute("fullMarks",full_marks);


            System.out.println(marks);

            //save to db
            System.out.println("result");
            Result result1 = new Result();
            result1.setTopic(exams.getTopic());
            result1.setUser(exams.getUser());
            result1.setEarned_marks(marks);
            result1.setFull_marks(full_marks);

            Date date = new Date();
            result1.setDate(date);

            resultDao.saveResult(result1);


        }
        else{
            System.out.print("expired");
        }
             } catch (ParseException e) {
                 e.printStackTrace();
             }


        return "test";
    }

//    @Autowired
//    TopicService topicService;
//
//    @RequestMapping(value = "manage/adminTeacherStudent/quizResult",method = RequestMethod.GET)
//    public ModelAndView quizResult(ModelAndView model,HttpServletRequest request){
//        System.out.println("Quiz Result");
////
////        int id = Integer.parseInt(request.getParameter("id"));
////        Topic topic  = topicService.getTopic(id);
////        model.addObject("topic",topic);
////        List<Questions> listOfQuestion = questionDao.showAllQuestionsByTopicId(topic.getId());
////        model.addObject("listOfQuestion",listOfQuestion);
//        model.setViewName("quizResult");
//        return model;
//    }

    @RequestMapping(value = "/manage/adminTeacher/editQuestion", method = RequestMethod.GET)
    public ModelAndView editQuestion(HttpServletRequest request) {
        int questionId = Integer.parseInt(request.getParameter("id"));
        Questions questions = questionDao.getQuestion(questionId);
        QuestionsForm questionsForm = new QuestionsForm();
        questionsForm.setQuestion(questions.getQuestion());
        List<Options> options = (List<Options>)questions.getOptions();
        questionsForm.setOption1(options.get(0).getOption());
        questionsForm.setOption2(options.get(1).getOption());
        questionsForm.setOption3(options.get(2).getOption());
        questionsForm.setOption4(options.get(3).getOption());
        questionsForm.setTopic(questions.getTopic().getId());
        questionsForm.setId(questions.getId());
        questionsForm.setCorrectAnswer(questions.getAnswers().getOptions().getOption());
        ModelAndView model = new ModelAndView("quizForm");
        List<Topic> topicList = topicService.getAllTopics();
        model.addObject("topicList",topicList);
        model.addObject("questionForm",questionsForm);
        System.out.println("edit");
        return model;
    }

    @RequestMapping(value = "/manage/adminTeacher/deleteQuestion", method = RequestMethod.GET)
    public ModelAndView deleteQuestion(HttpServletRequest request) {

        QuestionsForm questionsForm = new QuestionsForm();

        int questionId = Integer.parseInt(request.getParameter("id"));
        Questions questions = questionDao.getQuestion(questionId);



        Answers answers = questions.getAnswers();
        answerDao.deleteAnswer(answers.getId());



        List<Options> optionList = (List<Options>)questions.getOptions();

        Options options1 = optionList.get(0);
        optionDao.deleteOption(options1.getId());
        Options options2 = optionList.get(1);
        optionDao.deleteOption(options2.getId());
        Options options3 = optionList.get(2);
        optionDao.deleteOption(options3.getId());
        Options options4 = optionList.get(3);
        optionDao.deleteOption(options4.getId());



        questionDao.deleteQuestion(questionId);

        System.out.println("end");
        return new ModelAndView("redirect:/manage/adminTeacher/quiz_manage");
    }


    @ResponseBody
    @RequestMapping(value = "/manage/adminTeacher/getSubjectsForQuiz", method = RequestMethod.GET)
    public String getSubjectsByCategoryForQuiz(ModelAndView model,HttpServletRequest request)throws IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        List<Subject> listSubjectForQuiz = questionDao.getAllSubjectsByCategoryForQuiz(id);
        String optionHtmlForSubject = "";
        for(int i = 0; i < listSubjectForQuiz.size(); i++){
            optionHtmlForSubject += "<option value="+ listSubjectForQuiz.get(i).getId()+">" +
                    listSubjectForQuiz.get(i).getSub_title() +"</option>";
        }
        return optionHtmlForSubject;
    }

    @ResponseBody
    @RequestMapping(value = "/manage/adminTeacher/getTopicsForQuiz", method = RequestMethod.GET)
    public String getTopicsBySubjectForQuiz(ModelAndView model,HttpServletRequest request)throws IOException{
        int id = Integer.parseInt(request.getParameter("id"));
        List<Topic> listTopicForQuiz = questionDao.getAllTopicsBySubjectForQuiz(id);
        String optionHtmlForTopic = "";
        for(int i = 0; i < listTopicForQuiz.size(); i++){
            optionHtmlForTopic += "<option value="+ listTopicForQuiz.get(i).getId()+">" +
                    listTopicForQuiz.get(i).getTopic_title() +"</option>";
        }
        return optionHtmlForTopic;
    }
}
