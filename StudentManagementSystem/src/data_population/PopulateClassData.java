package data_population;

import java.util.List;
import java.util.Random;

import classroom.Classroom;
import jbdc_connection.JDBCClassUtils;
import jbdc_connection.JDBCTeacherUtils;
import teacher.Teacher;

public class PopulateClassData {
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

	private static void startPopulating(int instanceNumber2, boolean originalPopulate2) {
		
		if (originalPopulate == true) {
			JDBCClassUtils.deleteAll();
		}
		
		Random random = new Random();
		
		String[] classPrefixs = {
		        "Kid", "Mover", "Flyer", "IELTS", "KET", "PTE", "Super Speaking"
		};
	    
	    for (int i = 0; i < instanceNumber; i++) {
	    	String className = classPrefixs[random.nextInt(classPrefixs.length)] + " " + Integer.toString(random.nextInt(9)+1);
	        List<Teacher> availableTeachers = JDBCTeacherUtils.findAll();
	        int tid = random.nextInt(availableTeachers.size())+1;
	        int day1 = random.nextInt(7) + 2;
	        int day2 = day1;
	        while (day2 == day1) {
	        	day2 = random.nextInt(7) + 2;
	        }
	        int smallerDay = 0;
	        int biggerDay = 0;
	        if (day1 < day2) {
	        	smallerDay = day1;
	        	biggerDay = day2;
	        }
	        else {
	        	smallerDay = day2;
	        	biggerDay = day1;
	        }
	        Classroom cla = new Classroom(className, tid, smallerDay, biggerDay);
	        JDBCClassUtils.insert(cla);
	    }
	}

}
