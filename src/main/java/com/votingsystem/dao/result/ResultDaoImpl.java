package com.votingsystem.dao.result;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.votingsystem.model.result.Result;
import com.votingsystem.util.result.ResultDbUtility;

public class ResultDaoImpl implements ResultDao{

	@Override
	public int insertResult(Result result) {
		Connection con=ResultDbUtility.getConnection();
		int i=0;
		try {
		PreparedStatement ps= con.prepareStatement("insert into result values(?,?,?)");
		ps.setInt(1, result.getId());
		ps.setString(2, result.getName());
		ps.setInt(3, result.getVote());
		i=ps.executeUpdate();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return i;
	}

	@Override
	public Result getResult(int id) {
		Connection con=ResultDbUtility.getConnection();
		Result result=new Result();
		try {
		PreparedStatement ps= con.prepareStatement("select * from result where id=?");
		ps.setInt(1, id);
		ResultSet rs= ps.executeQuery();
		while(rs.next())
		{
			result.setId(rs.getInt(1));
			result.setName(rs.getString(2));
			result.setVote(rs.getInt(3));
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return result;
	}

	@Override
	public List<Result> getAllResult() {
		List<Result> list=new ArrayList<Result>();
		Connection con=ResultDbUtility.getConnection();
		try {
		PreparedStatement ps= con.prepareStatement("select * from result");
		ResultSet rs= ps.executeQuery();
		while(rs.next())
		{
			Result result=new Result();
			result.setId(rs.getInt(1));
			result.setName(rs.getString(2));
			result.setVote(rs.getInt(3));
			list.add(result);
		}
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return list;
	}

	@Override
	public int updateResult(Result result) {
		Connection con=ResultDbUtility.getConnection();
		int i=0;
		try {
		PreparedStatement ps= con.prepareStatement("update result set name=?,vote=? where id=?");
		ps.setString(1,result.getName() );
		ps.setInt(2, result.getVote());
		ps.setInt(3, result.getId());
		i=ps.executeUpdate();
		}catch(Exception e)
		{
			System.out.println(e);
		}
		return i;
	}

	
	

}
