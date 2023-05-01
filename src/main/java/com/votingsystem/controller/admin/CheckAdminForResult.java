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
import com.votingsystem.model.admin.Admin;
@WebServlet("/CheckAdminForResult")
public class CheckAdminForResult extends HttpServlet {
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
		Admin admin=dao.getAdmin(id);
		if(admin.getName()!=null)
		{
			response.sendRedirect("jsp/DisplayResult.jsp");
		}
		else {
			out.print("<h3>ID NOT FOUND</h3>");
			request.getRequestDispatcher("CheckAdminForResult.html").include(request, response);
		}
	}

}
