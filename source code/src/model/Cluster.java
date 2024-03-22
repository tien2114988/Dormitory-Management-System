package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Cluster implements Serializable{
	private String name;
	private Zone zone;
	private List<Building> buildingList;
	
	
	
	public Cluster(String name,Zone zone) {
		this.name = name;
		this.zone = zone;
		this.buildingList = new ArrayList<Building>();
		if(name.equals("AF")) {
			buildingList.add(new Building("A1","A",false,this));
			buildingList.add(new Building("A2","A",true,this));
			buildingList.add(new Building("A3","A",true,this));
			buildingList.add(new Building("A5","A",false,this));
			buildingList.add(new Building("A6","A",true,this));
			buildingList.add(new Building("A10","A",true,this));
			buildingList.add(new Building("A11","A",false,this));
		}else if(name.equals("AG")){
			buildingList.add(new Building("A4","A",false,this));
			buildingList.add(new Building("A7","A",false,this));
			buildingList.add(new Building("A8","A",false,this));
			buildingList.add(new Building("A9","A",false,this));
			buildingList.add(new Building("A12","A",false,this));
			buildingList.add(new Building("A14","A",true,this));
			buildingList.add(new Building("A15","A",true,this));
			buildingList.add(new Building("A17","A",false,this));
			buildingList.add(new Building("A18","A",true,this));
			buildingList.add(new Building("A19","A",true,this));
			buildingList.add(new Building("A20","A",true,this));
		}else if(name.equals("AH")){
			buildingList.add(new Building("AG3","A",false,this));
			buildingList.add(new Building("AG4","A",true,this));
			buildingList.add(new Building("AH1","A",true,this));
			buildingList.add(new Building("AH2","A",true,this));
		}else if(name.equals("BA")){
			buildingList.add(new Building("BA1","B",false,this));
			buildingList.add(new Building("BA2","B",false,this));
			buildingList.add(new Building("BA3","B",false,this));
			buildingList.add(new Building("BA4","B",true,this));
			buildingList.add(new Building("BA5","B",false,this));
		}else if(name.equals("BB")){
			buildingList.add(new Building("B1","B",false,this));
			buildingList.add(new Building("B2","B",false,this));
			buildingList.add(new Building("B3","B",false,this));
			buildingList.add(new Building("B4","B",true,this));
			buildingList.add(new Building("B5","B",true,this));
		}else if(name.equals("BC")){
			buildingList.add(new Building("C1","B",false,this));
			buildingList.add(new Building("C2","B",true,this));
			buildingList.add(new Building("C3","B",true,this));
			buildingList.add(new Building("C4","B",false,this));
			buildingList.add(new Building("C5","B",false,this));
			buildingList.add(new Building("C6","B",false,this));
		}else if(name.equals("BD")){
			buildingList.add(new Building("D2","B",true,this));
			buildingList.add(new Building("D3","B",false,this));
			buildingList.add(new Building("D4","B",false,this));
			buildingList.add(new Building("D5","B",true,this));
			buildingList.add(new Building("D6","B",true,this));
		}else if(name.equals("BE")){
			buildingList.add(new Building("E1","B",false,this));
			buildingList.add(new Building("F1","B",false,this));
			buildingList.add(new Building("F2","B",true,this));
			buildingList.add(new Building("G1","B",true,this));
		}
	}
	
	
	
	public String getName() {
		return name;
	}
	
	
	
	public Zone getZone() {
		return zone;
	}

	
	
	public List<Building> getBuildingListByGender(boolean forMale) {
		List<Building> buildingListByGender = new ArrayList<Building>();
		for (Building building : buildingList) {
			if(building.isForMale()==forMale) {
				buildingListByGender.add(building);
			}
		}
		return buildingListByGender;
	}
	
	
	
	public List<Room> getVacancyRoomList(String buildingName, String roomTypeName){
		for (Building building : buildingList) {
			if(buildingName.equals(building.getName())) {
				return building.getVacancyRoomList(roomTypeName);
			}
		}
		return null;
	}
	
	
	
	public boolean containBuilding(String buildingName) {
		for (Building building : buildingList) {
			if(building.getName().equals(buildingName)) {
				return true;
			}
		}
		return false;
	}
}
