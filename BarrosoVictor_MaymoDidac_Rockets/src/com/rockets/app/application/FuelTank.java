package com.rockets.app.application;

public class FuelTank {

    private double capacity;
    private double actualFuel;

    public FuelTank(double capacity) throws Exception {
        validateAttributes(capacity);
        this.capacity = capacity;
        this.actualFuel = capacity;
    }

    private void validateAttributes(double capacity) throws Exception {
        if (capacity <= 0)
            throw new Exception("Invalid attribute!");

    }

    public double getFuelConsumption(double speed) throws Exception {
    	if(speed==0)throw new Exception();
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
        if (actualFuel < 0)
            throw new Exception("No fuel remainng!");
    }

}