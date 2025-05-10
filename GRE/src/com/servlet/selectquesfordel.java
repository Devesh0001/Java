package com.servlet;

import java.io.IOException;
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

/**
 * Servlet implementation class selectquesfordel
 */
@WebServlet("/selectquesfordel")
public class selectquesfordel extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String selectedques=request.getParameter("QuesName");
		String query="select * from questiondetails where QuestionDescription='"+selectedques+"'";
		try {
			PreparedStatement p=new MyConnection().getConnection().prepareStatement(query);
			ResultSet r=p.executeQuery();
			if(r.next()) {
				String ans1=r.getString(4);
				String ans2=r.getString(5);
				String ans3=r.getString(6);
				String ans4=r.getString(7);
				String answer=r.getString(8);
				HttpSession session = request.getSession();
				session.setAttribute("quesno", r.getString(2));
				request.setAttribute("Quesdesc",selectedques);
				request.setAttribute("ans1",ans1);
				request.setAttribute("ans2",ans2);
				request.setAttribute("ans3",ans3);
				request.setAttribute("ans4",ans4);
				request.setAttribute("answer",answer);
             	RequestDispatcher rd = request.getRequestDispatcher("DeleteQuestion.jsp");
        		rd.forward(request, response);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
