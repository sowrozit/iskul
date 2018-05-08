package com.iskul.services;

import com.iskul.dao.UserDao;
import com.iskul.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Sowrozit on 2/26/2017.
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    @Transactional
    public void addUser(User user)
    {
        userDao.addUser(user);
    }

    @Override
    @Transactional
    public List<User> getAllUsers()
    {
        return userDao.getAllUsers();
    }

    @Override
    @Transactional
    public void deleteUser(Integer userId)
    {
        userDao.deleteUser(userId);
    }

    public User getUser(int usrid)
    {
        return userDao.getUser(usrid);
    }

    public User updateUser(User user)
    {
        return userDao.updateUser(user);
    }

    public void setUserDao(UserDao userDao)
    {
        this.userDao = userDao;
    }


}
