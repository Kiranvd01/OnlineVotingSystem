package com.votingsystem.dao.candidate;

import java.util.List;

import com.votingsystem.model.candidate.Candidate;

public interface CandidateDao {
	int insertCandidate(Candidate candidate);
	int deleteCandidate(int id);
	int updateCandidate(Candidate candidate);
	Candidate getCandidate(int id);
	List<Candidate> getAllCandidate();
}
