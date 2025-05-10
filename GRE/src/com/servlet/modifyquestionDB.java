package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBConnection.MyConnection;

@WebServlet("/modifyquestionDB")
public class modifyquestionDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		HttpSession session = request.getSession();
		String quesno=(String)session.getAttribute("quesno");
		
		String catid= request.getParameter("catid");
        String question = request.getParameter("question");
        String ans1 = request.getParameter("ans1");
        String ans2 = request.getParameter("ans2");
        String ans3 = request.getParameter("ans3");
        String ans4 = request.getParameter("ans4");
        String answer = request.getParameter("answer");
        
         try {
        	 String query="update questiondetails set QuestionDescription='"+question+"', Choice1='"+ans1+"', Choice2='"+ans2+"'"
        	 		+ ", Choice3='"+ans3+"', Choice4='"+ans4+"', Answer='"+answer+"' where QuestionNo='"+quesno+"'"; 
        	 PreparedStatement p =new MyConnection().getConnection().prepareStatement(query);
        	 p.executeUpdate();
        	 session.setAttribute("modcon", "Question Modified");
        	 RequestDispatcher d = request.getRequestDispatcher("ModifyQues.jsp");
        	 d.forward(request, response);
    
         }catch(Exception e) {
        	e.printStackTrace();
         }
	}

}
