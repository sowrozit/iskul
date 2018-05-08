package com.iskul.dao;

import com.iskul.model.*;

import java.util.List;

/**
 * Created by Sowrozit on 3/7/2017.
 */
public interface QuestionDao {

    public void addQuestion(Questions questions);

    public List<Questions> getAllQuestions();

    public List<Questions> showAllQuestionsByTopicId(int id);

    public List<Subject> getAllSubjectsByCategoryForQuiz(int id);

    public List<Topic> getAllTopicsBySubjectForQuiz(int id);

    public List<Questions> showLimitedQuestionByTopicId(int id);


    public void deleteQuestion(Integer questionId);

    public Questions updateQuestion(Questions questions);

    public Questions getQuestion(int questionid);
}
