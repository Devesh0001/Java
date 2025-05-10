package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBConnection.MyConnection;

@WebServlet("/ScheduleExam")
public class ScheduleExam extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
        try{
        	String greid= request.getParameter("Student Name");
        	String dateofexam=request.getParameter("doe")+" "+"00:00:00";
        	
        	SimpleDateFormat dF = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
        	java.util.Date tdate=new java.util.Date();
        	
        	java.util.Date doe=dF.parse(dateofexam);
        	java.util.Date tDate = dF.parse(dF.format(tdate));
        	
        	 long difference_In_Time = doe.getTime() - tDate.getTime();
        	 long difference_In_Days = (difference_In_Time / (1000 * 60 * 60 * 24)) % 365;
        	 if(difference_In_Days<=3) {
        		HttpSession session = request.getSession();
             	session.setAttribute("scheduleexam", "Schedule the test at least 3 days after today!!");
             	RequestDispatcher rd = request.getRequestDispatcher("ScheduleExam.jsp");
        		rd.forward(request, response);
        	 }
        	 else {
        		 String q="select * from greinformation where GRERegistrationID='"+greid+"'";
        		 PreparedStatement p=new MyConnection().getConnection().prepareStatement(q);
        		 ResultSet r=p.executeQuery();
        		 if(r.next()) {
        			 String query="insert into scheduledetails values (?,?,?)";
            		 PreparedStatement pre=new MyConnection().getConnection().prepareStatement(query);
            		 pre.setString(1, greid);
            		 pre.setString(2, r.getString(2));
            		 pre.setString(3, dateofexam.substring(0,10));
            		 pre.executeUpdate();
            		 
            		 String qu="update greinformation set Scheduled='1' where GRERegistrationID='"+greid+"'";
        			 PreparedStatement pr=new MyConnection().getConnection().prepareStatement(qu);
        			 pr.executeUpdate();
        			 
            		 HttpSession session = request.getSession();
            		 session.setAttribute("scheduleexam", "Exam Scheduled");
                  	 RequestDispatcher rd = request.getRequestDispatcher("ScheduleExam.jsp");
             		 rd.forward(request, response);
        		 }
        		 
        	 }
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
	}

	

}
