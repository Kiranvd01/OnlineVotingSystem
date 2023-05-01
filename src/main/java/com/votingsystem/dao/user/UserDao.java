package com.votingsystem.dao.user;

import java.util.List;

import com.votingsystem.model.user.User;

public interface UserDao {
	int insertUser(User user);
	int deleteUser(int id);
	int updateUser(User user);
	User getUser(int id);
	List<User> getAllUser();
}
