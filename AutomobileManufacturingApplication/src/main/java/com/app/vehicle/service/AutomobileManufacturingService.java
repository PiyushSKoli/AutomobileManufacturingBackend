package com.app.vehicle.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.app.vehicle.dto.VehicalCategoryDto;
import com.app.vehicle.dto.VehicalCategoryResponseDto;
import com.app.vehicle.dto.VehicleRequestDto;
import com.app.vehicle.entity.CompaniesDetails;
import com.app.vehicle.entity.VehicleDetails;
import com.app.vehicle.repository.CompaniesDetailsRepository;
import com.app.vehicle.repository.VehicleRepository;

@Transactional
@Service
public class AutomobileManufacturingService {

	@Autowired
	private CompaniesDetailsRepository companyInfoRepository;
	
	@Autowired
	private VehicleRepository vehicleRepository;
	
	public List<VehicleDetails> saveListOfVehiclesUnderBrand(List<VehicleRequestDto> requestDtoList){
		List<VehicleDetails> vehicleArrayList = new ArrayList<VehicleDetails>();
		
		for(VehicleRequestDto vehicleRequest: requestDtoList) {
			Optional<CompaniesDetails> companiesDetails = companyInfoRepository.findByCompanyName(vehicleRequest.getCompanyName());
			if(companiesDetails.isPresent()) {
				for(VehicleDetails vehicle : vehicleRequest.getVehicleDetails()) {
					vehicle.setCompaniesDetails(companiesDetails.get());
					VehicleDetails vehicleData = vehicleRepository.save(vehicle);
					vehicleArrayList.add(vehicleData);
				}
			}else {
				CompaniesDetails companies = new CompaniesDetails();
				companies.setCompanyName(vehicleRequest.getCompanyName());
				CompaniesDetails companyInfoData =companyInfoRepository.save(companies);
				for(VehicleDetails vehicle : vehicleRequest.getVehicleDetails()) {
					vehicle.setCompaniesDetails(companyInfoData);
					VehicleDetails vehicleData = vehicleRepository.save(vehicle);
					vehicleArrayList.add(vehicleData);
				}
			}
		}
		return vehicleArrayList;		
	}
	
	public List<VehicalCategoryResponseDto> getVehicalsDetailsByCategory(){
		List<VehicalCategoryResponseDto> vehicalCategoryResponseDtoList=new ArrayList<VehicalCategoryResponseDto>();
		List<Integer> noOfWheels = vehicleRepository.findDistinctNoOfWheels();
		
		for (Integer wheel : noOfWheels) {
			VehicalCategoryResponseDto vehicalCategoryResponseDto=new VehicalCategoryResponseDto();
			vehicalCategoryResponseDto.setCategory(wheel+"-wheeler");
			List<VehicleDetails> vehicleDetails = vehicleRepository.findByWheelsNumber(wheel);
			List<VehicalCategoryDto> vehicalCategoryDtoList=new ArrayList<VehicalCategoryDto>();
			vehicleDetails.forEach((v)->{
				VehicalCategoryDto vehicalCategoryDto=new VehicalCategoryDto();
				vehicalCategoryDto.setCompanyName(v.getCompaniesDetails().getCompanyName());
				vehicalCategoryDto.setName(v.getName());
				vehicalCategoryDto.setModelNo(v.getModelNo());
				vehicalCategoryDtoList.add(vehicalCategoryDto);
			});
			vehicalCategoryResponseDto.setVehicalCategoryDto(vehicalCategoryDtoList);	
			vehicalCategoryResponseDtoList.add(vehicalCategoryResponseDto);
		}
		return vehicalCategoryResponseDtoList;
	}
	
	public List<VehicleDetails> getVehicleDetailsByAscOrderByName(){
		return vehicleRepository.findAllByOrderByNameAsc();
	}
	
	public List<VehicleDetails> getVehicleSortByNameAndMaxSpeed(){
		List<VehicleDetails> vehicleList = (List<VehicleDetails>) vehicleRepository.findAll(); 
		Comparator<VehicleDetails> compareByNameAndMaxSpeed = Comparator.comparing(VehicleDetails::getName).thenComparing(VehicleDetails::getMaxSpeed);
		List<VehicleDetails> sortedVehicleList = vehicleList.stream().sorted(compareByNameAndMaxSpeed).collect(Collectors.toList());
		return sortedVehicleList;	
	}
	
	public List<VehicleDetails> getVehicleDetailsByDateRange(Date startDate, Date endDate){
		return vehicleRepository.findVehicleByDate(startDate,endDate);
	}
	
	public List<VehicleDetails> getVehicleDetailsByCompanyName(String companyName){
		return vehicleRepository.findByCompanyName(companyName);
	}	
		
}
