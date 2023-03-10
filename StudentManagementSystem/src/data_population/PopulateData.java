package data_population;

import java.util.Random;

import jbdc_connection.JDBCSStudentUtils;
import student.Student;

public class PopulateData {
	static int instanceNumber;
    static boolean originalPopulate;
	
    public static void populateNow(String[] args) {
        if (args.length != 2) {
            System.out.println("Please provide two arguments: an integer and a boolean.");
            return;
        }
        
        try {
            instanceNumber = Integer.parseInt(args[0]);
        } catch (NumberFormatException e) {
            System.out.println("The first argument must be an integer.");
            return;
        }
        
        try {
            originalPopulate = Boolean.parseBoolean(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("The second argument must be a boolean.");
            return;
        }
        
        System.out.printf("Data received!\nNumber of instance: %d\nPopulate from start: %b\n", instanceNumber, originalPopulate);
        startPopulating(instanceNumber, originalPopulate);
        System.out.println("Injecting succeed!");
    }

	private static void startPopulating(int instanceNumber, boolean originalPopulate) {
		if (originalPopulate == true) {
			JDBCSStudentUtils.deleteAll();
		}
		
		Random random = new Random();
		
		String[] firstNames = {
		        "An", "Bình", "Cao", "Đức", "Hải", "Hùng", "Khánh", "Minh", "Nam", "Phúc", "Quang", "Sang", "Tài", "Thắng", "Thanh", "Trung", "Tùng", "Văn"
		};
	    String[] lastNames = {
	        "Nguyễn", "Trần", "Lê", "Phạm", "Hoàng", "Phan", "Vũ", "Đặng", "Bùi", "Đỗ", "Hồ", "Ngô", "Dương", "Lương", "Tuấn", "Đinh"
	    };
	    String[] englishNames = {
	            "Smith", "Johnson", "Williams", "Jones", "Brown", "Davis", "Miller", "Wilson", "Moore", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin", "Thompson", "Young", "Allen"
        };
	    String[] vietnameseWomanNames = {
	    	    "Anh", "Bảo", "Châu", "Dung", "Hạnh", "Hải", "Hiền", "Hoa", "Huệ", "Khánh", "Kim", "Lan", "Minh", "Nga", "Nhi", "Phượng", "Quỳnh", "Tâm", "Thanh", "Thảo", "Trang", "Uyên", "Yến"
	    };
	    
	    for (int i = 0; i < instanceNumber; i++) {
	    	String firstName = firstNames[random.nextInt(firstNames.length)];
	        String lastName = lastNames[random.nextInt(lastNames.length)];
	        String parentFirstName = vietnameseWomanNames[random.nextInt(vietnameseWomanNames.length)];
	        String vietnamName =  firstName + " " + lastName;
	        String parentName = parentFirstName + " " + lastName;
	        String englishName = englishNames[random.nextInt(englishNames.length)];
	        int gender = random.nextInt(1);
	        int yob = random.nextInt(2018 - 1980) + 1980;
	        String contactNumber = "09" + random.nextInt(100000000);
	        String parentNumber = "09" + random.nextInt(100000000);
	        Student student = new Student(vietnamName, gender, yob, contactNumber, parentName, parentNumber, englishName);
	        JDBCSStudentUtils.insert(student);
	    }
	}
}

