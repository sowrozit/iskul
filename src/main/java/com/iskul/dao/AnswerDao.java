package com.iskul.dao;

import com.iskul.model.Answers;
import com.iskul.model.Questions;

import java.util.List;

/**
 * Created by Sowrozit on 3/7/2017.
 */
public interface AnswerDao {

    public void addAnswer(Answers answers);

    public List<Answers> getAllAnswers();

    public List<Answers> getAllAnswersByQuestionId(List<Integer> questionIds);

    public void deleteAnswer(Integer answerId);

    public Answers updateAnswer(Answers answers);

    public Answers getAnswer(int answerid);
}
