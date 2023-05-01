package com.votingsystem.dao.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.votingsystem.model.user.User;
import com.votingsystem.util.user.UserDbUtility;

public class UserDaoImpl implements UserDao{

	@Override
	public int insertUser(User user) {
		int i=0;
		try {
		Connection con=UserDbUtility.getConnection();
		PreparedStatement ps= con.prepareStatement("insert into user values(?,?,?,?,?,?)");
		ps.setInt(1, user.getId());
		ps.setString(2, user.getName());
		ps.setInt(5, user.getAge());
		ps.setString(3, user.getAddress());
		ps.setLong(6, user.getAdharNo());
		ps.setLong(4, user.getContact());
		i=ps.executeUpdate();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return i;
	}

	@Override
	public int deleteUser(int id) {
		Connection con=UserDbUtility.getConnection();
		int i=0;
		try {
		PreparedStatement ps= con.prepareStatement("delete from user where id=?");
		ps.setInt(1, id);
		i=ps.executeUpdate();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return i;
	}

	@Override
	public int updateUser(User user) {
		int i=0;
		try {
		Connection con=UserDbUtility.getConnection();
		PreparedStatement ps= con.prepareStatement("update user set name=?,address=?,contact=?,age=?,adhar=? where id=?");
		ps.setInt(6, user.getId());
		ps.setString(1, user.getName());
		ps.setInt(4, user.getAge());
		ps.setString(2, user.getAddress());
		ps.setLong(5, user.getAdharNo());
		ps.setLong(3, user.getContact());
		i=ps.executeUpdate();
	
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return i;
	}

	@Override
	public User getUser(int id) {
		Connection con=UserDbUtility.getConnection();
		User user=new User();
		try {
		PreparedStatement ps= con.prepareStatement("select * from user where id=?");
		ps.setInt(1, id);
		ResultSet rs= ps.executeQuery();
		while(rs.next())
		{
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setAddress(rs.getString(3));
			user.setContact(rs.getLong(4));
			user.setAge(rs.getInt(5));
			user.setAdharNo(rs.getLong(6));
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return user;
	}

	@Override
	public List<User> getAllUser() {
		Connection con=UserDbUtility.getConnection();
		List<User> list=new ArrayList<User>();
		try {
		PreparedStatement ps= con.prepareStatement("select * from user");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			User user=new User();
			user.setId(rs.getInt(1));
			user.setName(rs.getString(2));
			user.setAddress(rs.getString(3));
			user.setContact(rs.getLong(4));
			user.setAge(rs.getInt(5));
			user.setAdharNo(rs.getLong(6));
			list.add(user);
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}
	
}
