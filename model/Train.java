package com.cgpack5.model;




import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer"})
@Table(name="Train_Table")
public class Train {
	@Id
	private int trainNumber;
	private String trainName;
	private String trainSourceStation;
	private String trainDestinationStation;
	private double trainPrice;
	
	//@Enumerated(EnumType.STRING)
	private TrainStatus trainStatus;
	
	@Autowired
	@OneToOne(cascade = CascadeType.ALL)
	private Route route;
	
	
	
	public TrainStatus getTrainStatus() {
		return trainStatus;
	}
	public void setTrainStatus(TrainStatus trainStatus) {
		this.trainStatus = trainStatus;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public int getTrainNumber() {
		return trainNumber;
	}
	public void setTrainNumber(int trainNumber) {
		this.trainNumber = trainNumber;
	}
	public String getTrainName() {
		return trainName;
	}
	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}
	public String getTrainSourceStation() {
		return trainSourceStation;
	}
	public void setTrainSourceStation(String trainSourceStation) {
		this.trainSourceStation = trainSourceStation;
	}
	public String getTrainDestinationStation() {
		return trainDestinationStation;
	}
	public void setTrainDestinationStation(String trainDestinationStation) {
		this.trainDestinationStation = trainDestinationStation;
	}
	public double getTrainPrice() {
		return trainPrice;
	}
	public void setTrainPrice(double trainPrice) {
		this.trainPrice = trainPrice;
	}
	
	
	
	
	

}




