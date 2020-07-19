package jdbcdemo;

import java.sql.*;
public class DaoFetchDemo {

	public static void main(String[] args) throws SQLException {
		StudentDAO dao = new StudentDAO();
		dao.connect();
//		Student s1= dao.getStudent(11);
//		System.out.println(s1.name);				//select query
		
//		Student s2 = new Student();					//insert query
//		s2.rollno= 13;
//		s2.name="Usha";
//		s2.marks = 85;
//		dao.addStudent(s2);
		
//		dao.updateStudent(13);						//update query
		dao.deleteStudent(13);						//delete query	
	}
}

class StudentDAO{
	Connection con = null;
	
	public void connect() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mytable","root","mysql15");
		} catch (Exception e) {
			System.out.println("Error");
		}	
	}

	public Student getStudent(int rollno) {
		try {
			Student s = new Student();
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery("SELECT name FROM mytable.student WHERE rollno= "  +rollno);
			rs.next();
			s.name = rs.getString(1);
			return s;
		} catch (SQLException e) {
			System.out.println(e);
		}
		return null;
	}

	public void addStudent(Student s2) {
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO mytable.student VALUES(?,?,?)");
			ps.setInt(1, s2.rollno);
			ps.setString(2, s2.name);
			ps.setInt(3, s2.marks);
			int count = ps.executeUpdate();
			System.out.println(count + "row is added");	
		} catch (SQLException e) {
			System.out.println(e);
		}	
	}
	
	public void updateStudent(int rollno) {
		try {
			Statement st = con.createStatement();
			int count = st.executeUpdate("UPDATE mytable.student SET name = 'Anu' WHERE rollno =" + rollno);
			System.out.println(count + " row updated");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
	
	public void deleteStudent(int rollno) {
		try {
			Statement st = con.createStatement();
			int count = st.executeUpdate("DELETE FROM mytable.student WHERE rollno =" + rollno);
			System.out.println(count + " row deleted");
		} catch (SQLException e) {
			System.out.println(e);
		}
	}
}
class Student{
	int rollno;
	String name;
	int marks;
}