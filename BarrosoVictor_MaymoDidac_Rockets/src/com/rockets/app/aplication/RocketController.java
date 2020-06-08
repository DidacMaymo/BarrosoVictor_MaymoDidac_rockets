package com.rockets.app.aplication;

import java.util.ArrayList;

import java.util.List;

import com.rockets.app.application.dto.RocketDTO;
import com.rockets.app.domain.Circuit;
import com.rockets.app.domain.Rocket;
import com.rockets.app.utilities.InvalidParamException;

public class RocketController {

	List<Rocket> rocket = new ArrayList<Rocket>();

	public RocketDTO createRocket(RocketDTO rocketdto) throws InvalidParamException {
		Rocket rocket = new Rocket(rocketdto);
		this.rocket.add(rocket);
		return new RocketDTO(rocket);
	}

	public Rocket getRocket(RocketDTO rocketdto) throws InvalidParamException {
		for (Rocket c : this.rocket) {
			if (rocketdto.getId().equals(c.getId())) {
				return c;
			}
		}
		throw new InvalidParamException();

	}
}
