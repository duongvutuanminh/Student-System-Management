package teacher;

public class Teacher {
	private int tid;
	private String teacherName;
	private String contactNumber;
	private int yob;
	
	public Teacher(int tid, String teacherName, String contactNumber, int yob) {
		this.tid = tid;
		this.teacherName = teacherName;
		this.contactNumber = contactNumber;
		this.yob = yob;
	}

	public Teacher(String teacherName, String contactNumber, int yob) {
		this.teacherName = teacherName;
		this.contactNumber = contactNumber;
		this.yob = yob;
	}

	public int getTid() {
		return tid;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

	public int getYob() {
		return yob;
	}

	public void setYob(int yob) {
		this.yob = yob;
	}
}
