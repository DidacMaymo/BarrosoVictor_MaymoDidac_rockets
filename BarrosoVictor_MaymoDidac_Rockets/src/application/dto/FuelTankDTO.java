package application.dto;

import domain.FuelTank;
import utilities.InvalidParamException;

public class FuelTankDTO {
	private double capacity;
	private double actualFuel;

	public FuelTankDTO(double capacity) throws Exception {
		this.capacity = capacity;
		this.actualFuel = 0;
	}

	public FuelTankDTO(FuelTank fueltank) {
		this.capacity = fueltank.getCapacity();
		this.actualFuel = fueltank.getActualFuel();

	}

	public double getCapacity() throws InvalidParamException {
		if (capacity <= 0)
			throw new InvalidParamException();
		return capacity;
	}

	public double getActualFuel() throws InvalidParamException {
		if (actualFuel < 0 || actualFuel > capacity) {
			throw new InvalidParamException();
		}
		return actualFuel;
	}

}
