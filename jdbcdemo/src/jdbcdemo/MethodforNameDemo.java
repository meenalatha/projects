package jdbcdemo;

import java.sql.DriverManager;
import java.sql.SQLException;


public class MethodforNameDemo {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException {
		
		Class.forName("Abc"); 				// call static block
		
		Class.forName("Abc").newInstance();	// call static and instance block
		
		Class.forName("com.mysql.jdbc.Driver");  // Call the static block of Driver class
		
//		DriverManager.registerDriver(new com.mysql.jdbc.Driver());
	}
}

class Abc{
	static {
		System.out.println("in static");		//static block
	}
	{
		System.out.println("in instance");		//instance block
	}
}

