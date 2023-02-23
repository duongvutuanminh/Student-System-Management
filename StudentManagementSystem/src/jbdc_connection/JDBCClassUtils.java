package jbdc_connection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import classroom.Classroom;

public class JDBCClassUtils {	
	private static ResourceBundle resourceBundle;

	public static List<Classroom> findAll() {
		List<Classroom> classes = new ArrayList<>();
		String query = "select * from class";
		try {
			Connection con = JDBCConnection.getJDBCConnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Classroom classroom = new Classroom(rs.getInt("cid"), 
										  rs.getString("class_name"), 
										  rs.getInt("tid"), 
										  rs.getInt("day1"),
										  rs.getInt("day2"));
				
				classes.add(classroom);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classes;
	}
	
	public static Classroom findByID(String id, Locale interLocale) {
		   resourceBundle = ResourceBundle.getBundle("resource_bundle_configs/resource_bundle", interLocale);
		   String query = "SELECT * FROM class WHERE cid = ?";
		   Classroom cla = null;
		   try (Connection connection = JDBCConnection.getJDBCConnection();
				   PreparedStatement preparedStatement = connection.prepareStatement(query);){
		      preparedStatement.setString(1, id);
		      ResultSet resultSet = preparedStatement.executeQuery();
		      if (resultSet.next()) {
		         if (resultSet.isLast()) {
		            cla = new Classroom(Integer.parseInt(id), resultSet.getString("class_name"), resultSet.getInt("tid"), resultSet.getInt("day1"), resultSet.getInt("day2"));
		         } else {
		        	JOptionPane.showMessageDialog(null, resourceBundle.getString("jdbc_warn_1") + " " + id, 
		        			resourceBundle.getString("error_label"), JOptionPane.ERROR_MESSAGE);
		            throw new Exception(resourceBundle.getString("jdbc_warn_1") + " " + id);
		         }
		      } else {
		    	  JOptionPane.showMessageDialog(null, resourceBundle.getString("jdbc_warn_2") + " " + id,
		    			  resourceBundle.getString("error_label"), JOptionPane.ERROR_MESSAGE);
		         throw new Exception(resourceBundle.getString("jdbc_warn_2") + " " + id);
		         
		      }
		   } catch (Exception e) {
		      e.printStackTrace();
		   }
		   return cla;
		}
	
	public static void insert(Classroom cla) {
	    String query = "insert into class(class_name, tid, day1, day2)" + 
	                   " values(?, ?, ?, ?)";
	    try (Connection con = JDBCConnection.getJDBCConnection();
	         PreparedStatement stmt = con.prepareStatement(query)) {
	        stmt.setString(1, cla.getClassName());
	        stmt.setInt(2, cla.getTid());
	        stmt.setInt(3, cla.getDay1());
	        stmt.setInt(4, cla.getDay2());
	        stmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	
	public static void delete(Classroom classroom) {
		String query = "delete from class where cid='" + classroom.getCid() + "'";
		try {
			Connection con = JDBCConnection.getJDBCConnection();
			PreparedStatement prestatement = con.prepareStatement(query);
			prestatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
//	
//	public static void deleteNth(int[] selectedRows) {
//		String query = "DELETE FROM table_name WHERE id = (SELECT id FROM (SELECT id FROM table_name ORDER BY id LIMIT " 
//						+ selectedRows[0] +", " + selectedRows.length + "  ) AS sub)";
//		try {
//			Connection con = JDBCConnection.getJDBCConnection();
//			PreparedStatement prestatement = con.prepareStatement(query);
//			prestatement.executeUpdate();
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//	}
//	
	public static void deleteAll() {
		String query = "delete from class";
		try {
			Connection con = JDBCConnection.getJDBCConnection();
			Statement statement = con.createStatement();
			statement.executeUpdate(query);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void update(Classroom cla) {
		String query = "update class set class_name=?, tid=?, day1=?, day2=? where id=\"" + cla.getCid() + "\"";
		try {
			Connection con = JDBCConnection.getJDBCConnection();
			PreparedStatement prestatement = con.prepareStatement(query);
			prestatement.setString(1,cla.getClassName());
			prestatement.setInt(2,cla.getTid());
			prestatement.setInt(3,cla.getDay1());
			prestatement.setInt(4,cla.getDay2());
			prestatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static List<Classroom> findClasses(String className, int classID){
		List<Classroom> classrooms = new ArrayList<>();
		String query = "select * from class where LOWER(class_name) LIKE LOWER('%" + className + "%') " +
											  " OR cid = " + Integer.toString(classID);
		try {
			Connection con = JDBCConnection.getJDBCConnection();
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				Classroom classroom = new Classroom(rs.getInt("cid"), 
										  rs.getString("class_name"), 
										  rs.getInt("tid"), 
										  rs.getInt("day1"), 
										  rs.getInt("day2"));
				classrooms.add(classroom);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classrooms;
	}
}
