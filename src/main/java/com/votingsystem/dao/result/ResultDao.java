package com.votingsystem.dao.result;

import java.util.List;

import com.votingsystem.model.result.Result;



public interface ResultDao {
	int insertResult(Result result);
	Result getResult(int id);
	int updateResult(Result result);
	List<Result> getAllResult();
}
