package com.assignments.empapp.dao;

import com.assignments.empapp.model.Login;
import com.assignments.empapp.model.User;

public interface UserDao {

	int register(User user);

	User validateUser(Login login);
}