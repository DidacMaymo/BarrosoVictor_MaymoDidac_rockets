package com.rockets.app.domain;

import com.rockets.app.application.dto.PropellantDTO;
import com.rockets.app.utilities.InvalidParamException;

public class Propellant {

	private double maxAcceleration, actualAcceleration = 0;
	
	public Propellant() {
		
	}

	public Propellant(double maxAcceleration) throws Exception {
        validateAttributes(maxAcceleration);
        this.maxAcceleration = maxAcceleration;
    }
	
	public Propellant(PropellantDTO propellantdto) throws InvalidParamException {
		if(propellantdto==null)throw new InvalidParamException();
		this.actualAcceleration=propellantdto.getActualAcceleration();
		this.maxAcceleration=propellantdto.getMaxAcceleration();
	}

    private void validateAttributes(double maxAcceleration) throws Exception {
        if (maxAcceleration <= 0) {
        	throw new Exception("Invalid attribute!");
        }
    }
	public Double getMaxAcceleration() {
		return maxAcceleration;
	}

	public Double getActualAcceleration() {
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
