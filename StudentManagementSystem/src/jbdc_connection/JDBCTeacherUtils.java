package jbdc_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import teacher.Teacher;

public class JDBCTeacherUtils {
	public static Teacher findByID(int id) {
		   String query = "SELECT * FROM teacher WHERE tid = ?";
		   Teacher teacher = null;
		   try (Connection connection = JDBCConnection.getJDBCConnection();
				   PreparedStatement preparedStatement = connection.prepareStatement(query);){
		      preparedStatement.setString(1, Integer.toString(id));
		      ResultSet resultSet = preparedStatement.executeQuery();
		      if (resultSet.next()) {
		         if (resultSet.isLast()) {
		        	 teacher = new Teacher(id, resultSet.getString("teacher_name"), resultSet.getString("contact_number"), resultSet.getInt("yob"));
		         } else {
		        	JOptionPane.showMessageDialog(null, "More than one teacher found with the same ID: " + id, 
			            		"Error", JOptionPane.ERROR_MESSAGE);
		            throw new Exception("More than one teacher found with the same ID: " + id);
		         }
		      } else {
		    	  JOptionPane.showMessageDialog(null, "No teacher found with ID: " + id, 
		            		"Error", JOptionPane.ERROR_MESSAGE);
		         throw new Exception("No teacher found with ID: " + id);
		         
		      }
		   } catch (Exception e) {
		      e.printStackTrace();
		   }
		   return teacher;
	}
	
	public static Teacher findByID_noPane(int id) {
		   String query = "SELECT * FROM teacher WHERE tid = ?";
		   Teacher teacher = null;
		   try (Connection connection = JDBCConnection.getJDBCConnection();
				   PreparedStatement preparedStatement = connection.prepareStatement(query);){
		      preparedStatement.setString(1, Integer.toString(id));
		      ResultSet resultSet = preparedStatement.executeQuery();
		      if (resultSet.next()) {
		         if (resultSet.isLast()) {
		        	 teacher = new Teacher(id, resultSet.getString("teacher_name"), resultSet.getString("contact_number"), resultSet.getInt("yob"));
		         } else {
		            throw new Exception("More than one teacher found with the same ID: " + id);
		         }
		      } else {
		         throw new Exception("No teacher found with ID: " + id);
		         
		      }
		   } catch (Exception e) {
		      e.printStackTrace();
		   }
		   return teacher;
	}
	
	public static List<Teacher> findAll() {
		List<Teacher> teachers = new ArrayList<>();
		String query = "select * from teacher";
		try {
			Connection con = JDBCConnection.getJDBCConnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Teacher teacher = new Teacher(rs.getInt("tid"), 
										  rs.getString("teacher_name"), 
										  rs.getString("contact_number"), 
										  rs.getInt("yob"));
				
				teachers.add(teacher);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return teachers;
	}
}
