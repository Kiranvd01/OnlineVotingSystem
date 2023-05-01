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
import com.votingsystem.model.user.User;
@WebServlet("/UpdateUser")
public class UpdateUser extends HttpServlet {
	UserDao dao;
	@Override
	public void init() throws ServletException {
		dao=UserDaoGetObject.getInstance();
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
		User user=new User(id, name, address, contact, age, adhar);
		int i=dao.updateUser(user);
		if(i>0)
		{
			response.sendRedirect("jsp/DisplyAllUser.jsp");
		}
		else {
			out.print("<h3>Error</h3>");
		}
	}

}
