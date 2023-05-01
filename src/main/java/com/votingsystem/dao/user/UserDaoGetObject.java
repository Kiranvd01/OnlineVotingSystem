package com.votingsystem.dao.user;

public class UserDaoGetObject {
	public static UserDao getInstance()
	{
		return new UserDaoImpl();
	}
}