package student;

public class Student {
	private int id;
	private String name;
	private int gender;
	private int yob;
	private String contactNumber;
	private String parentName;
	private String parentNumber;
	private String englishName;

	public Student(int id, String name, int gender, int yob, String contactNumber, String englishName, String parentName, 
			String parentNumber) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.yob = yob;
		this.contactNumber = contactNumber;
		this.englishName = englishName;
		this.parentName = parentName;
		this.parentNumber = parentNumber;
	}

	public Student(String name, int gender, int yob, String contactNumber, String parentName, String parentNumber,
			String englishName) {
		this.name = name;
		this.gender = gender;
		this.yob = yob;
		this.contactNumber = contactNumber;
		this.parentName = parentName;
		this.parentNumber = parentNumber;
		this.englishName = englishName;
	}

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public String getParentName() {
		return parentName;
	}

	public String getEnglishName() {
		return englishName;
	}

	public void setEnglishName(String englishName) {
		this.englishName = englishName;
	}

	public void setYob(int yob) {
		this.yob = yob;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getParentNumber() {
		return parentNumber;
	}

	public void setParentNumber(String parentNumber) {
		this.parentNumber = parentNumber;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public int getYob() {
		return yob;
	}

	public void setDob(int yob) {
		this.yob = yob;
	}

	public String getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	
	
}