package com.votingsystem.dao.admin;

public class AdminDaoGetObject {
	public static AdminDao getInstance()
	{
		return new AdminDaoImpl();
	}
}
