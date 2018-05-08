package com.iskul.dao;

import com.iskul.model.Options;
import com.iskul.model.Questions;

import java.util.List;

/**
 * Created by Sowrozit on 3/7/2017.
 */
public interface OptionDao {

    public void addOption(Options options);

    public List<Options> getAllOptions();

//    public List<Options> getAllOptionsByQuestionId(Integer qsOpId);

    public void deleteOption(Integer optionId);

    public Options updateOption(Options options);

    public Options getOption(int optionid);
}
