package com.rockets.app.application.dto;

import com.rockets.app.domain.FuelTank;
import com.rockets.app.utilities.InvalidParamException;

public class FuelTankDTO {

	private double capacity;
    
    
    public FuelTankDTO(double capacity) throws InvalidParamException {
        this.capacity = capacity;
    }
    
    public FuelTankDTO(FuelTank fuelTank) {
    	this.capacity = fuelTank.getCapacity();
    }

	public double getCapacity() throws InvalidParamException {
		if(capacity<=0) throw new InvalidParamException();
		return capacity;
	}
}
