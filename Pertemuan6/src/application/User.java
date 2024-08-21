package application;

public class User {
	
	private String name;
	private String gender;
	private int age;
	private String courses;

	public User(String name, String gender, int age, String courses) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.courses = courses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getCourses() {
		return courses;
	}

	public void setCourses(String courses) {
		this.courses = courses;
	}
	
	

}
