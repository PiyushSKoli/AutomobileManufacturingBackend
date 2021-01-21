package com.app.vehicle.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="vehicle_details")
public class VehicleDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="vehicle_id")
    private Integer vehicleId;
	
	@Column(name="name")
    private String name;
	
	@Column(name="model_no")
    private String modelNo;
	
	@Column(name="manufactured_date")
    private Date manufacturedDate;
	
	@Column(name="no_of_wheels")
    private Integer noOfWheels;
	
	@Column(name="torque")
    private String torque;
	
	@Column(name="brake_horse_power")
    private String brakeHorsePower;
	
	@Column(name="max_speed")
    private Integer maxSpeed;
	
	@Column(name="max_acceleration")
    private Integer maxAcceleration;
	
	@Column(name="run")
    private String run;
	
	@ManyToOne
	@JoinColumn(name="role_id")
	private VehicleRole vehicleRole;
	
	@ManyToOne
	@JoinColumn(name="company_id")
	private CompaniesDetails companiesDetails;

	public Integer getVehicleId() {
		return vehicleId;
	}

	public void setVehicleId(Integer vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getModelNo() {
		return modelNo;
	}

	public void setModelNo(String modelNo) {
		this.modelNo = modelNo;
	}

	public Date getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(Date manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	public Integer getNoOfWheels() {
		return noOfWheels;
	}

	public void setNoOfWheels(Integer noOfWheels) {
		this.noOfWheels = noOfWheels;
	}

	public String getTorque() {
		return torque;
	}

	public void setTorque(String torque) {
		this.torque = torque;
	}

	public String getBrakeHorsePower() {
		return brakeHorsePower;
	}

	public void setBrakeHorsePower(String brakeHorsePower) {
		this.brakeHorsePower = brakeHorsePower;
	}

	public Integer getMaxSpeed() {
		return maxSpeed;
	}

	public void setMaxSpeed(Integer maxSpeed) {
		this.maxSpeed = maxSpeed;
	}

	public Integer getMaxAcceleration() {
		return maxAcceleration;
	}

	public void setMaxAcceleration(Integer maxAcceleration) {
		this.maxAcceleration = maxAcceleration;
	}

	public String getRun() {
		return run;
	}

	public void setRun(String run) {
		this.run = run;
	}

	public VehicleRole getVehicleRole() {
		return vehicleRole;
	}

	public void setVehicleRole(VehicleRole vehicleRole) {
		this.vehicleRole = vehicleRole;
	}

	public CompaniesDetails getCompaniesDetails() {
		return companiesDetails;
	}

	public void setCompaniesDetails(CompaniesDetails companiesDetails) {
		this.companiesDetails = companiesDetails;
	}
}
