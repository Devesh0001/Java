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

@WebServlet("/ViewResult")
public class ViewResult extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
    	String RegID = request.getParameter("regid");
         
         try {
        	 if(RegID!=null) {
        		 String qr="select * from greinformation where GRERegistrationID='"+RegID+"'";
            	 PreparedStatement ps =new MyConnection().getConnection().prepareStatement(qr);
            	 
            	 ResultSet rs=ps.executeQuery();
            	 
            	 if(rs.next()){
            		 
            		 String q1="select * from greinformation where GRERegistrationID='"+RegID+"' and TestTaken='1'";
                	 PreparedStatement p1=new MyConnection().getConnection().prepareStatement(q1);
                	 
                	 ResultSet r1=p1.executeQuery();
                	 if(r1.next()) {
                		 String papername=null;
                    	 String lname=null;
                		 String userId=rs.getString(1);
                		 String score=rs.getString(4);
                		 String catId=rs.getString(2);
                		 
                		 String query="select * from userdetails where UserID='"+userId+"'";
                		 String que="select * from categorydetails where CategoryID='"+catId+"'";
                		 PreparedStatement p =new MyConnection().getConnection().prepareStatement(que);
                		 PreparedStatement pst =new MyConnection().getConnection().prepareStatement(query);
                    	 ResultSet r=p.executeQuery();
                    	 ResultSet re=pst.executeQuery();
                    	 
                    	 if(re.next()) {
                    		 lname=re.getString(4);
                    	 }
                    	 if(r.next()) {
                    		 papername=r.getString("PaperName");
                    	 }
                    	 
                    	 
                    	 HttpSession hs = request.getSession();
                		 hs.setAttribute("cID",catId);
                		 hs.setAttribute("pname", papername);
                		 hs.setAttribute("uId", userId);
                		 hs.setAttribute("score",score);
                		 hs.setAttribute("lname",lname);
                		 RequestDispatcher rd = request.getRequestDispatcher("Result.jsp");
                		 rd.forward(request, response);
                	 }
                	 
                	 else {
                		 HttpSession hs = request.getSession();
                		 RequestDispatcher d = request.getRequestDispatcher("ViewResult.jsp");
                		 hs.setAttribute("vr", "Test not taken yet!!");
                		 d.forward(request, response);
                	 }
            		 
            	 }
            	 else{
            		 HttpSession hs = request.getSession();
            		 RequestDispatcher d = request.getRequestDispatcher("ViewResult.jsp");
            		 hs.setAttribute("vr", "GRE Registration ID Incorrect or Not registered for the test");
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
