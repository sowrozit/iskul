package com.iskul.dao;

import com.iskul.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Sowrozit on 4/28/2017.
 */

@Repository
public class ProfileDaoImpl implements ProfileDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public User showUserProfile(User user) {
        Session session = sessionFactory.openSession();
        User u = (User) session.createQuery("from User").list();
        session.close();
        return user;
    }
}
