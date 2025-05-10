package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/questionportal")
public class questionportal extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String catId=request.getParameter("Category Id");
		HttpSession hs = request.getSession();
		hs.setAttribute("CategoryId", catId);
		RequestDispatcher d = request.getRequestDispatcher("addquestions.jsp");
		d.forward(request, response);
	}

	

}
