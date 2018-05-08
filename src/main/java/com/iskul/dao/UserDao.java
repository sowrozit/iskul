package com.iskul.dao;

import com.iskul.model.User;

import java.util.List;

/**
 * Created by Sowrozit on 2/25/2017.
 */
public interface UserDao {

    public void addUser(User user);

    public List<User> getAllUsers();

    public void deleteUser(Integer userId);

    public User updateUser(User user);

    public User getUser(int userid);

}
