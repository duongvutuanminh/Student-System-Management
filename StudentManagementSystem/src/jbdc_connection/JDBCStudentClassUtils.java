package jbdc_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import student_class.StudentClass;

public class JDBCStudentClassUtils {
	public static List<StudentClass> findAll(int classId) {
		List<StudentClass> studentClasses = new ArrayList<>();
		String query = "select * from student_class where class_id = " + classId;
		try {
			Connection con = JDBCConnection.getJDBCConnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				StudentClass studentClass = new StudentClass(rs.getInt("enrolment_no"), 
										  			rs.getInt("class_id"), 
												    rs.getInt("student_id"), 
												    rs.getInt("midterm_test"), 
												    rs.getInt("finalterm_test"));
				
				studentClasses.add(studentClass);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentClasses;
	}
	
	public static void insert(StudentClass insertedStudentClass) {
		String sql = "insert into student_class(class_id, student_id, midterm_test, finalterm_test) values(?,?,?,?)";
		try (Connection con = JDBCConnection.getJDBCConnection();
		         PreparedStatement stmt = con.prepareStatement(sql)) {
		        stmt.setInt(1, insertedStudentClass.getClass_id());
		        stmt.setInt(2, insertedStudentClass.getStudent_id());		       
		        stmt.setInt(3, insertedStudentClass.getMidterm_test());	
		        stmt.setInt(4, insertedStudentClass.getFinalterm_test());	
		        stmt.executeUpdate();
		    } catch (Exception e) {
		        e.printStackTrace();
		    }
	}
	
	public static void update(StudentClass updatedStudentClass) {
	    String sql = "update student_class set class_id=?, student_id=?, midterm_test=?, finalterm_test=? where enrolment_no=?";
	    try (Connection con = JDBCConnection.getJDBCConnection();
	         PreparedStatement stmt = con.prepareStatement(sql)) {
	        stmt.setInt(3, updatedStudentClass.getMidterm_test());
	        stmt.setInt(4, updatedStudentClass.getFinalterm_test());
	        stmt.setInt(1, updatedStudentClass.getClass_id());
	        stmt.setInt(2, updatedStudentClass.getStudent_id());
	        stmt.setInt(5, updatedStudentClass.getEnrolment_number());
	        stmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	public static void delete(StudentClass deletedStudentClass) {
		String sql = "DELETE FROM student_class WHERE student_id = ? AND class_id = ?";
		try {
			Connection con = JDBCConnection.getJDBCConnection();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, Integer.toString(deletedStudentClass.getStudent_id()));
			statement.setString(2, Integer.toString(deletedStudentClass.getClass_id()));
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String findNameWithID(int studentID) {
		String query = "SELECT * FROM student WHERE id = ?";
		   String res = null;
		   try (Connection connection = JDBCConnection.getJDBCConnection();
				   PreparedStatement preparedStatement = connection.prepareStatement(query);){
		      preparedStatement.setString(1, Integer.toString(studentID));
		      ResultSet resultSet = preparedStatement.executeQuery();
		      if (resultSet.next()) {
		         if (resultSet.isLast()) {
		            res = resultSet.getString("name");
		         } 
		   }} catch (Exception e) {
		      e.printStackTrace();
		   }
		   return res;
	}
	
	public static StudentClass findWithEnrolmentID(int enrolmentID) {
		String query = "SELECT * FROM student_class WHERE enrolment_no = ?";
		StudentClass studentInClass = null;
		try (Connection connection = JDBCConnection.getJDBCConnection();
		         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
		        preparedStatement.setInt(1, enrolmentID);
		        ResultSet resultSet = preparedStatement.executeQuery();
		        if (resultSet.next()) {
		        	studentInClass = new StudentClass(enrolmentID, resultSet.getInt("class_id"), resultSet.getInt("student_id"), resultSet.getInt("midterm_test"), resultSet.getInt("finalterm_test"));
		        }
		} catch (Exception e) {
			e.printStackTrace();
		}
		return studentInClass;
	}

	public static boolean checkStudentNameMatchesID(String txtStudentName, int txtStudentID) {
	    String query = "SELECT COUNT(*) FROM student WHERE id = ? AND name = ?";
	    try (Connection connection = JDBCConnection.getJDBCConnection();
	         PreparedStatement preparedStatement = connection.prepareStatement(query)) {
	        preparedStatement.setInt(1, txtStudentID);
	        preparedStatement.setString(2, txtStudentName);
	        ResultSet resultSet = preparedStatement.executeQuery();
	        if (resultSet.next()) {
	            int count = resultSet.getInt(1);
	            return count == 1;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return false;
	}

}
