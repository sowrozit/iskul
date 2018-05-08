package com.iskul.dao;

import com.iskul.model.Exams;

/**
 * Created by Sowrozit on 4/10/2017.
 */
public interface ExamDao {

    public void saveExam(Exams exams);

    public Exams getUniqueId(String uniqueId);

    public Exams getExams(int examid);

}
