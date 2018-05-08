package com.iskul.dao;

import com.iskul.model.Registration;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Sowrozit on 2/9/2017.
 */

@Repository("RegistrationDao")


public class RegistrationDaoImpl implements RegistrationDao {

    @Autowired
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory)

    {
        this.sessionFactory=sessionFactory;
    }
    @Override
    public void saveRegistration(Registration registration) {

        Session session = sessionFactory.openSession();
        Transaction tx =session.beginTransaction();
        if(registration!=null)
        {
            try {
                session.save(registration);
                tx.commit();
                session.close();
            }catch (Exception e)
            {
                tx.rollback();
                session.close();
                e.printStackTrace();
            }
        }

    }

}
