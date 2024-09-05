package hrms.dbinfo;
import java.sql.*;

public class DbConnection {

	private static Connection con;
	
	public static Connection openConnection()
	{
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");//Factory method-> create the object of a class
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrms_db","root","root");
			
		}
		//jbbc:mysql:->sub protocol
        //localhost->name or IP address of the machine where database is being installed
		//3306->portno-logical number where database will be listen
		//hrms_db->database name
		//root->database user name
		//root->database user password
		
		catch(SQLException|ClassNotFoundException cse) {
			cse.printStackTrace();
		}
		
		return con;
	}
	
//	public static void main(String[] args) {
//		Connection con=openConnection();
//		System.out.println(con);
//	}
}
