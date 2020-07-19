package jdbcdemo;

import java.sql.*;

public class DeleteDataDemo {

	public static void main(String[] args) throws Exception{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytable","root","mysql15");
		Statement st = con.createStatement();
		int count = st.executeUpdate("DELETE FROM mytable.employee WHERE id = 130");
		System.out.println(count + " row is deleted");
		st.close();
		con.close();
	}

}
