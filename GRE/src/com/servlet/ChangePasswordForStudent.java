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

@WebServlet("/ChangePasswordForStudent")
public class ChangePasswordForStudent extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
    	String userID = request.getParameter("userid");
        String oldpass = request.getParameter("opass");
        String newp = request.getParameter("npass");
        String confirmp = request.getParameter("cpass");
        
         try {
        	 if(userID!=null) {
        		
        		 String qr="select * from logincredentials where UserType='U' and UserID='"+userID+"' and Password='"+oldpass+"'";
            	 PreparedStatement ps =new MyConnection().getConnection().prepareStatement(qr);
            	 
            	 ResultSet rs=ps.executeQuery();
            	 if(oldpass.equals(newp)) {
            		 HttpSession hs = request.getSession();
            		 RequestDispatcher d = request.getRequestDispatcher("ChangePasswordU.jsp");
            		 hs.setAttribute("cpuser", "New password cannot be the same as old password");
            		 d.forward(request, response);
            	 }
            	 else if(newp.equals(confirmp) && rs.next()){
            		 String q="update userdetails set Password='"+newp+"' where UserID='"+userID+"' and Password='"+oldpass+"'";
            		 String qu="update logincredentials set Password='"+newp+"' where UserType='U' and UserID='"+userID+"' and Password='"+oldpass+"'";
            		 
            		 PreparedStatement pr=new MyConnection().getConnection().prepareStatement(q);
            		 PreparedStatement pre=new MyConnection().getConnection().prepareStatement(qu);
                	 
            		 pre.executeUpdate();
                	 pr.executeUpdate();
                	 
                	 HttpSession hs = request.getSession();
            		 RequestDispatcher rd = request.getRequestDispatcher("ChangePasswordU.jsp");
            		 hs.setAttribute("cpuser", "Password Changed Successfully");
            		 rd.forward(request, response);
            		 
            		 pr.close();
            		 pre.close();
            		 
            	 }
            	 else if(newp.equals(confirmp)==false && rs.next()){
            		 HttpSession hs = request.getSession();
            		 RequestDispatcher d = request.getRequestDispatcher("ChangePasswordU.jsp");
            		 hs.setAttribute("cpuser", "New and Confirm Passwords does not Match");
            		 d.forward(request, response);
            	 }
            	 else {
            		 HttpSession hs = request.getSession();
            		 RequestDispatcher d = request.getRequestDispatcher("ChangePasswordU.jsp");
            		 hs.setAttribute("cpuser", "Either UserID is wrong or Old Password is wrong");
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
