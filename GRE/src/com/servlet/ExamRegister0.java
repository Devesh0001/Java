package com.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBConnection.MyConnection;

@WebServlet("/ExamRegister0")
public class ExamRegister0 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String catId=request.getParameter("Category Id");
		String uid=request.getParameter("uid");
		
		String q="select * from categorydetails where CategoryID='"+catId+"'";
		String qu="select * from greinformation where UserID='"+uid+"' and TestTaken='0'";
		String query="select * from greinformation where UserID='"+uid+"'";
		try {
			PreparedStatement pu=new MyConnection().getConnection().prepareStatement(qu);
			ResultSet rs=pu.executeQuery();
			if(rs.next()) {
				HttpSession hs = request.getSession();
	        	hs.setAttribute("examreg","Already Registered!!Please take that test first.");
	        	RequestDispatcher rd = request.getRequestDispatcher("ExamRegister0.jsp");
	        	rd.forward(request, response);		
			}
			else {
				PreparedStatement pr=new MyConnection().getConnection().prepareStatement(query);
				ResultSet re=pr.executeQuery();
				if(re.next() && re.getInt(5)==5) {
						HttpSession hs = request.getSession();
			        	hs.setAttribute("examreg","You have already registered 5 times. Try next year!!!");
			        	RequestDispatcher rd = request.getRequestDispatcher("ExamRegister0.jsp");
			        	rd.forward(request, response);
				}
				else {
					PreparedStatement p=new MyConnection().getConnection().prepareStatement(q);
					ResultSet r=p.executeQuery();
					if(r.next()) {
						HttpSession hs = request.getSession();
						hs.setAttribute("uid", uid);
						hs.setAttribute("pid",catId);
				        hs.setAttribute("p",r.getString(3));
				        hs.setAttribute("noq", r.getString(4)+"ques");
				        hs.setAttribute("ed", r.getString(5).substring(0,2)+"hour");
				        hs.setAttribute("ef",r.getString(6));
				        RequestDispatcher rd = request.getRequestDispatcher("ExamRegister.jsp");
				        rd.forward(request, response);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
