package com.app.vehicle.dto;

import java.util.List;

public class VehicalCategoryResponseDto {

	private String category;
	
	private List<VehicalCategoryDto> vehicalCategoryDto;

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public List<VehicalCategoryDto> getVehicalCategoryDto() {
		return vehicalCategoryDto;
	}

	public void setVehicalCategoryDto(List<VehicalCategoryDto> vehicalCategoryDto) {
		this.vehicalCategoryDto = vehicalCategoryDto;
	}
	
}
