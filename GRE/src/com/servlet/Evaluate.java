package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBConnection.MyConnection;

@WebServlet("/Evaluate")
public class Evaluate extends HttpServlet {

	private static final long serialVersionUID = 1L;

protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		
        try(PrintWriter out = response.getWriter()){
        	
        	Enumeration retrieve = request.getParameterNames();
        	HttpSession session = request.getSession(false);
        	String catID=(String)session.getAttribute("catId");
        	String uID=(String)session.getAttribute("uId");
        	int marks=0;
        	
          	while(retrieve.hasMoreElements()){
                String var = (String)retrieve.nextElement();
                String qr="select * from questiondetails where CategoryID='"+catID+"' and QuestionNo='"+var+"'";
              	PreparedStatement ps =new MyConnection().getConnection().prepareStatement(qr);
                ResultSet res = ps.executeQuery();
               
                String [] useranswers = request.getParameterValues(var);
                
                for(String i:useranswers){
                       while (res.next())
                         { 
                           String rightans = res.getString("Answer");
                           if(i.equals(rightans)){
                        	   marks++;
                         }
                       
                       }
                    }
               	}
          	
        	String query="update greinformation set Score='"+marks+"' where UserID='"+uID+"'";
        	PreparedStatement ps =new MyConnection().getConnection().prepareStatement(query);
        	ps.executeUpdate();
        	
        	out.println("<h1 style=\"text-align:center;\">The Examination Has Ended</h1>");
            out.println("<h4 style=\"text-align:center;\">Please Click on the 'Return Home' Button below to go back to home</h4>");
            out.println(" <center><form action=\"UserHome.jsp\">\n" +
            		"            \n" +
            		"            <input type=\"submit\" value=\"Home\">\n" +
            		"        </form>\n" +
            		"    </center>");
        	
        }catch(Exception e) {
        	e.printStackTrace();
        }
         
	}
}
