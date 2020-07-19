package jdbcdemo;

import java.sql.*;

public class mysqldemo {

	public static void main(String[] args) {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytable","root","mysql15");
			if(con != null) {
				System.out.println("Connected Successfully");
			}
		}catch(Exception e) {
			System.out.println("Not connected");
		}
	}

}
