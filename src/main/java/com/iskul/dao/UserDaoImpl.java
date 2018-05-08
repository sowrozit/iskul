package com.iskul.dao;

import com.iskul.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Sowrozit on 2/26/2017.
 */

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addUser(User user)
    {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(user);
        session.close();
//        sessionFactory.getCurrentSession().saveOrUpdate(user);
    }

    public List<User> getAllUsers()
    {
        Session session = sessionFactory.openSession();
        List<User> users = session.createQuery("from User").list();
        session.close();
        return users;
//        return sessionFactory.getCurrentSession().createQuery("from User").list();
    }

    @Override
    public void deleteUser(Integer userId) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        User user = (User) session.load(User.class,userId);
        session.delete(user);
        session.getTransaction().commit();
        session.close();

//        if(null != user)
//        {
//            this.sessionFactory.getCurrentSession().delete(user);
//        }
    }

    public User getUser(int usrid) {
        Session session = sessionFactory.openSession();
        User user = (User) session.get(User.class,usrid);
        session.close();
        return user;
//        return (User)sessionFactory.getCurrentSession().get(User.class,usrid);
    }

    @Override
    public User updateUser(User user)
    {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.merge(user);
        session.getTransaction().commit();
        session.close();
        return user;
    }

}
