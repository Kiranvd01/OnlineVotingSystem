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

@WebServlet("/DeleteCandidate")
public class DeleteCandidate extends HttpServlet {
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
		int i=dao.deleteCandidate(id);
		if(i>0)
		{
			response.sendRedirect("jsp/DisplayAllCandidate.jsp");
		}
		else {
			out.print("<h3>Error</h3>");
		}
	}

}
