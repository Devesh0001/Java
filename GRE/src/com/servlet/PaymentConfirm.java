package com.servlet;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.DBConnection.MyConnection;

@WebServlet("/PaymentConfirm")
public class PaymentConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession hs = request.getSession();
		String cardnum=request.getParameter("ccnum");
		String balance="0";
		String month=request.getParameter("months");
		String year=request.getParameter("years");
		String validity=month+"/"+year;
		String pid=(String)hs.getAttribute("pid");
		String uid=(String)hs.getAttribute("uId");
		String amount=(String)hs.getAttribute("ef");
		
		StringBuilder stringBuildervarible = new StringBuilder();
        stringBuildervarible.append(uid);
        String GreID=new String(stringBuildervarible.reverse().append(pid));

		LocalDateTime myDateObj = LocalDateTime.now();
		DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		String formattedDate = myDateObj.format(myFormatObj);
		String q="insert into creditcarddetails values (?,?,?)";
		
		
		try {
			PreparedStatement p=new MyConnection().getConnection().prepareStatement(q);
			p.setString(1, cardnum);
			p.setString(2, validity);
			p.setString(3, balance);
			p.executeUpdate();
			
			
			String qu="select * from greinformation where UserID='"+uid+"'";
			PreparedStatement ps=new MyConnection().getConnection().prepareStatement(qu);
			ResultSet r=ps.executeQuery();
			if(r.next()) {

				String rcount=String.valueOf(r.getInt(5)+1);
				String query="update greinformation set Score='0',Scheduled='0' , GRERegistrationID='"+GreID+"',CategoryID='"+pid+"', RegistrationCount='"+rcount+"', TestTaken='0' where UserID='"+uid+"' ";
				PreparedStatement prep=new MyConnection().getConnection().prepareStatement(query);
				
				prep.executeUpdate();
				hs.setAttribute("ccnum", cardnum);
        		hs.setAttribute("amount", amount);
        		hs.setAttribute("paydatetime",formattedDate);
        		hs.setAttribute("examreg","Your GRERegistrationID is "+GreID);
        		RequestDispatcher rd = request.getRequestDispatcher("PaymentConfirm.jsp");
        		rd.forward(request, response);
				
			}
			else {
				String que="insert into greinformation values (?,?,?,?,?,?,?)";
				PreparedStatement pst=new MyConnection().getConnection().prepareStatement(que);
				pst.setString(1, uid);
				pst.setString(2,pid);
				pst.setString(3,GreID);
				pst.setString(4,"0");
				pst.setString(5,"1");
				pst.setString(6,"0");
				pst.setString(7,"0");
				pst.executeUpdate();
				
				hs.setAttribute("ccnum", cardnum);
        		hs.setAttribute("amount", amount);
        		hs.setAttribute("paydatetime",formattedDate);
        		hs.setAttribute("examreg","Your GRERegistrationID is "+GreID);
        		RequestDispatcher rd = request.getRequestDispatcher("PaymentConfirm.jsp");
        		rd.forward(request, response);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
}
