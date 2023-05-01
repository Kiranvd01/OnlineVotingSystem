package com.votingsystem.controller.candidate;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.votingsystem.dao.candidate.CandidateDao;
import com.votingsystem.dao.candidate.CandidateDaoGetObject;
import com.votingsystem.model.candidate.Candidate;
import com.votingsystem.model.user.User;

@WebServlet("/UpdateCandidate")
public class UpdateCandidate extends HttpServlet {
	CandidateDao dao;
	@Override
	public void init() throws ServletException {
		dao=CandidateDaoGetObject.getInstance();
	}
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		long contact=Long.parseLong(request.getParameter("contact"));
		int age=Integer.parseInt(request.getParameter("age"));
		long adhar=Long.parseLong(request.getParameter("adhar"));
		Candidate candidate=new Candidate(id, name, address,age, contact,adhar);
		int i=dao.updateCandidate(candidate);
		if(i>0)
		{
			response.sendRedirect("jsp/DisplayAllCandidate.jsp");
		}
		else {
			out.print("<h3>Error</h3>");
		}
	}
}
