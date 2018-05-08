package com.iskul.dao;

import com.iskul.model.Questions;
import com.iskul.model.Subject;
import com.iskul.model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sowrozit on 3/7/2017.
 */

@Repository
public class QuestionDaoImpl implements QuestionDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void addQuestion(Questions questions) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(questions);
        session.close();
    }

    @Override
    public List<Questions> getAllQuestions() {
        Session session = sessionFactory.openSession();
        List<Questions>  questions = session.createQuery("from Questions").list();
        session.close();
        return questions;
    }

    @Override
    public List<Questions> showAllQuestionsByTopicId(int id) {
        Session session = sessionFactory.openSession();
        List<Questions> listOfQuestion = session.createQuery("from Questions q where q.topic.id=:id").setParameter("id", id).list();
        session.close();
        return listOfQuestion;
    }

    @Override
    public List<Subject> getAllSubjectsByCategoryForQuiz(int id) {
        Session session = sessionFactory.openSession();
        List<Subject> subjects = session.createQuery("from Subject s where s.category.id=:id").setParameter("id", id).list();
        session.close();
        return subjects;
    }

    @Override
    public List<Topic> getAllTopicsBySubjectForQuiz(int id) {
        Session session = sessionFactory.openSession();
        List<Topic> topics = session.createQuery("from Topic t where t.subject.id=:id").setParameter("id", id).list();
        session.close();
        return topics;
    }

    @Override
    public List<Questions> showLimitedQuestionByTopicId(int id) {
        Session session = sessionFactory.openSession();
        List<Questions> listOfQuestion = session.createQuery("SELECT  q from Questions q where q.topic.id=:id  order by rand()").setParameter("id", id).setMaxResults(2).list();
        session.close();
        return listOfQuestion;
    }

    @Override
    public void deleteQuestion(Integer questionId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Questions questions = (Questions) session.load(Questions.class,questionId);
        session.delete(questions);
        session.getTransaction().commit();
        session.close();

    }

    @Override
    public Questions updateQuestion(Questions questions) {
        System.out.println("q update");
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(questions);
        session.getTransaction().commit();
        session.close();
        return questions;
    }

    @Override
    public Questions getQuestion(int questionid) {
        Session session = sessionFactory.openSession();
        Questions questions = (Questions) session.get(Questions.class,questionid);
        session.close();
        return questions;
    }
}
