package com.iskul.services;

import com.iskul.dao.SubjectDao;
import com.iskul.dao.UserDao;
import com.iskul.model.Subject;
import com.iskul.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sowrozit on 2/27/2017.
 */
@Service
@Transactional
public class SubjectServiceImpl implements SubjectService {

    @Autowired
    private SubjectDao subjectDao;

    @Override
    @Transactional
    public void addSubject(Subject subject)
    {
        subjectDao.addSubject(subject);
    }

    @Override
    @Transactional
    public List<Subject> getAllSubjects()
    {
        return subjectDao.getAllSubjects();
    }

    @Override
    @Transactional
    public void deleteSubject(Integer subjectId)
    {
        subjectDao.deleteSubject(subjectId);
    }

    public Subject getSubject(int subid)
    {
        return subjectDao.getSubject(subid);
    }

    public Subject updateSubject(Subject subject)
    {
        return subjectDao.updateSubject(subject);
    }

    public void setSubjectDao(SubjectDao subjectDao)
    {
        this.subjectDao = subjectDao;
    }

}
