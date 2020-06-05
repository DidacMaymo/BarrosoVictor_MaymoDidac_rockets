package com.rockets.app.application.dto;

import com.rockets.app.domain.Propellant;
import com.rockets.app.utilities.InvalidParamException;

public class PropellantDTO {
	private double maxAcceleration, actualAcceleration = 0;
	
	public PropellantDTO(double maxAcceleration) throws Exception {
        validateAttributes(maxAcceleration);
        this.maxAcceleration = maxAcceleration;
    }
	private void validateAttributes(double maxAcceleration) throws InvalidParamException {
        if (maxAcceleration <= 0) {
        	throw new InvalidParamException();
        }
    }
	public PropellantDTO(Propellant propellant) throws InvalidParamException {
		if(propellant==null) throw new InvalidParamException();
		this.actualAcceleration=propellant.getActualAcceleration();
		this.maxAcceleration=propellant.getMaxAcceleration();
	}
	public double getMaxAcceleration() throws InvalidParamException {
		if(maxAcceleration==0) throw new InvalidParamException();
		return maxAcceleration;
	}
	public double getActualAcceleration() throws InvalidParamException {
		if(actualAcceleration==0) throw new InvalidParamException();
		return actualAcceleration;
	}
}
