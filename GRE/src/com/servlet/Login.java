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

@WebServlet("/Login")
public class Login extends HttpServlet {      

	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
    	String userID = request.getParameter("userid");
        String pass = request.getParameter("pass");
       
         try {
        	 if(userID!=null) {
        		 String qr="select * from logincredentials where UserType='U' and UserID='"+userID+"' and Password='"+pass+"'";
            	 PreparedStatement ps =new MyConnection().getConnection().prepareStatement(qr);
            	 
            	 ResultSet rs=ps.executeQuery();
            	 
            	 if(rs.next()){
            		 String q="select * from userdetails where UserID='"+userID+"' and Password='"+pass+"'";
                	 PreparedStatement p=new MyConnection().getConnection().prepareStatement(q);
                	 ResultSet r=p.executeQuery();
            		 HttpSession hs = request.getSession();
            		 hs.setAttribute("uId", userID);
            		 if(r.next()) {
            			 hs.setAttribute("name", r.getString("First Name"));
            		 }
            		 String query="update userdetails set loginstatus='"+1+"' where UserID='"+userID+"' and Password='"+pass+"'";
            		 
            		 PreparedStatement pr=new MyConnection().getConnection().prepareStatement(query);
                	 pr.executeUpdate();
                	 
            		 RequestDispatcher rd = request.getRequestDispatcher("UserHome.jsp");
            		 rd.forward(request, response);
            		 
            		 r.close();
            		 p.close();
            		 pr.close();
            	 }
            	 else{
            		 HttpSession hs = request.getSession();
            		 hs.setAttribute("loginU", "User Credentials Incorrect");
            		 RequestDispatcher d = request.getRequestDispatcher("Login.jsp");
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