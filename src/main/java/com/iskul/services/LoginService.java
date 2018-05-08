package com.iskul.services;

/**
 * Created by Sowrozit on 2/6/2017.
 */
import com.iskul.model.*;

public interface LoginService{
    public User checkLogin(String userName, String password);
}