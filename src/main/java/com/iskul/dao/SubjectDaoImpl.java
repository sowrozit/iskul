package com.iskul.dao;

import com.iskul.model.Subject;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sowrozit on 2/27/2017.
 */
@Repository
public class SubjectDaoImpl implements SubjectDao {


    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addSubject(Subject subject)
    {
        Session session = this.sessionFactory.openSession();
        session.saveOrUpdate(subject);
        session.close();
    }
    public List<Subject> getAllSubjects()
    {
        Session session = sessionFactory.openSession();
        List<Subject> subject = session.createQuery("from Subject").list();
        session.close();
        return subject;
    }

    //For Showing All Subjects By Category

    @Override
    public List<Subject> showAllSubjectsByCategory(int id) {
        Session session = sessionFactory.openSession();
        List<Subject> subjects = session.createQuery("from Subject s where s.category.id=:id").setParameter("id", id).list();
        session.close();
        return subjects;
    }


    @Override
    public void deleteSubject(Integer subjectId) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        Subject subject =(Subject)session.load(Subject.class,subjectId);
        session.delete(subject);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Subject getSubject(int subid) {
        Session session = sessionFactory.openSession();
        Subject subject = (Subject) session.get(Subject.class,subid);
        session.close();
        return subject;
    }

    @Override
    public Subject updateSubject(Subject subject) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.merge(subject);
        session.getTransaction().commit();
        session.close();
        return subject;


    }



}
