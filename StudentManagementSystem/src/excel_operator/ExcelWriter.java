package excel_operator;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import student.Student;

public class ExcelWriter {
	public static void writeStudentsToFile(List<Student> students, String fileLocation) {
	    try (FileOutputStream fileOut = new FileOutputStream(new File(fileLocation, "students.xlsx"))) {
	        XSSFWorkbook workbook = new XSSFWorkbook();
	        XSSFSheet sheet = workbook.createSheet("Students");
	        XSSFRow headerRow = sheet.createRow(0);
	        headerRow.createCell(0).setCellValue("Name");
	        headerRow.createCell(1).setCellValue("Gender");
	        headerRow.createCell(2).setCellValue("Year of Birth");
	        headerRow.createCell(3).setCellValue("Contact Number");
	        headerRow.createCell(4).setCellValue("English Name");
	        headerRow.createCell(5).setCellValue("Parent Name");
	        headerRow.createCell(6).setCellValue("Parent Number");
	        int rowNum = 1;
	        for (Student student : students) {
	            XSSFRow row = sheet.createRow(rowNum++);
	            row.createCell(0).setCellValue(student.getName());
	            row.createCell(1).setCellValue(student.getGender() == 0 ? "Male" : "Female");
	            row.createCell(2).setCellValue(student.getYob());
	            row.createCell(3).setCellValue(student.getContactNumber());
	            row.createCell(4).setCellValue(student.getEnglishName());
	            row.createCell(5).setCellValue(student.getParentName());
	            row.createCell(6).setCellValue(student.getParentNumber());
	        }
	        workbook.write(fileOut);
	        workbook.close();
	        System.out.println("Excel file written to location: " + fileLocation);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
