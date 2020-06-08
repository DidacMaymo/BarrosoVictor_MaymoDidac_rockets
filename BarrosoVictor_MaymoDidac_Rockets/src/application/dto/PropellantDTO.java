package application.dto;

import domain.Propellant;
import utilities.InvalidParamException;

public class PropellantDTO {
	private double maxAcceleration;
	private double actualAcceleration;

	public PropellantDTO(double maxAcceleration) throws InvalidParamException {

		this.maxAcceleration = maxAcceleration;
		this.actualAcceleration = 0;

	}

	public PropellantDTO(Propellant propellant) {
		this.maxAcceleration = propellant.getMaxAcceleration();
		this.actualAcceleration = propellant.getActualAcceleration();
	}

	public double getMaxAcceleration() throws InvalidParamException {
		if (maxAcceleration <= 0) {
			throw new InvalidParamException();
		}
		return maxAcceleration;
	}

	public double getActualAcceleration() throws InvalidParamException {
		if (actualAcceleration < 0 || actualAcceleration > maxAcceleration) {
			throw new InvalidParamException();
		}
		return actualAcceleration;
	}

}
