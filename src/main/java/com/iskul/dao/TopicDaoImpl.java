package com.iskul.dao;

import com.iskul.model.Subject;
import com.iskul.model.Topic;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sowrozit on 2/27/2017.
 */
@Repository
public class TopicDaoImpl implements TopicDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addTopic(Topic topic) {
        Session session = this.sessionFactory.openSession();
        session.saveOrUpdate(topic);
        session.close();
    }
    @Override
    public List<Topic> getAllTopics() {
        Session session = sessionFactory.openSession();
        List<Topic> topics =session.createQuery("from Topic").list();
        session.close();
        return topics;
    }

    @Override
    public List<Subject> getAllSubjectsByCategory(int id) {
        Session session = sessionFactory.openSession();
        List<Subject> subjects = session.createQuery("from Subject s where s.category.id=:id").setParameter("id", id).list();
        session.close();
        return subjects;
    }

    @Override
    public List<Topic> showAllTopicsBySubject(int id) {
        Session session = sessionFactory.openSession();
        List<Topic> topics = session.createQuery("from Topic t where t.subject.id=:id").setParameter("id", id).list();
        session.close();
        return topics;
    }


    @Override
    public void deleteTopic(Integer topicId) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        Topic topic = (Topic) session.load(Topic.class,topicId);
        session.delete(topic);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Topic updateTopic(Topic topic) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.merge(topic);
        session.getTransaction().commit();
        session.close();
        return topic;
    }

    @Override
    public Topic getTopic(int topicid)
    {
        Session session = sessionFactory.openSession();
        Topic topic = (Topic) session.get(Topic.class,topicid);
        session.close();
        return topic;
    }
}
