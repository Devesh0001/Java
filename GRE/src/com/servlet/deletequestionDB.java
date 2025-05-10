package com.servlet;

import java.io.IOException;
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

@WebServlet("/deletequestionDB")
public class deletequestionDB extends HttpServlet {
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
        	 String query="delete from questiondetails where QuestionNo='"+quesno+"'"; 
        	 PreparedStatement p =new MyConnection().getConnection().prepareStatement(query);
        	 p.executeUpdate();
        	 
        	 String qa="select * from categorydetails where CategoryID='"+catid+"'";
        	 PreparedStatement pa =new MyConnection().getConnection().prepareStatement(qa);
        	 ResultSet rs=pa.executeQuery();
        	 if(rs.next()){
        		 int num =Integer.valueOf(rs.getString(4));
        		 String qu="update categorydetails set NoOfQuestions='"+(num-1)+"' where CategoryId='"+catid+"'";
        		 PreparedStatement pu =new MyConnection().getConnection().prepareStatement(qu);
        		 pu.executeUpdate();
        	 }
        	 session.setAttribute("delcon", "Question Deleted!!!");
        	 RequestDispatcher d = request.getRequestDispatcher("DelQues.jsp");
        	 d.forward(request, response);
    
         }catch(Exception e) {
        	e.printStackTrace();
         }
	}

}
