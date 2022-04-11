package com.cgpack5.repository;




import java.util.List;


import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cgpack5.model.Station;
import com.cgpack5.model.Train;

@Repository
public interface TrainRepository  extends  JpaRepository<Train, Integer>{
	
	
	//public int updateTrainById(@Param("param1")double price, @Param("param2")int id)
	//public int updateTrainById(@Param("param1")double price, @Param("param2")int id);
	
	@Transactional
	@Modifying
	@Query("update Train t set t.trainPrice=:param1 where t.trainNumber=:param2")
	public int updateTrainById(double param1,int param2);
	
	@Query("select t from Train t where t.trainName=:p1")
	public Train getTrainByName(String p1);

	/*@Query("select t from Train t where t.source=:p1 and s.dest=:p2")
	public Train findbysrcanddes(String src, String dest);*/

	
@Query(value="select * from train_table t where t.train_source_station=?1 and t.train_destination_station=?2",nativeQuery = true)
	public Train srcanddest(String src, String dest);
	
	

}
