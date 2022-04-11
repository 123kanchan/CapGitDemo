package com.cgpack5.dao;



import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgpack5.exception.TrainCreationException;
import com.cgpack5.exception.AdminCreationException;
import com.cgpack5.exception.InvalidAdminException;
import com.cgpack5.exception.InvalidTrainException;
import com.cgpack5.exception.InvalidTrainException;
import com.cgpack5.exception.TrainCreationException;
import com.cgpack5.model.Route;
import com.cgpack5.model.Station;
import com.cgpack5.model.Train;
import com.cgpack5.model.User;
import com.cgpack5.repository.AdminRepository;
import com.cgpack5.repository.TrainRepository;
import com.cgpack5.repository.UserRepository;
import com.cgpack5.service.TrainService;
import com.cgpack5.service.UserService;


@Service
public class TrainDao implements  TrainService{
	@Autowired
UserRepository r;
	@Autowired
	TrainRepository repos;
	
	
	/*@Override
	public Train addTrain(Train train)throws TrainCreationException {
		if(repos.existsById(train.getTrainNumber()))
		{
			throw new TrainCreationException("This train is available");
		}
		
	
		return  repos.save(train);
	}*/

	@Override
	public List<Train> getAllTrain() {
	List<Train> listOfTrain=repos.findAll();
		return listOfTrain;
	}

	@Override
	public Train getTrainByName(String trainName) {
		Train train1 = repos.getTrainByName(trainName);
		return train1;
	}
	@Override
	public Train getTrainByNumber(int trainNumber) {
		return repos.getById(trainNumber);
		
	}

	@Override
	public int updateTrain(int trainNumber) {
		
		Train train=repos.getById(trainNumber);
		train.setTrainPrice(600);
		Train trainobj=repos.save(train);
		
		//int s = repos.updateTrainById(600, 1234);
		
		if(trainobj==null) {
			return 0;
		}
		else
			return 1;
	}
	
	@Override
	public int updateTrainById(double price, int trainNumber)throws InvalidTrainException {
		
		//int s = repos.updateTrainById(price, trainNumber);
		
		//return s;
		int status=0;
		if(repos.existsById(trainNumber))
		{
			status=repos.updateTrainById(price,trainNumber);
		}
		else
		{
			throw new InvalidTrainException("Train number is not available");
		}
		return status;
	}
	

	@Override
	public int deleteTrain(int trainNumber) {
		repos.deleteById(trainNumber);
		return 1;
	}

	@Override
	public List<Station> getTrainStationByTrainNumber(int trainNumber) {
		Train tr = repos.getById(trainNumber);
		Route r = tr.getRoute();
		List<Station> stations = r.getStations();
		return stations;
	}

	public Train Sourceanddest(String src, String dest) {
	Train t=repos.srcanddest(src,dest);
	return t;
	}

	@Override
	public Train addTrain(Train train)throws TrainCreationException {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter name and password");
		String userName=sc.nextLine();
		String password=sc.nextLine();
		String a=r.getUsername(userName);//getting password
		System.out.println(a);
		if(a==null)
			//return repos.save(train);
			throw new TrainCreationException("user not exist");
		
		if(a.equals(password))
		{
			System.out.println(train.getTrainNumber());
			boolean a1=repos.existsById(train.getTrainNumber());
			System.out.println(a1);
			if(a1==true)
				throw new TrainCreationException("train already available");
			return repos.save(train);
		}
		else
		throw new TrainCreationException("login fail");	
		
		
	}
	
		
	




}