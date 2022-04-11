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

import com.cgpack5.dao.RouteDao;
import com.cgpack5.model.Route;
import com.cgpack5.model.Station;
import com.cgpack5.model.Train;

@RestController
public class RouteController {
	
	@Autowired
	RouteDao service;
	
	@PostMapping(path="/createRoute")
	public Route createRoute(@RequestBody Route route)
	{
		
		Route r=service.addStationintoRoute(route);
		List<Station>lo=r.getStations();
	//List<Station>l=service.getAllStations();
		r.addStations(lo);
	//r.setStations(lo);
		return r;
	}
	
	@GetMapping(path="/getAllRoutesAvail")
	public List<Route> getAllRoutes(){
		return service.getAllAvailableRoutes();
	}
	
	
	
	
	@GetMapping(path="/getStations")
	public List<Station> getStations(){
		return service.getAllStations();
	}
	
	@GetMapping(path="/getStationbyId/{id}")
	public Optional<Station> getStationById(@PathVariable int id){
		
		return service.getAllStationById(id);
	}
	
	


	
	@PutMapping(path="/updateRouteById/{id}/{str}")
	public int updateRoute(@PathVariable int id, @PathVariable String str) { 
		return service.updateRoute(id,str);
	}
	

}
