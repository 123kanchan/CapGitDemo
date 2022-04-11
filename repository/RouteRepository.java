package com.cgpack5.repository;



import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cgpack5.model.Route;
import com.cgpack5.model.Station;
import com.cgpack5.model.Train;

@Repository
public interface RouteRepository extends  JpaRepository<Route, Integer>{
	
	@Query("select s from Station s")
	public List<Station> getAllStations();

	public Station save(Station s);
	


	
	
	/*@Transactional
	@Modifying
	@Query("update Route r set s.state =:p2 from Station s where r.routeId=?p1")
	public int updateRoute(int p1,String p2);
	*/
	
	
}
