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

@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
    	String fname = request.getParameter("fname");
        String lname = request.getParameter("lname");
        String gender = request.getParameter("gender");
        String age = request.getParameter("age");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String pass = request.getParameter("pass");
        String userId=fname.substring(0,2)+lname.substring(0,2).toUpperCase()+phone.substring(0,3);
         try {
        	 if(fname!=null) {
        		 String qr="select * from userdetails where `First Name`='"+fname+"' and `Last Name`='"+lname+"' and PhoneNo='"+phone+"'and Address='"+address+"'";
            	 PreparedStatement ps =new MyConnection().getConnection().prepareStatement(qr);
            	 
            	 ResultSet rs=ps.executeQuery();
            	 if(rs.next()) {
            		 HttpSession hs = request.getSession();
            		 hs.setAttribute("success", "Account already exists!!! Please Login.");
            		 RequestDispatcher rd = request.getRequestDispatcher("Register.jsp");
            		 rd.forward(request, response);
            	 }
            	 else{
            		 
            		 String q="insert into userdetails values (?,?,?,?,?,?,?,?,?)";
            		 PreparedStatement p=new MyConnection().getConnection().prepareStatement(q);
            		 p.setNString(1, userId);
            		 p.setNString(2, pass);
            		 p.setNString(3, fname);
            		 p.setNString(4, lname);
            		 p.setNString(5, age);
            		 p.setNString(6, gender);
            		 p.setNString(7, address);
            		 p.setNString(8, phone);
            		 p.setInt(9, 0);
            		 
            		 p.executeUpdate();
            		 
            		 String query="insert into logincredentials values (?,?,?)";
            		 PreparedStatement pre=new MyConnection().getConnection().prepareStatement(query);
            		 pre.setString(1,"U");
            		 pre.setNString(2, userId);
            		 pre.setNString(3, pass);
            		 
            		 pre.executeUpdate();
            		 
            		 HttpSession hs = request.getSession();
            		 hs.setAttribute("success", "Registration Successfull!!! Your UserID:"+userId);
            		 RequestDispatcher d = request.getRequestDispatcher("Register.jsp");
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
