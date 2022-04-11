package com.cgpack5.model;


import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="Route_Details")
public class Route {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int routeId;
	
	@Autowired
	@OneToMany(cascade = CascadeType.ALL)
	private List<Station> stations;
	
	public int getRouteId() {
		return routeId;
	}
	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}
	public List<Station> getStations() {
		return stations;
	}
	public void setStations(List<Station> stations) {
		this.stations = stations;
	}
	
	public void addStations(List<Station> lo) {
		this.getStations().addAll(lo);
	}
	

}