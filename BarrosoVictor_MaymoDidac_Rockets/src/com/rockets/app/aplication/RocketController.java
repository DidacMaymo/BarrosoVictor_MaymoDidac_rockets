package com.rockets.app.aplication;

import com.rockets.app.application.dto.RocketDTO;
import com.rockets.app.domain.Rocket;
import com.rockets.app.utilities.InvalidParamException;

public class RocketController {

	
	public RocketDTO createCircuit(RocketDTO rocketdto) throws InvalidParamException {
		Rocket rocket = new Rocket(rocketdto);
		return new RocketDTO(rocket);
	}
}
