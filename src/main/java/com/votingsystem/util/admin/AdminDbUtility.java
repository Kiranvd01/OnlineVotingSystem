package com.votingsystem.util.admin;

import java.sql.Connection;
import java.sql.DriverManager;

import org.apache.tomcat.dbcp.dbcp2.DriverManagerConnectionFactory;

public class AdminDbUtility {
	private static Connection con;
	public static  Connection getConnection()
	{
		
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinevotingsystem", "root", "root");
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return con;
	}
}
