package application.dto;

import domain.Propellant;
import utilities.InvalidParamException;

public class PropellantDTO {
	private double maxAcceleration;

	public PropellantDTO(double maxAcceleration) throws InvalidParamException {

		this.maxAcceleration = maxAcceleration;

	}

	public PropellantDTO(Propellant propellant) {
		this.maxAcceleration = propellant.getMaxAcceleration();
	}

	public double getMaxAcceleration() throws InvalidParamException {
		if (maxAcceleration <= 0) {
			throw new InvalidParamException();
		}
		return maxAcceleration;
	}

}
