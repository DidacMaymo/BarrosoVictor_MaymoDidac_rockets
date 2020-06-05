package com.rockets.app.application.dto;

import com.rockets.app.domain.FuelTank;
import com.rockets.app.utilities.InvalidParamException;

public class FuelTankDTO {

	private double capacity;
    private double actualFuel;
    
    
    public FuelTankDTO(double capacity) throws InvalidParamException {
    	if (capacity <= 0)
            throw new InvalidParamException();
        this.capacity = capacity;
        this.actualFuel = capacity;
    }
    
    public FuelTankDTO(FuelTank fuelTank) throws InvalidParamException {
    	if(fuelTank==null) throw new InvalidParamException();
    	this.capacity = fuelTank.getCapacity();
        this.actualFuel = fuelTank.getActualFuel();
    }

	public double getCapacity() throws InvalidParamException {
		if(capacity==0) throw new InvalidParamException();
		return capacity;
	}

	public double getActualFuel() throws InvalidParamException {
		if(actualFuel==0) throw new InvalidParamException();
		return actualFuel;
	}
}
