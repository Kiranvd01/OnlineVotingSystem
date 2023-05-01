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
import com.votingsystem.model.user.User;
@WebServlet("/InsertAdmin")
public class InsertAdmin extends HttpServlet {
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
		String name=request.getParameter("name");
		String address=request.getParameter("address");
		long contact=Long.parseLong(request.getParameter("contact"));
		int age=Integer.parseInt(request.getParameter("age"));
		long adhar=Long.parseLong(request.getParameter("adhar"));
		Admin admin=new Admin(id, name, contact, address,age, adhar);
		int i=dao.insertAdmin(admin);
		if(i>0)
		{
			response.sendRedirect("jsp/DisplayAllAdmin.jsp");
		}
		else {
			out.print("<h3>Error</h3>");
		}
	}

}
