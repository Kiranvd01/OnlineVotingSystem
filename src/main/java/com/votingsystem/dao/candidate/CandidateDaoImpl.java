package com.votingsystem.dao.candidate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.votingsystem.model.candidate.Candidate;
import com.votingsystem.util.user.UserDbUtility;

public class CandidateDaoImpl implements CandidateDao{

	@Override
	public int insertCandidate(Candidate candidate) {
		int i=0;
		try {
		Connection con=UserDbUtility.getConnection();
		PreparedStatement ps= con.prepareStatement("insert into candidate values(?,?,?,?,?,?)");
		ps.setInt(1, candidate.getId());
		ps.setString(2, candidate.getName());
		ps.setInt(5, candidate.getAge());
		ps.setString(3, candidate.getAddress());
		ps.setLong(6, candidate.getAdharNo());
		ps.setLong(4, candidate.getContact());
		i=ps.executeUpdate();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return i;
	}

	@Override
	public int deleteCandidate(int id) {
		Connection con=UserDbUtility.getConnection();
		int i=0;
		try {
		PreparedStatement ps= con.prepareStatement("delete from candidate where id=?");
		ps.setInt(1, id);
		i=ps.executeUpdate();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return i;
	}

	@Override
	public int updateCandidate(Candidate candidate) {
		int i=0;
		try {
		Connection con=UserDbUtility.getConnection();
		PreparedStatement ps= con.prepareStatement("update candidate set name=?,address=?,contact=?,age=?,adhar=? where id=?");
		ps.setInt(6, candidate.getId());
		ps.setString(1, candidate.getName());
		ps.setInt(4, candidate.getAge());
		ps.setString(2, candidate.getAddress());
		ps.setLong(5, candidate.getAdharNo());
		ps.setLong(3, candidate.getContact());
		i=ps.executeUpdate();
	
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return i;
	}

	@Override
	public Candidate getCandidate(int id) {
		Connection con=UserDbUtility.getConnection();
		Candidate candidate=new Candidate();
		try {
		PreparedStatement ps= con.prepareStatement("select * from candidate where id=?");
		ps.setInt(1, id);
		ResultSet rs= ps.executeQuery();
		while(rs.next())
		{
			candidate.setId(rs.getInt(1));
			candidate.setName(rs.getString(2));
			candidate.setAddress(rs.getString(3));
			candidate.setContact(rs.getLong(4));	
			candidate.setAge(rs.getInt(5));
			candidate.setAdharNo(rs.getLong(6));
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return candidate;
	}

	@Override
	public List<Candidate> getAllCandidate() {
		Connection con=UserDbUtility.getConnection();
		List<Candidate> list=new ArrayList<Candidate>();
		try {
		PreparedStatement ps= con.prepareStatement("select * from candidate");
		ResultSet rs=ps.executeQuery();
		while(rs.next())
		{
			Candidate candidate=new Candidate();
			candidate.setId(rs.getInt(1));
			candidate.setName(rs.getString(2));
			candidate.setAddress(rs.getString(3));
			candidate.setContact(rs.getLong(4));
			candidate.setAge(rs.getInt(5));
			candidate.setAdharNo(rs.getLong(6));
			list.add(candidate);
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

}
