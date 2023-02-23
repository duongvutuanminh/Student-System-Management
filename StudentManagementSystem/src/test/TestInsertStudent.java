package test;

import java.util.List;

import jbdc_connection.JDBCSStudentUtils;
import student.Student;

public class TestInsertStudent {

	public static void main(String[] args) {
		Student stu = new Student("John", 1, 1990, "1234567890", "John Doe", "Jane Doe", "0987654321");
	    int expectedNumOfStudents = JDBCSStudentUtils.findAll().size() + 1;

	    // Act
	    JDBCSStudentUtils.insert(stu);
	    List<Student> students = JDBCSStudentUtils.findAll();
	    int actualNumOfStudents = students.size();

	    // Assert
	    assertEquals(expectedNumOfStudents, actualNumOfStudents);

	    // Clean up
	    JDBCSStudentUtils.delete(stu);
	}

	private static boolean assertEquals(int expectedNumOfStudents, int actualNumOfStudents) {
		System.out.print(expectedNumOfStudents == actualNumOfStudents);
		return (expectedNumOfStudents == actualNumOfStudents);
	}

}
