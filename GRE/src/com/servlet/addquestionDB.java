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


@WebServlet("/addquestionDB")
public class addquestionDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String catid= request.getParameter("catid");
        String question = request.getParameter("question");
        String ans1 = request.getParameter("ans1");
        String ans2 = request.getParameter("ans2");
        String ans3 = request.getParameter("ans3");
        String ans4 = request.getParameter("ans4");
        String answer = request.getParameter("answer");
        
         try {
        	 String query="select * from questiondetails where QuestionDescription='"+question+"'"; // Query To check that question is already exist or not
        	 PreparedStatement p =new MyConnection().getConnection().prepareStatement(query);
        	 ResultSet r=p.executeQuery();
        	 if(r.next()){
        		 HttpSession hs = request.getSession();
        		 hs.setAttribute("quescon", "Question Already Exist");
        		 RequestDispatcher d = request.getRequestDispatcher("addquestions.jsp");
        		 d.forward(request, response);
        	 }
        	 else{
        	 if(question!=null) {
        		 String qr="insert into questiondetails (CategoryID, QuestionDescription, Choice1, Choice2, Choice3, Choice4, Answer)"+" values (?,?,?,?,?,?,?)";
            	 PreparedStatement ps =new MyConnection().getConnection().prepareStatement(qr);
            	 ps.setString(1,catid);
            	 ps.setString(2,question );
            	 ps.setString(3,ans1 );
            	 ps.setString(4,ans2 );
            	 ps.setString(5,ans3 );
            	 ps.setString(6,ans4 );
            	 ps.setString(7,answer );
            	 ps.executeUpdate();
            	 String qa="select * from categorydetails where CategoryID='"+catid+"'";
            	 PreparedStatement pa =new MyConnection().getConnection().prepareStatement(qa);
            	 ResultSet rs=pa.executeQuery();
            	 if(rs.next()){
            		 int num =Integer.valueOf(rs.getString(4));
            		 String qu="update categorydetails set NoOfQuestions='"+(num+1)+"' where CategoryId='"+catid+"'";
            		 PreparedStatement pu =new MyConnection().getConnection().prepareStatement(qu);
            		 pu.executeUpdate();
            	 }
            	 
            	 HttpSession hs = request.getSession();
        		 hs.setAttribute("quescon", "Question Added Sucessfully");
        		 RequestDispatcher d = request.getRequestDispatcher("addquestions.jsp");
        		 d.forward(request, response);
            	 
        	 }
        	 }
         }catch(Exception e) {
        	e.printStackTrace();
         }
	}

}
