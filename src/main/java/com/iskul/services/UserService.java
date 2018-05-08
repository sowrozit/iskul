package com.iskul.services;

import com.iskul.model.User;

import java.util.List;

/**
 * Created by Sowrozit on 2/26/2017.
 */
public interface UserService {

    public void addUser(User user);

    public List<User> getAllUsers();

    public void deleteUser(Integer userId);

    public User getUser(int userid);

    public User updateUser(User user);


}
