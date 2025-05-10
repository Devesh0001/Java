package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
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

@WebServlet("/Adminlogin")
public class Adminlogin extends HttpServlet {      

	private static final long serialVersionUID = 1L;

	@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
    	String userID = request.getParameter("userid");
        String pass = request.getParameter("pass");
         
         try {
        	 if(userID!=null) {
        		 String qr="select * from logincredentials where UserType='A' and UserID='"+userID+"' and Password='"+pass+"'";
            	 PreparedStatement ps =new MyConnection().getConnection().prepareStatement(qr);
            	 
            	 ResultSet rs=ps.executeQuery();
            	 
            	 if(rs.next()){
            		 RequestDispatcher rd = request.getRequestDispatcher("AdminHome.jsp");
            		 rd.forward(request, response);
            	 }
            	 else{
            		 HttpSession hs = request.getSession();
            		 RequestDispatcher d = request.getRequestDispatcher("Adminlogin.jsp");
            		 hs.setAttribute("adminmsg", "User Credentials Incorrect");
            		 d.forward(request, response);
            	 }
            	 rs.close();
        		 ps.close();
        	 }
        	 
         }catch(Exception e) {
        	e.printStackTrace();
         }
    }
    

}