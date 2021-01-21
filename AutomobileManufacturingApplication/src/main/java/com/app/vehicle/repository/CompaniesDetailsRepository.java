package com.app.vehicle.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.app.vehicle.entity.CompaniesDetails;

@Repository
public interface CompaniesDetailsRepository extends CrudRepository<CompaniesDetails, Integer>{
	
	Optional<CompaniesDetails> findByCompanyName(String companyName);
}
