package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




public class Building implements Serializable{
	private String name;
	private boolean forMale;
	private Cluster cluster;
	private List<Room> roomList;
	
	
	
	public Building(String name,String zoneName,boolean forMale,Cluster cluster) {
		this.name = name;
		this.cluster = cluster;
		this.forMale = forMale;
		this.roomList = new ArrayList<Room>();
		if(zoneName.equals("A")) {
			for(short i=1;i<5;i++) {
				for(short j=1;j<11;j++) {
					short roomNumber = (short)(i*100+j);
					if(i==1 || i==2) {
						roomList.add(new Room(roomNumber,RoomType.airCondition4,this));
					}else if(i==3) {
						roomList.add(new Room(roomNumber,RoomType.normal6,this));
					}else {
						roomList.add(new Room(roomNumber,RoomType.normal4,this));
					}
				}
			}
		}else{
			for(short i=1;i<11;i++) {
				for(short j=1;j<11;j++) {
					short roomNumber = (short)(i*100+j);
					if(i==1 || i== 2) {
						roomList.add(new Room(roomNumber,RoomType.normal8,this));
					}else if(i == 3 || i==4 || i==5) {
						roomList.add(new Room(roomNumber,RoomType.normal6,this));
					}else if(i == 6 || i == 7) {
						roomList.add(new Room(roomNumber,RoomType.airCondition4,this));
					}else if(i == 8 || i == 9) {
						roomList.add(new Room(roomNumber,RoomType.normal4,this));
					}else {
						roomList.add(new Room(roomNumber,RoomType.airCondition2,this));
					}
				}
			}
		}
	}
	

	
	public String getName() {
		return name;
	}
	
	
	
	public Cluster getCluster() {
		return cluster;
	}
	
	
	
	public boolean isForMale() {
		return forMale;
	}

	
	
	public List<Room> getVacancyRoomList(String roomTypeName){
		List<Room> vacancyRoomList = new ArrayList<Room>();
		for (Room room : roomList) {
			if(room.getTypeName().equals(roomTypeName) && room.isVacancy()) {
				vacancyRoomList.add(room);
			}
		}
		return vacancyRoomList;
	}
	
}
