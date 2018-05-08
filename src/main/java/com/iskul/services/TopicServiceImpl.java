package com.iskul.services;

import com.iskul.dao.TopicDao;

import com.iskul.model.Topic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sowrozit on 2/27/2017.
 */
@Service
@Transactional
public class TopicServiceImpl implements TopicService {

    @Autowired
    private TopicDao topicDao;

    @Override
    @Transactional
    public void addTopic(Topic topic)
    {
        topicDao.addTopic(topic);
    }

    @Override
    @Transactional
    public List<Topic> getAllTopics()
    {
        return topicDao.getAllTopics();
    }

    @Override
    @Transactional
    public void deleteTopic(Integer topicId)
    {
        topicDao.deleteTopic(topicId);
    }

    @Override
    public Topic updateTopic(Topic topic) {
        return topicDao.updateTopic(topic);
    }

    public Topic getTopic(int topicid)
    {
        return topicDao.getTopic(topicid);
    }


    public void setTopicDao(TopicDao topicDao)
    {
        this.topicDao = topicDao;
    }

}
