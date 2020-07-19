package jdbcdemo;

import java.sql.*;

public class FetchDataDemo {

	public static void main(String[] args) throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytable","root","mysql15");
		Statement st = con.createStatement();	
		ResultSet rs = st.executeQuery("SELECT name,designation FROM mytable.employee WHERE id = 124;");
		rs.next();
		String name = rs.getString(1)+ " : " + rs.getString(2);
		System.out.println(name);
		st.close();
		con.close();
	}
}
