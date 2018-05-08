package com.iskul.dao;

import com.iskul.model.Category;
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
public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addCategory(Category category)
    {
        Session session = this.sessionFactory.openSession();
        session.saveOrUpdate(category);
        session.close();
//        sessionFactory.getCurrentSession().saveOrUpdate(category);
    }

    public List<Category> getAllCategories()
    {
        Session session = this.sessionFactory.openSession();
        List<Category> categories = session.createQuery("from  Category").list();
        session.close();
        return categories;
//        return sessionFactory.getCurrentSession().createQuery("from Category").list();
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        Category category = (Category) session.load(Category.class,categoryId);
        session.delete(category);
        session.getTransaction().commit();
        session.close();
//        if(null != category)
//        {
//            this.sessionFactory.getCurrentSession().delete(category);
//        }
    }

    public Category getCategory(int ctgid) {
        Session session = this.sessionFactory.openSession();
        Category category =(Category) session.get(Category.class,ctgid);
        session.close();
        return category;

    }

    @Override
    public Category updateCategory(Category category) {
        Session session = this.sessionFactory.openSession();
        session.beginTransaction();
        session.merge(category);
        session.getTransaction().commit();
        session.close();
        return category;
    }

    @Override
    public List<Subject> showAllSubjectsByCategory() {
        Session session = sessionFactory.openSession();
        List<Subject> subjects = session.createQuery("from Subject").list();
        session.close();
        return subjects;
    }
}
