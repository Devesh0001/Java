package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBConnection.MyConnection;


@WebServlet("/Confirmation")
public class Confirmation extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
    	String RegID = request.getParameter("regid");
        
         try {
        	 if(RegID!=null) {
        		 String qr="select * from greinformation where GRERegistrationID='"+RegID+"'";
        		 String q="select * from scheduledetails where ExamID='"+RegID+"'";
            	 PreparedStatement ps =new MyConnection().getConnection().prepareStatement(qr);
            	 PreparedStatement p =new MyConnection().getConnection().prepareStatement(q);
            	 
            	 ResultSet rs=ps.executeQuery();
            	 ResultSet r=p.executeQuery();
            	 
            	 if(rs.next()) {
            		 if(rs.getInt(6)==1) {
            			 HttpSession hs = request.getSession();
            			 hs.setAttribute("con", "Already took the test!!!");
            			 RequestDispatcher rd = request.getRequestDispatcher("Confirmation.jsp");
                		 rd.forward(request, response);
            		 }
            		 else {
            			 if(r.next()){
                			 
                			 DateFormat dF = new SimpleDateFormat("yyyy-MM-dd");
            	    		 String examdate=r.getString(3).substring(0,10);
            	    		 
                    		 java.util.Date da=new java.util.Date();
                    		 java.sql.Date todaysdate=new java.sql.Date(da.getTime());
                    		 String tDate = dF.format(todaysdate);
                    		 
                    		 String catid=r.getString(2);
                    		 String query="select * from categorydetails where CategoryID='"+catid+"'";
                    		 PreparedStatement pre=new MyConnection().getConnection().prepareStatement(query);
                    		 ResultSet res=pre.executeQuery();
                    		 
                    		 if(tDate.equals(examdate) && res.next()) {
                    			 String selectedexam=res.getString(3);
                    			 String catId=rs.getString(2);
                    			 HttpSession hs = request.getSession();
                        		 hs.setAttribute("selectedexam",selectedexam);
                        		 hs.setAttribute("catId",catId);
                        		 String qe="update greinformation set TestTaken='"+1+"' where GRERegistrationID='"+RegID+"'";
                        		 PreparedStatement pe=new MyConnection().getConnection().prepareStatement(qe);
                        		 pe.executeUpdate();
                    			 RequestDispatcher rd = request.getRequestDispatcher("Exam.jsp");
                        		 rd.forward(request, response);
                    		 }
                    		 else {
                    			 HttpSession hs = request.getSession();
                        		 RequestDispatcher d = request.getRequestDispatcher("Confirmation.jsp");
                        		 hs.setAttribute("con", "Exam is Scheduled on "+examdate);
                        		 d.forward(request, response);
                    		 }
                    	 }
                    	 else{
                    		 HttpSession hs = request.getSession();
                    		 RequestDispatcher d = request.getRequestDispatcher("Confirmation.jsp");
                    		 hs.setAttribute("con", "Exam is not Scheduled yet. Please check it after some time!!!");
                    		 d.forward(request, response);
                    	 }
            		 }
            		 
            	 }
            	 else {
            		 HttpSession hs = request.getSession();
            		 RequestDispatcher d = request.getRequestDispatcher("Confirmation.jsp");
            		 hs.setAttribute("con", "GRE Registration ID Incorrect or Not Registered for exam");
            		 d.forward(request, response);
            	 }
            	 rs.close();
        		 ps.close();
        		 r.close();
        		 p.close();
        	 }
        	 
         }catch(Exception e) {
        	e.printStackTrace();
         }
	}

}
