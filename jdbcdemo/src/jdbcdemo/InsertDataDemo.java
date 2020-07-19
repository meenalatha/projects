package jdbcdemo;

import java.sql.*;

public class InsertDataDemo {

	public static void main(String[] args) throws Exception{
//				String query = "INSERT INTO mytable.employee VALUES (130,'Raj','TL',32)";
				Class.forName("com.mysql.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytable","root","mysql15");
				Statement st = con.createStatement();
				int id = 131;
				String name ="Pooja";
				String designation ="Supporter";
				int age = 25;
//				int count = st.executeUpdate(query);
				int count = st.executeUpdate("INSERT INTO mytable.employee VALUES ("+id+", '"+name+"', '"+designation+"',"+age+")");
				System.out.println(count + "row inserted");
				st.close();
				con.close();
	}
}
