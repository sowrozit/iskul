package com.iskul.services;

import com.iskul.model.Subject;
import com.iskul.model.User;

import java.util.List;

/**
 * Created by Sowrozit on 2/27/2017.
 */
public interface SubjectService {

    public void addSubject(Subject  subject);

    public List<Subject> getAllSubjects();

    public void deleteSubject(Integer subjectId);

    public Subject getSubject(int subjectid);

    public Subject updateSubject(Subject subject);
}
