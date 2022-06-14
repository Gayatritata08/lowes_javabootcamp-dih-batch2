package com.assignments.empapp.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.assignments.empapp.dao.UserDao;
import com.assignments.empapp.model.Login;
import com.assignments.empapp.model.User;

public class UserServiceImpl implements UserService {

  @Autowired
  public UserDao userDao;

  public int register(User user) {
    return userDao.register(user);
  }

  public User validateUser(Login login) {
    return userDao.validateUser(login);
  }

}