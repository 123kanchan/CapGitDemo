package com.cgpack5.model;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Stations_Details")
public class Station {
	
	@Id
	private int stationCode;
	private String stationName;
	private String state;
	
	
	public int getStationCode() {
		return stationCode;
	}
	public void setStationCode(int stationCode) {
		this.stationCode = stationCode;
	}
	public String getStationName() {
		return stationName;
	}
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	
	

}
