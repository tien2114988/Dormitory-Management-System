package model;

import java.io.Serializable;
import java.util.Date;



public class Student implements Serializable{
	private String name;
	private String ID;
	private String password;
	private boolean isMale;
	private Date birthday;
	private String province;
	private String universityName;
	private String studentID;
	private String email;
	private String phoneNumber;
	private Room room;
	
	
	
	public Student(String name,String ID, boolean isMale, String universityName, String studentID, Date birthday, String email,
		String phoneNumber, String province,Room room) {
		this.name = name;
		this.ID = ID;
		this.isMale = isMale;
		this.universityName = universityName;
		this.studentID = studentID;
		this.birthday = birthday;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.province = province;
		this.password = ID;
		this.room = room;
		this.room.addStudent(this);
	}
	
	
	
	public Room getRoom() {
		return room;
	}
	
	
	
	public String getPassword() {
		return password;
	}
	
	
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	public String getID() {
		return ID;
	}
	
	
	
	public String getName() {
		return name;
	}
	
	
	
	public boolean isMale() {
		return isMale;
	}
	
	
	
	public String getUniversityName() {
		return universityName;
	}
	
	
	
	public String getStudentID() {
		return studentID;
	}
	
	
	
	public Date getBirthday() {
		return birthday;
	}
	
	
	
	public String getEmail() {
		return email;
	}
	
	
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	
	
	public String getProvince() {
		return province;
	}
}
