package domain;

import application.dto.PropellantDTO;
import utilities.InvalidParamException;

public class Propellant {

	private int maxAcceleration, actualAcceleration;

	public Propellant(int maxAcceleration, int actualAcceleration) throws InvalidParamException {
		if (maxAcceleration <= 0) {
			throw new InvalidParamException();
		}
		this.maxAcceleration = maxAcceleration;
		this.actualAcceleration = actualAcceleration;
	}

	public Propellant(PropellantDTO propellantDTO) throws InvalidParamException {
		this.maxAcceleration = propellantDTO.getMaxAcceleration();
	}

	public Propellant(Propellant propellant) {
		this.maxAcceleration = propellant.maxAcceleration;
		this.actualAcceleration = propellant.actualAcceleration;
	}

	public int getMaxAcceleration() {
		return maxAcceleration;
	}

	public double getActualAcceleration() {
		return actualAcceleration;
	}

	public void setActualAcceleration(int newAcceleration) {
		if (newAcceleration < 0)
			newAcceleration = 0;
		else if (newAcceleration > maxAcceleration)
			newAcceleration = maxAcceleration;
		this.actualAcceleration = newAcceleration;
	}
}
