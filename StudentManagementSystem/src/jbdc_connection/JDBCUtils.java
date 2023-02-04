package jbdc_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import student.Student;

public class JDBCUtils {
	public static List<Student> findAll() {
		List<Student> students = new ArrayList<>();
		String query = "select * from student";
		try {
			Connection con = JDBCConnection.getJDBCConnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Student stu = new Student(rs.getInt("id"), 
										  rs.getString("name"), 
										  rs.getInt("gender"), 
										  rs.getInt("yob"), 
										  rs.getString("contact_number"), 
										  rs.getString("english_name"),
										  rs.getString("parent_name"), 
										  rs.getString("parent_number"));
				
				students.add(stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}
	
	public static void insert(Student stu) {
	    String query = "insert into student(name, gender, yob, contact_number, english_name, parent_name, parent_number)" + 
	                   " values(?, ?, ?, ?, ?, ?, ?)";
	    try (Connection con = JDBCConnection.getJDBCConnection();
	         PreparedStatement stmt = con.prepareStatement(query)) {
	        stmt.setString(1, stu.getName());
	        stmt.setInt(2, stu.getGender());
	        stmt.setInt(3, stu.getYob());
	        stmt.setString(4, stu.getContactNumber());
	        stmt.setString(5, stu.getEnglishName());
	        stmt.setString(6, stu.getParentName());
	        stmt.setString(7, stu.getParentNumber());

	        stmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	public static void delete(Student stu) {
		String query = "delete from student where name='" + stu.getName() + "'";
		try {
			Connection con = JDBCConnection.getJDBCConnection();
			PreparedStatement prestatement = con.prepareStatement(query);
			prestatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void deleteAll() {
		String query = "delete from student";
		try {
			Connection con = JDBCConnection.getJDBCConnection();
			Statement statement = con.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void Update(Student stu) {
		String query = "update student set name=?, age=?, gender=?, major=?, score=? where name=\"" + stu.getName() + "\"";
		try {
			Connection con = JDBCConnection.getJDBCConnection();
			PreparedStatement prestatement = con.prepareStatement(query);
			prestatement.setString(1,stu.getName());
			prestatement.setInt(2,stu.getGender());
			prestatement.setInt(3, stu.getYob());
			prestatement.setString(4, stu.getContactNumber());
			prestatement.setString(5, stu.getParentName());
			prestatement.setString(6, stu.getParentNumber());
			prestatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Student> findStudents(String studentName, int studentId, String number){
		List<Student> students = new ArrayList<>();
		String query = "select * from student where LOWER(name) LIKE LOWER('%" + studentName + "%') " +
											  "OR id=" + studentId + " " +
											  "OR contact_number = \"" + number + "\" " +
											  "OR parent_number = \"" + number + "\"";
		try {
			Connection con = JDBCConnection.getJDBCConnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Student new_stu = new Student(rs.getInt("id"), 
										  rs.getString("name"), 
										  rs.getInt("gender"), 
										  rs.getInt("yob"), 
										  rs.getString("contact_number"), 
										  rs.getString("english_name"),
										  rs.getString("parent_name"), 
										  rs.getString("parent_number"));
				
				students.add(new_stu);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return students;
	}
}






