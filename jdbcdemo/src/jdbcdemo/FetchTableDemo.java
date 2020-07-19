package jdbcdemo;

import java.sql.*;

public class FetchTableDemo {

	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytable","root","mysql15");
		Statement st = con.createStatement();
		ResultSet rs = st.executeQuery("SELECT * FROM mytable.employee");
		while(rs.next()) {
			String data = rs.getInt(1)+ " : " + rs.getString(2)+ " : " + rs.getString(3)+ " : " + rs.getInt(4);
			System.out.println(data);
		}
		st.close();
		con.close();
		
	}

}
