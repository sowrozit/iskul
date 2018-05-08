package com.iskul.services;

import com.iskul.model.Topic;
import org.omg.CORBA.INTERNAL;

import java.util.List;

/**
 * Created by Sowrozit on 2/27/2017.
 */
public interface TopicService {

    public void addTopic (Topic topic);

    public List<Topic> getAllTopics();

    public void deleteTopic(Integer topicId);

    public Topic updateTopic(Topic topic);

    public Topic getTopic(int topicid);
}
