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
@WebServlet("/DisplayCandidate")
public class DisplayCandidate extends HttpServlet {
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
		Candidate candidate=dao.getCandidate(id);
		if(candidate.getName()!=null)
		{
			request.setAttribute("candidate", candidate);
			//System.out.println(candidate);
			request.getRequestDispatcher("jsp/DisplayCandidate.jsp").forward(request, response);
		}
		else {
			out.print("<h3>Error</h3>");
		}
	}

}
