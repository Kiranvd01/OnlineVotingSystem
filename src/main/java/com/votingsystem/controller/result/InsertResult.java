package com.votingsystem.controller.result;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.votingsystem.dao.result.ResultDao;
import com.votingsystem.dao.result.ResultDaoGetObject;
import com.votingsystem.model.result.Result;
@WebServlet("/InsertResult")
public class InsertResult extends HttpServlet {
	ResultDao dao;
	@Override
	public void init() throws ServletException {
		dao=ResultDaoGetObject.getInstance();
	}
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		int id=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		Result result=dao.getResult(id);
		int vote=1;
		Result result2=new Result(id, name, vote);
		if(result.getName()!=null)
		{
			Result result3=new Result(id,name,result.getVote()+1);
			int i=dao.updateResult(result3);
			response.sendRedirect("index.html");
		}
		else {
			dao.insertResult(result2);
			response.sendRedirect("index.html");
		}
	}

}
