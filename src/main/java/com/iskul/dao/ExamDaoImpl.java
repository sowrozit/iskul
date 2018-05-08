package com.iskul.dao;

import com.iskul.model.Exams;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Created by Sowrozit on 4/10/2017.
 */
@Repository
public class ExamDaoImpl implements ExamDao {

    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void saveExam(Exams exams) {
        Session session = sessionFactory.openSession();
        session.createQuery("from Exams");
        session.save(exams);
        session.close();
    }

    @Override
    public Exams getUniqueId(String uniqueId) {
        Session session=sessionFactory.openSession();
        Exams exam = (Exams) session.createQuery("select e from Exams e where  e.unique_id =:uniqueId")
                .setParameter("uniqueId", uniqueId).uniqueResult();

        return exam;
    }

    @Override
    public Exams getExams(int examid) {
        Session session = sessionFactory.openSession();
        Exams exams =  (Exams) session.get(Exams.class,examid);
        session.close();
        return exams;
    }




}
