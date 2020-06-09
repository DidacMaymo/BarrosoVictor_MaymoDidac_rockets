package application;

import java.util.ArrayList;
import java.util.List;

import application.dto.RocketDTO;
import domain.Rocket;
import utilities.InvalidParamException;

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