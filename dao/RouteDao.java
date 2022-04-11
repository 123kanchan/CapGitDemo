package com.cgpack5.dao;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cgpack5.model.Route;
import com.cgpack5.model.Station;
import com.cgpack5.model.Train;
import com.cgpack5.repository.RouteRepository;
import com.cgpack5.repository.StationRepository;
import com.cgpack5.service.RouteService;

@Service
public class RouteDao implements RouteService{
	
	@Autowired
	RouteRepository repo1;
	
	@Autowired
	StationRepository srepo;
	@Override
	public Route addStationintoRoute(Route route) {
		return repo1.save(route);
		
	}

	@Override
	public List<Route> getAllAvailableRoutes() {
		List<Route> stations = repo1.findAll();
		return stations;
	}

	@Override
	public List<Station> getAllStations() {
		List<Station> stat = repo1.getAllStations();
		return stat;
	}

	@Override
	public Optional<Station> getAllStationById(int routeId) {
		//Route routes = repo1.getById(routeId);
		
		Optional<Station> routes = srepo.findById(routeId);
		return routes;
	}
	/*
	@Override
	public int updateRoute(Route route, int routeId, String stat) {
		List<Station> st = route.getStations();
		int x =0;
		for(Station s: st) {
			String str = s.getState();
			if(str.equalsIgnoreCase(stat)) {
				x = repo1.updateRoute(routeId, stat);
				break;
			}	
		}
		return x;
	}
	*/

	@Override
	public int updateRoute(int routeId,String stat) {

	
	
		Optional<Station> r = srepo.findById(routeId);
		int x=0;
	
		Station st =r.get();
		if(st.getStationName().equals("haridwar"))
			{st.setStationName(stat);x=1;}
		/*for(Station a:obj)
		int x =0;
		for(Optional<Station> s:s) {
			x=1;
			String str = r.get().getStationName();
			if(str.equals("haridwar")) {
				s.setStationName(stat);
				break;
			}	
		}*/
		return x;
		
	}




	
}
