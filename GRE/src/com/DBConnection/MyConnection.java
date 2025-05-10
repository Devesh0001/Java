package com.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
	Connection con;
	
	public Connection getConnection()
	{
		try
		{
			if(con==null) {
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3307/gre_online_test","root","");
			}
			
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
}
