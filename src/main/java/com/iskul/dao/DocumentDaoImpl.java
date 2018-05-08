//package com.iskul.dao;
//
//import com.iskul.model.Document;
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.hql.internal.ast.tree.SessionFactoryAwareNode;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import javax.print.Doc;
//import java.util.List;
//
///**
// * Created by Sowrozit on 5/5/2017.
// */
//@Repository
//public class DocumentDaoImpl implements DocumentDao {
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @Override
//    public void addDocument(Document document) {
//        Session session = sessionFactory.openSession();
//        session.save(document);
//        session.close();
//    }
//
//    @Override
//    public List<Document> getAllDocuments() {
//        Session session = sessionFactory.openSession();
//        List<Document> documentList = session.createQuery("from Documents").list();
//        session.close();
//        return documentList;
//    }
//
//    @Override
//    public void deleteDocument(Integer docId) {
//        Session session = sessionFactory.openSession();
//        session.beginTransaction();
//        Document document = (Document) session.get(Document.class,docId);
//        session.delete(document);
//        session.getTransaction().commit();
//        session.close();
//    }
//
//    @Override
//    public Document getDocument(int docid) {
//        Session session = sessionFactory.openSession();
//        Document document = (Document) session.get(Document.class,docid);
//        session.close();
//        return document;
//    }
//}
