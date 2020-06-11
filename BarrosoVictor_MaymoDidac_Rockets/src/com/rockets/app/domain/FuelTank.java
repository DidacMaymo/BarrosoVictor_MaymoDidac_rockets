package com.rockets.app.domain;

import com.rockets.app.application.dto.FuelTankDTO;
import com.rockets.app.utilities.InvalidParamException;

public class FuelTank {

    private double capacity;
    private double actualFuel;
    
    public FuelTank(double capacity, double actualFuel) throws Exception {
    	validateAttributes(capacity,actualFuel);
        this.capacity = capacity;
        this.actualFuel = actualFuel;
    }
    
    private void validateAttributes(double capacity, double actualFuel) throws Exception {
    	 if (capacity <= 0) {
             throw new InvalidParamException();
         }
         if (actualFuel <= 0 || actualFuel > capacity)
             throw new InvalidParamException();

    }
    public FuelTank(FuelTank fuelTank) throws InvalidParamException {
        this.capacity = fuelTank.capacity;
        this.actualFuel = fuelTank.actualFuel;
        if (actualFuel <= 0)
            throw new InvalidParamException();
    }
    public FuelTank(FuelTankDTO fuelTankDTO) throws InvalidParamException {
    	this.capacity = fuelTankDTO.getCapacity();
        this.actualFuel = this.capacity;
    }
    
    public double getFuelConsumption(double speed){
        return 0.02 * Math.pow(speed, 2);
    }

    public double getCapacity() {
        return capacity;
    }
    
    public double getActualFuel() {
        return Math.round(actualFuel * 100.0) / 100.0;
    }

    public void updateFuel(double speed) throws Exception {
        actualFuel -= getFuelConsumption(speed);
        if (actualFuel <= 0) {
            actualFuel=0;
            throw new Exception();
        }
    }

}