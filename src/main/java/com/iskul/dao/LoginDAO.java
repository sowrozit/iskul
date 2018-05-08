package com.iskul.dao;

/**
 * Created by Sowrozit on 2/6/2017.
 */

import com.iskul.model.*;

public interface LoginDAO{
    public User checkLogin(String userName, String password);
}
