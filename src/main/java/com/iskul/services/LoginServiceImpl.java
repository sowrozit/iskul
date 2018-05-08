package com.iskul.services;

/**
 * Created by Sowrozit on 2/6/2017.
 */

import com.iskul.dao.*;
import com.iskul.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service("loginService")
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginDAO loginDAO;

    public void setLoginDAO(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    public User checkLogin(String userName, String password){
        System.out.println("In Service class...Check Login");
        return loginDAO.checkLogin(userName, password);
    }
}