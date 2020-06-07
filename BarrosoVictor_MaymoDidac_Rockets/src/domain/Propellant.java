package domain;

import application.dto.PropellantDTO;
import utilities.InvalidParamException;

public class Propellant {

	private double maxAcceleration, actualAcceleration = 0;

	public Propellant(double maxAcceleration) throws InvalidParamException {
		if (maxAcceleration <= 0) {
			throw new InvalidParamException();
		}
		this.maxAcceleration = maxAcceleration;
	}

	public Propellant(PropellantDTO propellantDTO) throws InvalidParamException {
		this.maxAcceleration = propellantDTO.getMaxAcceleration();
	}

	public double getMaxAcceleration() {
		return maxAcceleration;
	}

	public double getActualAcceleration() {
		return actualAcceleration;
	}

	public void setActualAcceleration(double newAcceleration) {
		if (newAcceleration < 0)
			newAcceleration = 0;
		else if (newAcceleration > maxAcceleration)
			newAcceleration = maxAcceleration;
		this.actualAcceleration = newAcceleration;
	}
}
