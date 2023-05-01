package com.votingsystem.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.votingsystem.dao.user.UserDao;
import com.votingsystem.dao.user.UserDaoGetObject;
@WebServlet("/DeleteUser")
public class DeleteUser extends HttpServlet {
	UserDao  dao;
	@Override
	public void init() throws ServletException {
		dao=UserDaoGetObject.getInstance();
	}
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		int i=dao.deleteUser(id);
		if(i>0)
		{
			response.sendRedirect("jsp/DisplyAllUser.jsp");
		}
		else {
			out.print("<h3>Id Not Fund</h3>");
		}
	}

}
