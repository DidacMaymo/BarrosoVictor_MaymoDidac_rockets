package com.rockets.app.application.dto;

import com.rockets.app.domain.Propellant;
import com.rockets.app.utilities.InvalidParamException;


public class PropellantDTO {
	private Double maxAcceleration;
	public PropellantDTO(Double maxAcceleration) throws InvalidParamException {
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