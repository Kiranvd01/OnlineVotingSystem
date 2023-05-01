package com.votingsystem.dao.admin;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.votingsystem.model.admin.Admin;
import com.votingsystem.model.candidate.Candidate;
import com.votingsystem.util.admin.AdminDbUtility;
import com.votingsystem.util.user.UserDbUtility;

public class AdminDaoImpl implements AdminDao{

	@Override
	public int insertAdmin(Admin admin) {
		int i=0;
		try {
		Connection con=UserDbUtility.getConnection();
		PreparedStatement ps= con.prepareStatement("insert into admin values(?,?,?,?,?,?)");
		ps.setInt(1, admin.getId());
		ps.setString(2, admin.getName());
		ps.setInt(5, admin.getAge());
		ps.setString(3, admin.getAddress());
		ps.setLong(6, admin.getAdhar());
		ps.setLong(4, admin.getContact());
		i=ps.executeUpdate();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return i;
	}

	@Override
	public int deleteAdmin(int id) {
		Connection con=UserDbUtility.getConnection();
		int i=0;
		try {
		PreparedStatement ps= con.prepareStatement("delete from admin where id=?");
		ps.setInt(1, id);
		i=ps.executeUpdate();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return i;
	}

	@Override
	public int updateAdmin(Admin admin) {
		int i=0;
		try {
		Connection con=UserDbUtility.getConnection();
		PreparedStatement ps= con.prepareStatement("update admin set name=?,address=?,contact=?,age=?,adhar=? where id=?");
		ps.setInt(6, admin.getId());
		ps.setString(1, admin.getName());
		ps.setInt(4, admin.getAge());
		ps.setString(2, admin.getAddress());
		ps.setLong(5, admin.getAdhar());
		ps.setLong(3, admin.getContact());
		i=ps.executeUpdate();
	
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return i;
	}

	@Override
	public Admin getAdmin(int id) {
		Connection con;
		int i=0;
		ResultSet rs=null;
		con=AdminDbUtility.getConnection();
		Admin admin=new Admin();
		try {
		PreparedStatement ps= con.prepareStatement("select * from admin where id=?");
		ps.setInt(1, id);
		rs=  ps.executeQuery();
		while(rs.next())
		{
		admin.setId(rs.getInt(1));
		admin.setName(rs.getString(2));
		admin.setAddress(rs.getString(3));
		admin.setAge(rs.getInt(4));
		admin.setContact(rs.getInt(5));
		admin.setAdhar(rs.getInt(6));
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return admin;
	}

	@Override
	public List<Admin> getAllAdmin() {
		Connection con=UserDbUtility.getConnection();
		List<Admin> list=new ArrayList<Admin>();
		try {
		PreparedStatement ps= con.prepareStatement("select * from admin");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Admin admin=new Admin();
			admin.setId(rs.getInt(1));
			admin.setName(rs.getString(2));
			admin.setAddress(rs.getString(3));
			admin.setContact(rs.getLong(4));
			admin.setAge(rs.getInt(5));
			admin.setAdhar(rs.getLong(6));
			list.add(admin);
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

}
