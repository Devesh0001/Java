package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBConnection.MyConnection;

@WebServlet("/Logout")
public class Logout extends HttpServlet {


	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	 HttpSession hss = request.getSession();
    	 String uid=(String)hss.getAttribute("uId");
    	 String query="select * from userdetails where UserID='"+uid+"'";
    	 try {
			PreparedStatement ps=new MyConnection().getConnection().prepareStatement(query);
			ResultSet r=ps.executeQuery();
			if(r.next()) {
				String q="update userdetails set LoginStatus='0' where UserID='"+uid+"'";
				PreparedStatement p=new MyConnection().getConnection().prepareStatement(q);
				p.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 HttpSession hs = request.getSession(false);
         hs.removeAttribute("adminmsg");
         hs.removeAttribute("cpadmin");
         hs.removeAttribute("cpuser");
         hs.removeAttribute("con");
         hs.removeAttribute("examreg");
         hs.removeAttribute("loginU");
         hs.removeAttribute("success");
         hs.removeAttribute("cID");
         hs.removeAttribute("pname");
         hs.removeAttribute("name");
         hs.removeAttribute("lname");
         hs.removeAttribute("uId");
         hs.removeAttribute("score");
         hs.removeAttribute("vr");
         hs.removeAttribute("quescon");
         hs.removeAttribute("selectedexam");
         hs.removeAttribute("catId");
         hs.removeAttribute("delcon");
         hs.removeAttribute("uid");
         hs.removeAttribute("pid");
         hs.removeAttribute("p");
         hs.removeAttribute("noq");
         hs.removeAttribute("ed");
         hs.removeAttribute("ef");
         hs.removeAttribute("modcon");
         hs.removeAttribute("ccnum");
         hs.removeAttribute("amount");
         hs.removeAttribute("paydatetime");
         hs.removeAttribute("CategoryId");
         hs.removeAttribute("scheduleexam");
         hs.removeAttribute("quesno");
         hs.removeAttribute("Quesdesc");
         hs.removeAttribute("ans1");
         hs.removeAttribute("ans2");
         hs.removeAttribute("ans3");
         hs.removeAttribute("ans4");
         hs.removeAttribute("answer");
         hs.removeAttribute("pname");
         hs.invalidate();
         response.sendRedirect("Index.html");
    }
}