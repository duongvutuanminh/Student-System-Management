package student_class;

public class StudentClass {
	private int enrolment_number;
	private int class_id;
	private int student_id;
	private int midterm_test;
	private int finalterm_test;
	
	public StudentClass(int enrolment_number, int class_id, int student_id, int midterm_test, int finalterm_test) {
		this.enrolment_number = enrolment_number;
		this.class_id = class_id;
		this.student_id = student_id;
		this.midterm_test = midterm_test;
		this.finalterm_test = finalterm_test;
	}

	public StudentClass(int class_id, int student_id, int midterm_test, int finalterm_test) {
		this.class_id = class_id;
		this.student_id = student_id;
		this.midterm_test = midterm_test;
		this.finalterm_test = finalterm_test;
	}

	public StudentClass(int class_id, int student_id) {
		this.class_id = class_id;
		this.student_id = student_id;
	}

	public StudentClass() {
		// TODO Auto-generated constructor stub
	}

	public int getEnrolment_number() {
		return enrolment_number;
	}

	public void setEnrolment_number(int enrolment_number) {
		this.enrolment_number = enrolment_number;
	}

	public int getStudent_id() {
		return student_id;
	}

	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}

	public int getMidterm_test() {
		return midterm_test;
	}

	public void setMidterm_test(int midterm_test) {
		this.midterm_test = midterm_test;
	}

	public int getFinalterm_test() {
		return finalterm_test;
	}

	public void setFinalterm_test(int finalterm_test) {
		this.finalterm_test = finalterm_test;
	}

	public int getClass_id() {
		return class_id;
	}
}
