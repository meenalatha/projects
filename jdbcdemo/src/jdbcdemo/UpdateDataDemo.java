package jdbcdemo;

import java.sql.*;

public class UpdateDataDemo {

	public static void main(String[] args) throws Exception{
		String query = "UPDATE mytable.employee SET name = 'Meena', designation ='Engineer' WHERE id =123";
		Class.forName("com.mysql.jdbc.Driver");
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytable","root","mysql15");
		Statement st = con.createStatement();
		int count = st.executeUpdate(query);
		System.out.println(count + "row is updated");
		st.close();
		con.close();
	}

}
