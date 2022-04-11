package com.cgpack5.service;

import java.util.List;
import java.util.Optional;

import com.cgpack5.model.Route;
import com.cgpack5.model.Station;

public interface RouteService {
	public Route addStationintoRoute(Route route);
	public List<Route> getAllAvailableRoutes();
	public List<Station> getAllStations() ;
	public Optional<Station> getAllStationById(int routeId) ;
	public int updateRoute(int routeId,String stat);
}
