package com.assignments.empapp.service;

import com.assignments.empapp.model.Login;
import com.assignments.empapp.model.User;

public interface UserService {

	int register(User user);

	User validateUser(Login login);
}