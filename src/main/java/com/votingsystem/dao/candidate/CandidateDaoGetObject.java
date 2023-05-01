package com.votingsystem.dao.candidate;

public class CandidateDaoGetObject {
	public static CandidateDao getInstance()
	{
		return new CandidateDaoImpl();
	}
}
