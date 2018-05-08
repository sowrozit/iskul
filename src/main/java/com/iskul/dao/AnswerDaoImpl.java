package com.iskul.dao;

import com.iskul.model.Answers;
import com.iskul.model.Options;
import com.iskul.model.Questions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sowrozit on 3/7/2017.
 */

@Repository
public class AnswerDaoImpl implements AnswerDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void addAnswer(Answers answers) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(answers);
        session.close();
    }

    @Override
    public List<Answers> getAllAnswers() {
        Session session = sessionFactory.openSession();
        List<Answers>  answerss = session.createQuery("from Answers").list();
        session.close();
        return answerss;
    }

    @Override
    public List<Answers> getAllAnswersByQuestionId(List<Integer> questionIds) {
        Session session =sessionFactory.openSession();
        List<Answers> answers = session.createQuery("from Answers  a where a.questions.id in (:questionIds) ")
                .setParameterList("questionIds", questionIds)
                .list();

        session.close();
        return answers;
    }

    @Override
    public void deleteAnswer(Integer answerId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Answers answers = (Answers) session.load(Answers.class,answerId);
        session.delete(answers);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Answers updateAnswer(Answers answers) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(answers);
        session.getTransaction().commit();
        session.close();
        return answers;
    }

    @Override
    public Answers getAnswer(int answerid) {
        Session session = sessionFactory.openSession();
        Answers answers  = (Answers) session.get(Answers.class,answerid);
        session.close();
        return answers;
    }
}
