package com.iskul.dao;

import com.iskul.model.Subject;
import com.iskul.model.Topic;
import com.iskul.model.User;

import java.util.List;

/**
 * Created by Sowrozit on 2/27/2017.
 */
public interface TopicDao {

    public void addTopic(Topic topic);

    public List<Topic> getAllTopics();

    public List<Subject> getAllSubjectsByCategory(int id);

    public List<Topic> showAllTopicsBySubject(int id);

    public void deleteTopic(Integer topicId);

    public Topic updateTopic(Topic topic);

    public Topic getTopic(int topicid);
}
