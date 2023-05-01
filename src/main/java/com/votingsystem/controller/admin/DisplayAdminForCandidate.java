package com.votingsystem.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.votingsystem.dao.admin.AdminDao;
import com.votingsystem.dao.admin.AdminDaoGetObject;
import com.votingsystem.dao.candidate.CandidateDao;
import com.votingsystem.dao.candidate.CandidateDaoGetObject;
import com.votingsystem.model.admin.Admin;
import com.votingsystem.model.candidate.Candidate;
import com.votingsystem.util.admin.AdminDbUtility;

@WebServlet("/DisplayAdminForCandidate")
public class DisplayAdminForCandidate extends HttpServlet {
	AdminDao dao;
	@Override
	public void init() throws ServletException {
		dao=AdminDaoGetObject.getInstance();
	}
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		Admin candidate=dao.getAdmin(id);
		//out.print(id+" "+candidate);
		if(candidate.getName()!=null)
		{
			response.sendRedirect("jsp/DisplayAllCandidate.jsp");
		}
		else {
			out.print("<h3>ID NOT FOUND</h3>");
			request.getRequestDispatcher("CheckAdminForCandidate.html").include(request, response);
		}
	}

}
