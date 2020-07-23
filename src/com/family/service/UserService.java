package com.family.service;

import com.family.domain.Result;
import com.family.domain.User;

public interface UserService {

	User findOne(String username);

	User findById(String string);

	void addUser(User user);

	void updateUser(User user);

	void updatePassword(User user);

	Result findMe(User user);

}
