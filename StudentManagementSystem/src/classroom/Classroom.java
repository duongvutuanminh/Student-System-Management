package classroom;

public class Classroom {
	private int cid;
	private String className;
	private int tid;
	private int day1;
	private int day2;
	
	public Classroom(int cid, String className, int tid, int day1, int day2) {
		this.cid = cid;
		this.className = className;
		this.tid = tid;
		this.day1 = day1;
		this.day2 = day2;
	}
	
	public Classroom(String className, int tid, int day1, int day2) {
		this.className = className;
		this.tid = tid;
		this.day1 = day1;
		this.day2 = day2;
	}

	public Classroom() {
		// TODO Auto-generated constructor stub
	}

	public int getCid() {
		return cid;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getTid() {
		return tid;
	}
	
	public int getDay1() {
		return day1;
	}

	public void setDay1(int day1) {
		this.day1 = day1;
	}

	public int getDay2() {
		return day2;
	}

	public void setDay2(int day2) {
		this.day2 = day2;
	}
	
	
}