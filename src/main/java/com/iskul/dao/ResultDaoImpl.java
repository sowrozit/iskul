package com.iskul.dao;

import com.iskul.model.Result;
import com.iskul.model.Topic;
import com.iskul.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sowrozit on 4/10/2017.
 */
@Repository
public class ResultDaoImpl implements ResultDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void saveResult(Result result) {
        Session session = sessionFactory.openSession();
        session.createQuery("from Result");
        session.save(result);
        session.close();
    }

    @Override
    public List<Result> resultByUser(User user) {

        Session session = sessionFactory.openSession();
        List<Result> results = session.createQuery("from Result  r where r.user in (:user) ")
                .setParameter("user", user)
                .list();
        session.close();
        return results;
    }

    @Override
    public List<Result> resultByTopic(Topic topic) {

        Session session = sessionFactory.openSession();
        List<Result> results = session.createQuery("from Result r where  r.topic in (:topic)")
                .setParameter("topic",topic)
                .list();
        return results;
    }
}
