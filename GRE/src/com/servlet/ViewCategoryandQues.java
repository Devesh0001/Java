package com.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ViewCategoryandQues")
public class ViewCategoryandQues extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String catid=request.getParameter("CategoryId");
		HttpSession hs = request.getSession();
		hs.setAttribute("catId",catid);
		RequestDispatcher d = request.getRequestDispatcher("ViewQuestions.jsp");
		d.forward(request, response);
	}

	

}
