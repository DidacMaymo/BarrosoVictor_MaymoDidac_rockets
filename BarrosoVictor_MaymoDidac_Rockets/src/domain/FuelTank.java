package domain;

import application.dto.FuelTankDTO;
import utilities.InvalidParamException;

public class FuelTank {

	private double capacity;
	private double actualFuel;

	public FuelTank(double capacity, double actualFuel) throws InvalidParamException {
		if (capacity <= 0) {
			throw new InvalidParamException();
		}
		if (actualFuel <= 0 || actualFuel > capacity)
			throw new InvalidParamException();
		this.capacity = capacity;
		this.actualFuel = actualFuel;
	}

	public FuelTank(FuelTankDTO fuelTankDTO) throws InvalidParamException {
		this.capacity = fuelTankDTO.getCapacity();
		this.actualFuel = fuelTankDTO.getActualFuel();
	}

	public double getFuelConsumption(double speed) {
		return 0.02 * Math.pow(speed, 2);
	}

	public double getCapacity() {
		return capacity;
	}

	public double getActualFuel() {
		return actualFuel;
	}

	public void updateFuel(double speed) throws Exception {
		actualFuel -= getFuelConsumption(speed);
		if (actualFuel < 0)
			throw new Exception("No fuel remainng!");
	}

}
