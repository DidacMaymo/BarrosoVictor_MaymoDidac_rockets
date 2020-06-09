package application.dto;

import domain.FuelTank;
import utilities.InvalidParamException;

public class FuelTankDTO {
	private double capacity;

	public FuelTankDTO(double capacity) throws Exception {
		this.capacity = capacity;
	}

	public FuelTankDTO(FuelTank fueltank) {
		this.capacity = fueltank.getCapacity();

	}

	public double getCapacity() throws InvalidParamException {
		if (capacity <= 0)
			throw new InvalidParamException();
		return capacity;
	}
}
