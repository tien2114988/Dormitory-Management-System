package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;



public class Dormitory implements Serializable{
	private List<Zone> zoneList;
	private List<Student> studentList;
	
	
	
	public Dormitory() {
		this.studentList = new ArrayList<Student>();
		this.zoneList = new ArrayList<Zone>();
		this.zoneList.add(new Zone("A"));
		this.zoneList.add(new Zone("B"));
	}

	
	
	public List<Zone> getZoneList() {
		return this.zoneList;
	}
	
	
	
	public List<Cluster> getClusterList(String zoneName){
		for (Zone zone : zoneList) {
			if(zone.getName().equals(zoneName)) {
				return zone.getClusterList();
			}
		}
		return null;
	}
	
	
	
	public List<Building> getBuildingListByGender(String zoneName, String clusterName, boolean forMale){
		for (Zone zone : zoneList) {
			if(zone.getName().equals(zoneName)) {
				return zone.getBuildingListByGender(clusterName,forMale);
			}
		}
		return null;
	}
	
	
	
	public List<Room> getVacancyRoomList(String zoneName, String clusterName, String buildingName, String roomTypeName){
		for (Zone zone : zoneList) {
			if(zoneName.equals(zone.getName())) {
				return zone.getVacancyRoomList(clusterName,buildingName,roomTypeName);
			}
		}
		return null;
	}
	
	
	
	public void addStudent(Student student) {
		studentList.add(student);
	}
	
	
	
	public void removeStudent(Student student,Room room) {
		studentList.remove(student);
		room.removeStudent(student);
	}
	
	
	
	public Student getStudent(String ID, String password) {
		for (Student student : studentList) {
			if(student.getID().equals(ID)&&student.getPassword().equals(password)) {
				return student;
			}
		}
		return null;
	}
	
	
	
	public boolean containID(String ID) {
		for (Student student : studentList) {
			if(student.getID().equals(ID)) {
				return true;
			}
		}
		return false;
	}
	
	
	
	public static List<String> getProvinceList(){
		return Arrays.asList("An Giang",
			"Bà Rịa – Vũng Tàu",
			"Bạc Liêu",
			"Bắc Giang",
			"Bắc Kạn",
			"Bắc Ninh",
			"Bến Tre",
			"Bình Dương",
			"Bình Định",
			"Bình Phước",
			"Bình Thuận",
			"Cà Mau",
			"Cao Bằng",
			"Đắk Lắk",
			"Đắk Nông",
			"Điện Biên",
			"Đồng Nai",
			"Đồng Tháp",
			"Gia Lai",
			"Hà Giang",
			"Hà Nam",
			"Hà Tĩnh",
			"Hải Dương",
			"Hậu Giang",
			"Hòa Bình",
			"Hưng Yên",
			"Khánh Hòa",
			"Kiên Giang",
			"Kon Tum",
			"Lai Châu",
			"Lạng Sơn",
			"Lào Cai",
			"Lâm Đồng",
			"Long An",
			"Nam Định",
			"Nghệ An",
			"Ninh Bình",
			"Ninh Thuận",
			"Phú Thọ",
			"Phú Yên",
			"Quảng Bình",
			"Quảng Nam",
			"Quảng Ngãi",
			"Quảng Ninh",
			"Quảng Trị",
			"Sóc Trăng",
			"Sơn La",
			"Tây Ninh",
			"Thái Bình",
			"Thái Nguyên",
			"Thanh Hóa",
			"Thừa Thiên Huế",
			"Tiền Giang",
			"Trà Vinh",
			"Tuyên Quang",
			"Vĩnh Long",
			"Vĩnh Phúc",
			"Yên Bái");
	}
	
	
	
	public static List<String> getUniversityList(){
		List<String> universityList = new ArrayList<String>();
		universityList.add("ĐH Bách Khoa, ĐHQG TP.HCM");
		universityList.add("ĐH Khoa học Tự nhiên, ĐHQG TP.HCM");
		universityList.add("ĐH Kinh tế - Luật, ĐHQG TP.HCM");
		universityList.add("ĐH Khoa học Xã hội và Nhân văn, ĐHQG TP.HCM");
		universityList.add("ĐH Công nghệ Thông tin, ĐHQG TP.HCM");
		universityList.add("ĐH Quốc tế, ĐHQG TP.HCM");
		return universityList;
	}

}
