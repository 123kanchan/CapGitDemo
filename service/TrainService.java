package com.cgpack5.service;

import java.util.List;

import com.cgpack5.exception.AdminCreationException;
import com.cgpack5.exception.InvalidAdminException;
import com.cgpack5.exception.InvalidTrainException;
import com.cgpack5.exception.TrainCreationException;
import com.cgpack5.model.Station;
import com.cgpack5.model.Train;
import com.cgpack5.model.User;

public interface TrainService {
	public Train addTrain(Train train) throws TrainCreationException;
	public List<Train> getAllTrain();
	public Train getTrainByName(String trainName);
	public Train getTrainByNumber(int trainNumber);
	public int updateTrain(int trainNumber);
	public int updateTrainById(double price, int trainNumber)throws InvalidTrainException;
	public int deleteTrain(int trainNumber);
	public List<Station> getTrainStationByTrainNumber(int trainNumber);
	public Train Sourceanddest(String src,String dest);
	
}
