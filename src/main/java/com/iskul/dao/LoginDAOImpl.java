package com.iskul.dao;

/**
 * Created by Sowrozit on 2/6/2017.
 */

import com.iskul.model.*;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

@Repository("loginDAO")
public class LoginDAOImpl implements LoginDAO{


    @Resource(name="sessionFactory")
    protected SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    protected Session getSession(){
        return sessionFactory.openSession();
    }

    public User checkLogin(String userName, String password){
        System.out.println("In Check login");
        Session session = sessionFactory.openSession();


        String SQL_QUERY =" from User as o where o.userName=:n and o.password=:p ";//Query using Hibernate Query Language
        Query query = session.createQuery(SQL_QUERY);
        query.setParameter("n",userName);
        query.setParameter("p",password);
        User usr = (User) query.uniqueResult();
        return  usr;
    }
}