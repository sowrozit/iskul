package com.iskul.dao;

import com.iskul.model.Subject;

import java.util.List;

/**
 * Created by Sowrozit on 2/27/2017.
 */
public interface SubjectDao {
    public void addSubject(Subject subject);

    public List<Subject> getAllSubjects();

    public List<Subject> showAllSubjectsByCategory(int id);

    public void deleteSubject(Integer subjectId);

    public Subject updateSubject(Subject subject);

    public Subject getSubject(int subjectid);
}
