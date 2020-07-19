package jdbcdemo;

import java.sql.*;

public class InsertPreparedDemo {

	public static void main(String[] args) throws Exception {
		int id = 132;
		String name = "Harini";
		String designation = "Tester";
		int age = 25;
		String query = "INSERT INTO mytable.employee VALUES(?,?,?,?)";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytable","root","mysql15");
		PreparedStatement ps = con.prepareStatement(query);
		ps.setInt(1,id);
		ps.setString(2, name);
		ps.setString(3, designation);
		ps.setInt(4, age);
		int count = ps.executeUpdate();
		System.out.println(count + " rows inserted");
		ps.close();
		con.close();
	}

}
