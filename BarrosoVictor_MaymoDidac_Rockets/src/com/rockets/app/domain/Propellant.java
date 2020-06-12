package com.rockets.app.domain;

import com.rockets.app.application.dto.PropellantDTO;
import com.rockets.app.utilities.InvalidParamException;

public class Propellant {

	private int maxAcceleration, actualAcceleration = 0;

	public Propellant() {

	}

	public Propellant(int maxAcceleration) throws Exception {
		validateAttributes(maxAcceleration);
		this.maxAcceleration = maxAcceleration;
	}

	public Propellant(PropellantDTO propellantdto) throws InvalidParamException {
		if (propellantdto == null)
			throw new InvalidParamException();
		this.actualAcceleration = 0;
		this.maxAcceleration = propellantdto.getMaxAcceleration();
	}

	public Propellant(Propellant propellant) {
		this.maxAcceleration = propellant.maxAcceleration;
		this.actualAcceleration = propellant.actualAcceleration;
	}

	private void validateAttributes(int maxAcceleration) throws Exception {
		if (maxAcceleration <= 0) {
			throw new Exception("Invalid attribute!");
		}
	}

	public int getMaxAcceleration() {
		return maxAcceleration;
	}

	public int getActualAcceleration() {
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
