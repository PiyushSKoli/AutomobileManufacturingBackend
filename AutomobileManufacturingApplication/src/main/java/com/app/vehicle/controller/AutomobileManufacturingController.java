package com.app.vehicle.controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.app.vehicle.dto.ResultModel;
import com.app.vehicle.dto.VehicalCategoryResponseDto;
import com.app.vehicle.dto.VehicleRequestDto;
import com.app.vehicle.entity.VehicleDetails;
import com.app.vehicle.service.AutomobileManufacturingService;

@RestController
@RequestMapping(value="/AutomobileInfo")
public class AutomobileManufacturingController {

	@Autowired
	private AutomobileManufacturingService automobileManufacturingService;
	
	@RequestMapping(value = "/saveListOfVehiclesUnderBrand", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> saveListOfVehiclesUnderBrand(@RequestBody List<VehicleRequestDto> vehicleRequestDtoList) {
		ResultModel resultModel = new ResultModel();
		try {
			List<VehicleDetails> response = automobileManufacturingService.saveListOfVehiclesUnderBrand(vehicleRequestDtoList);
			resultModel.setData(response);
			resultModel.setMessage("Success");
		} catch (Exception e) {
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<ResultModel>(resultModel, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/getVehicalsDetailsByCategory", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getVehicalsDetailsByCategory() {
		ResultModel resultModel = new ResultModel();
		try {
			List<VehicalCategoryResponseDto> response = automobileManufacturingService.getVehicalsDetailsByCategory();
			resultModel.setData(response);
			resultModel.setMessage("Success");
		} catch (Exception e) {
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getVehicleDetailsByAscOrderByName", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getVehicleDetailsByAscOrderByName() {
		ResultModel resultModel = new ResultModel();
		try {
			List<VehicleDetails> response = automobileManufacturingService.getVehicleDetailsByAscOrderByName();
			resultModel.setData(response);
			resultModel.setMessage("Success");
		} catch (Exception e) {
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@GetMapping(value = "/getVehicleSortByNameAndMaxSpeed", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getVehicleSortByNameAndMaxSpeed() {
		ResultModel resultModel = new ResultModel();
		try {
			List<VehicleDetails> response = automobileManufacturingService.getVehicleSortByNameAndMaxSpeed();
			resultModel.setData(response);
			resultModel.setMessage("Success");
		} catch (Exception e) {
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getVehicleDetailsByDateRange/{startDate}/{endDate}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getVehicleDetailsByDateRange(@PathVariable("startDate") Date startDate, @PathVariable("endDate") Date endDate) {
		ResultModel resultModel = new ResultModel();
		try {
			List<VehicleDetails> response = automobileManufacturingService.getVehicleDetailsByDateRange(startDate,endDate);
			resultModel.setData(response);
			resultModel.setMessage("Success");
		} catch (Exception e) {
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}	
	
	@RequestMapping(value = "/getVehicleDetailsByCompanyName/{companyName}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ResultModel> getVehicleDetailsByCompanyName(@PathVariable("companyName") String companyName) {
		ResultModel resultModel = new ResultModel();
		try {
			List<VehicleDetails> response = automobileManufacturingService.getVehicleDetailsByCompanyName(companyName);
			resultModel.setData(response);
			resultModel.setMessage("Success");
		} catch (Exception e) {
			resultModel.setMessage("Error");
			return new ResponseEntity<ResultModel>(resultModel, HttpStatus.UNPROCESSABLE_ENTITY);
		}
		return new ResponseEntity<ResultModel>(resultModel, HttpStatus.OK);
	}
}
