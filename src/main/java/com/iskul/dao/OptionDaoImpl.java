package com.iskul.dao;

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
public class OptionDaoImpl implements OptionDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addOption(Options options) {
        Session session = sessionFactory.openSession();
        session.saveOrUpdate(options);
        session.close();

    }

    @Override
    public List<Options> getAllOptions() {
        Session session = sessionFactory.openSession();
        List<Options>  options = session.createQuery("from Options").list();
        session.close();
        return options;
    }


    @Override
    public void deleteOption(Integer optionId) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Options options  = (Options) session.load(Options.class,optionId);
        session.delete(options);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Options updateOption(Options options) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        session.merge(options);
        session.getTransaction().commit();
        session.close();
        return options;
    }

    @Override
    public Options getOption(int optionid) {
        Session session = sessionFactory.openSession();
        Options options  = (Options) session.get(Options.class,optionid);
        session.close();
        return options;
    }
}
