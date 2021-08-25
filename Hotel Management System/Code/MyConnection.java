import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
public class MyConnection 
{
	Connection con=null;
	Statement st=null;
	public Connection getConnection()
	{
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hoteldb","root","");
			st=con.createStatement();
	    }
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return con;
	}
	
}
