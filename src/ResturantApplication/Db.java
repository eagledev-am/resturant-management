package ResturantApplication;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {

	private static String url = "jdbc:mysql://localhost/resturant";
	private static String userName ="root";
	private static String password ="";
	
	public static Connection connect() throws SQLException {
		return DriverManager.getConnection(url ,userName , password);
	}

}
