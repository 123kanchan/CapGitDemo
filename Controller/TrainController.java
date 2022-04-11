package com.cgpack5.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cgpack5.exception.TrainCreationException;
import com.cgpack5.exception.AdminCreationException;
import com.cgpack5.exception.InvalidAdminException;
import com.cgpack5.exception.InvalidTrainException;
import com.cgpack5.dao.AdminDao;
import com.cgpack5.dao.TrainDao;


import com.cgpack5.model.Admin;
import com.cgpack5.model.Station;
import com.cgpack5.model.Train;
import com.cgpack5.model.User;

@RestController
public class TrainController {
	@Autowired
	TrainDao dao;
	@Autowired
	AdminDao dao1;
	//@Autowired
	//UserDao dao2;
	
	
	/*
	 * postmapping--create any resource
	 * getMapping--featch any resource
	 * putmapping-update any resource
	 * deletemapping--deleteany resource
	 * 5432
	 * Train  ---json
	 * json--java object
	 * 
	 * {
	 * " trainNumber" : 1234,
	 * "trainName":abc exp,
	 * "trainSourceStation":delhi
	 * "trainDestinationStation":ssd,
	 * "trainPrice":4343
	 * 
	 * 
	 * 
	 * 
	 * }
	 * 
	 */
	
	//localhost:8080/createTrain
	@PostMapping(path="/createTrain")
	public Train createTrain(@RequestBody Train train)throws TrainCreationException
	{
		return dao.addTrain(train);
	}

	@GetMapping(path = "/getAllTrain")
	public List<Train> getAllTrain()
	{
	return 	dao.getAllTrain();
	}
	
	@GetMapping(path = "/getTrainByNum/{trainNumber}")
	public Train getTrainByNumber(@PathVariable("trainNumber") int tNo) {
		
		return (Train) dao.getTrainByNumber(tNo);
	}
	
	@GetMapping(path = "/getTrainByName/{trainName}")
	public Train getTrainByName(@PathVariable("trainName") String nam) {
		
		return dao.getTrainByName(nam);
	}
	
	/*@GetMapping(path="/updateTrain")
	public int updateTrain() {
		return dao.updateTrain(1);
	
	}*/
	
	
	@PutMapping(path="/updateTrainById/{amt}/{num}")
	public int updateTrainById(@PathVariable double amt,@PathVariable int num)throws InvalidTrainException {
		return dao.updateTrainById(amt,num);
	
	}
	
	@GetMapping(path="/deleteTrain/{tNo}")
	public int deleteTrain(@PathVariable int tNo) {
		return dao.deleteTrain(tNo);
	
	}
	
	
	@GetMapping(path="/getStationbysrcanddest/{src}/{dest}")
	public Train getStationBysrcanddest(@PathVariable String src,@PathVariable String dest){
		
		return dao.Sourceanddest(src,dest);
	}
	
	/*@GetMapping(path = "/getStationByTNo/{tNo}")//
	public List<Station> getStationbyTno(@PathVariable int tNo) {
		
		return dao.getTrainStationByTrainNumber(tNo);
	}*/
	
	
	///for admin and user
	@PostMapping(path="/createAdmin")
	public Admin addAdmin(@RequestBody Admin admin)throws AdminCreationException
	{
		return dao1.addAdmin(admin);
	}
	@GetMapping(path="/deleteTrain/{aNo}")
	public void deleteAdmin(@PathVariable int aNo) {
		dao1.deleteAdmin(aNo);
	
	}
	@GetMapping(path="/getuserNamebyadminId/{ano}")
	public String getUserNameByAdmin(@PathVariable int ano)throws InvalidAdminException
	{
		return dao1.getAdminName(ano);
	}
	
	@GetMapping(path="/getuserPasswordbyadminId/{ano}")
	public String getUserPasswordByAdmin(@PathVariable int ano)throws InvalidAdminException
	{
		return dao1.getAdminPassword(ano);
	}
	
	/*@PostMapping(path="/adduser")
	public Train addUser(@RequestBody Train train )throws TrainCreationException
	{
		return dao.addTrain(train);
	}*/
	@PostMapping(path="/adduser")
	public Train addUser(@RequestBody Train train )throws TrainCreationException
	{
		return dao.addTrain(train);
	}
	
}
