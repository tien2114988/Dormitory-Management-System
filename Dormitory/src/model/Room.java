package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



enum RoomType{
	airCondition2,
	normal4,
	airCondition4,
	normal6,
	normal8
}



public class Room implements Serializable{
	private short roomNumber;
	private short slot;
	private short vacancy;
	private RoomType roomType;
	private String typeName;
	private Building building;
	private List<Student> studentList;
	
	
	
	public Room(short roomNumber, RoomType roomType,Building building) {
		this.roomType = roomType;
		this.roomNumber = roomNumber;
		if(roomType == RoomType.airCondition2) {
			slot = 2;
			typeName = "Phòng 2 sinh viên có máy lạnh";
		}else if(roomType == RoomType.airCondition4) {
			slot = 4;
			typeName = "Phòng 4 sinh viên có máy lạnh";
		}else if(roomType == RoomType.normal4) {
			slot = 4;
			typeName = "Phòng 4 sinh viên";
		}else if(roomType == RoomType.normal6) {
			slot = 6;
			typeName = "Phòng 6 sinh viên";
		}else {
			slot = 8;
			typeName = "Phòng 8 sinh viên";
		}
		this.vacancy = this.slot;
		this.studentList = new ArrayList<Student>();
		this.building = building;
	}
	
	
	
	public short getRoomNumber() {
		return roomNumber;
	}



	public short getSlot() {
		return slot;
	}



	public short getVacancy() {
		return vacancy;
	}



	public RoomType getRoomType() {
		return roomType;
	}



	public String getTypeName() {
		return typeName;
	}



	public List<Student> getStudentList() {
		return studentList;
	}


	
	public Building getBuilding() {
		return building;
	}

	
	
	public boolean isVacancy() {
		return vacancy > 0;
	}
	
	
	public void addStudent(Student student) {
		vacancy--;
		studentList.add(student);
	}
	
	
	
	public void removeStudent(Student student) {
		vacancy++;
		studentList.remove(student);
	}
	
	
	
	public static List<String> getRoomTypeList(String zoneName){
		List<String> roomTypeList = new ArrayList<String>();
		if(zoneName.equals("A")) {
			roomTypeList.add("Phòng 4 sinh viên có máy lạnh");
			roomTypeList.add("Phòng 4 sinh viên");
			roomTypeList.add("Phòng 6 sinh viên");
		}else if(zoneName.equals("B")) {
			roomTypeList.add("Phòng 2 sinh viên có máy lạnh");
			roomTypeList.add("Phòng 4 sinh viên có máy lạnh");
			roomTypeList.add("Phòng 4 sinh viên");
			roomTypeList.add("Phòng 6 sinh viên");
			roomTypeList.add("Phòng 8 sinh viên");		
		}
		return roomTypeList;
	}
}
