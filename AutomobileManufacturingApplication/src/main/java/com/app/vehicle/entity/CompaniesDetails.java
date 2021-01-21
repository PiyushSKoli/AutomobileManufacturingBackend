package com.app.vehicle.entity;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="companies_details")
public class CompaniesDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="company_id")
    private Integer companyId;
	
	@Column(name="company_name")
    private String companyName;
	
	@Column(name="created_by")
    private String createdBy;
	
	@Column(name="created_date")
    private Timestamp createdDate;
	
	@Column(name="updated_by")
    private String updatedBy;
	
	@Column(name="updated_date")
    private String updatedDate;
	
	@JsonIgnore
	@OneToMany(mappedBy="companiesDetails")
    private List<VehicleDetails> vehicleDetails;

	public Integer getCompanyId() {
		return companyId;
	}

	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

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

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Timestamp getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Timestamp createdDate) {
		this.createdDate = createdDate;
	}

	public String getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(String updatedBy) {
		this.updatedBy = updatedBy;
	}

	public String getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(String updatedDate) {
		this.updatedDate = updatedDate;
	}
}
