package com.iskul.dao;

import com.iskul.model.Result;
import com.iskul.model.Topic;
import com.iskul.model.User;

import java.util.List;


/**
 * Created by Sowrozit on 4/10/2017.
 */
public interface ResultDao {

    public void saveResult(Result result);

    public List<Result> resultByUser(User user);

    public List<Result> resultByTopic(Topic topic);

}
