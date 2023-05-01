package com.votingsystem.controller.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.votingsystem.dao.user.UserDao;
import com.votingsystem.dao.user.UserDaoGetObject;
import com.votingsystem.model.user.User;
@WebServlet("/DisplayUser")
public class DisplayUser extends HttpServlet {
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
		User user=dao.getUser(id);
		if(user.getName()!=null)
		{
			request.setAttribute("user", user);
			request.getRequestDispatcher("jsp/DisplayUser.jsp").forward(request, response);
		}
		else {
			out.print("<h3>Error</h3>");
		}
	}

}
