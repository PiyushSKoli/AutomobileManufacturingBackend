package com.app.vehicle.repository;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.app.vehicle.entity.VehicleDetails;

@Repository
public interface VehicleRepository extends CrudRepository<VehicleDetails, Integer>{
	
	@Query("select distinct noOfWheels from VehicleDetails")
	List<Integer> findDistinctNoOfWheels();
	
	@Query("from VehicleDetails where noOfWheels=:noOfWheels")
	List<VehicleDetails> findByWheelsNumber(@Param("noOfWheels") Integer noOfWheels);
	
	List<VehicleDetails> findAllByOrderByNameAsc();
	
	@Query("from VehicleDetails where manufacturedDate between :startDate AND :endDate")
	List<VehicleDetails> findVehicleByDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	@Query("from VehicleDetails where companiesDetails.companyName=:companyName")
	List<VehicleDetails> findByCompanyName(String companyName);
}
