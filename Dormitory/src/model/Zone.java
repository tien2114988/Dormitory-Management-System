package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;



public class Zone implements Serializable{
	private String name;
	private List<Cluster> clusterList;
	
	
	
	public Zone(String name) {
		this.name=name;
		this.clusterList = new ArrayList<Cluster>();
		if(name.equals("A")) {
			clusterList.add(new Cluster("AF",this));
			clusterList.add(new Cluster("AG",this));
			clusterList.add(new Cluster("AH",this));
		}else if(name.equals("B")){
			clusterList.add(new Cluster("BA",this));
			clusterList.add(new Cluster("BB",this));
			clusterList.add(new Cluster("BC",this));
			clusterList.add(new Cluster("BD",this));
			clusterList.add(new Cluster("BE",this));
		}
	}
	
	
	
	public String getName() {
		return name;
	}
	
	

	public List<Cluster> getClusterList() {
		return clusterList;
	}

	
	
	public List<Building> getBuildingListByGender(String clusterName, boolean forMale) {
		for (Cluster cluster : clusterList) {
			if(cluster.getName().equals(clusterName)) {
				return cluster.getBuildingListByGender(forMale);
			}
		}
		return null;
	}
	
	
	
	public List<Room> getVacancyRoomList(String clusterName, String buildingName, String roomTypeName){
		for (Cluster cluster : clusterList) {
			if(cluster.getName().equals(clusterName)) {
				return cluster.getVacancyRoomList(buildingName,roomTypeName);
			}
		}
		return null;
	}
}
