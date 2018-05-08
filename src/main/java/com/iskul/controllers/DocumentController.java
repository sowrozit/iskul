//package com.iskul.controllers;
//
//import com.iskul.dao.DocumentDao;
//import com.iskul.dao.TopicDao;
//import com.iskul.model.Document;
//import com.iskul.model.Topic;
//import org.apache.commons.io.IOUtils;
//import org.hibernate.Hibernate;
//import org.hibernate.SessionFactory;
//import org.jboss.logging.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletResponse;
//import javax.validation.Valid;
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//import java.sql.Blob;
//import java.sql.SQLException;
//import java.util.List;
//
///**
// * Created by Sowrozit on 5/5/2017.
// */
//@Controller
//public class DocumentController {
//
//    private static final Logger logger = org.jboss.logging.Logger
//            .getLogger(QuizController.class);
//
//    public DocumentController()
//    {
//        System.out.println("DocumentController");
//    }
//
//    @Autowired
//    private DocumentDao documentDao;
//
//    @Autowired
//    private TopicDao topicDao;
//
//    @Autowired
//    private SessionFactory sessionFactory;
//
//    @RequestMapping(value = "/manage/adminTeacher/newFile1",method = RequestMethod.GET)
//    public ModelAndView showDocumentForm(ModelAndView model) throws IOException {
//
//        Document document = new Document();
//        model.addObject("document",document);
//        List<Document> documentList =documentDao.getAllDocuments();
//        model.addObject("documentList",documentList);
//        List<Topic> topicList = topicDao.getAllTopics();
//        model.addObject("topicList",topicList);
//        model.setViewName("documentForm");
//        return model;
//    }
//
//    @RequestMapping(value = "/manage/adminTeacher/newFile", method = RequestMethod.POST)
//    public String addDocument(@Valid @ModelAttribute("document") Document document, @RequestParam("file") MultipartFile file, BindingResult result, ModelAndView model) {
//
//        if (result.hasErrors()){
//            return "documentForm";
//        }
//        else{
//            try {
//                InputStream stream = null;
//                Blob blob = Hibernate.getLobCreator(sessionFactory.getCurrentSession()).createBlob(IOUtils.toByteArray(stream));
////            Blob blob =Hibernate.getLobCreator(HibernateUtil.getSessionFactory().getCurrentSession()).createBlob(file.getInputStream());
//                document.setFilename(file.getOriginalFilename());
//                document.setContent(blob);
//                document.setContent_type(file.getContentType());
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
//            try {
//                documentDao.addDocument(document);
//            } catch(Exception e) {
//                e.printStackTrace();
//            }
//
//            return "redirect:/manage/adminTeacher/document_manage";
//        }
//
//    }
//
//    @RequestMapping("/manage/adminTeacher/download/{documentId}")
//    public String download(@PathVariable("docid")
//                                   int docid, HttpServletResponse response) {
//
//        Document doc = documentDao.getDocument(docid);
//        try {
//            response.setHeader("Content-Disposition", "inline;filename=\"" +doc.getFilename()+ "\"");
//            OutputStream out = response.getOutputStream();
//            response.setContentType(doc.getContent_type());
//            IOUtils.copy(doc.getContent().getBinaryStream(), out);
//            out.flush();
//            out.close();
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//
//        return null;
//    }
//
//    @RequestMapping("/manage/adminTeacher/remove/{documentId}")
//    public String remove(@PathVariable("docId")Integer docId) {
//
//        documentDao.deleteDocument(docId);
//
//        return "redirect:/index.html";
//    }
//}
