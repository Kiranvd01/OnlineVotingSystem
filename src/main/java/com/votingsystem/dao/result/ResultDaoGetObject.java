package com.votingsystem.dao.result;

public class ResultDaoGetObject {
	public static ResultDao getInstance()
	{
		return new ResultDaoImpl();
	}
}
