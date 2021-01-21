package com.app.vehicle.dto;

import java.util.List;

import com.app.vehicle.entity.VehicleDetails;

public class VehicleRequestDto {

	private String companyName;
	
	private List<VehicleDetails> vehicleDetails;

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public List<VehicleDetails> getVehicleDetails() {
		return vehicleDetails;
	}

	public void setVehicleDetails(List<VehicleDetails> vehicleDetails) {
		this.vehicleDetails = vehicleDetails;
	}
}
