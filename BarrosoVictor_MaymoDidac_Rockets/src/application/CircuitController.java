package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import application.dto.CircuitDTO;
import application.dto.RocketDTO;
import domain.Circuit;
import domain.Rocket;
import utilities.InvalidParamException;

public class CircuitController {

	public static List<Circuit> circuitList;
	public static List<Rocket> rocketList;

	public CircuitDTO createCircuit(CircuitDTO circuitdto) throws InvalidParamException {
		if (circuitList == null) {
			circuitList = new ArrayList<Circuit>();
		}
		Circuit circuit = new Circuit(circuitdto);
		repeated(circuit);
		circuitList.add(new Circuit(circuitdto));
		return new CircuitDTO(circuit);
	}

	public Circuit getCircuit(CircuitDTO circuit) throws InvalidParamException {
		for (Circuit c : circuitList) {
			if (circuit.getId().equals(c.getId())) {
				return c;
			}
		}
		throw new InvalidParamException();
	}

	public CircuitDTO getRandomCircuit() throws InvalidParamException {
		return new CircuitDTO(circuitList.get((int) Math.floor(Math.random() * circuitList.size())));
	}

	private void repeated(Circuit circuit) throws InvalidParamException {
		Iterator<Circuit> it = circuitList.iterator();
		while (it.hasNext()) {
			if (circuit.equals(it.next()))
				throw new InvalidParamException();
		}
	}

	public void startRace() {

	}

	public ArrayList<RocketDTO> getRockets() {
		// TODO Auto-generated method stub
		return null;
	}

	public RocketDTO createRocket(RocketDTO rocketdto) throws InvalidParamException {
		if (rocketList == null) {
			rocketList = new ArrayList<Rocket>();
		}
		Rocket rocket = new Rocket(rocketdto);
		repeated(rocket);
		rocketList.add(rocket);
		return new RocketDTO(rocket);
	}

	private void repeated(Rocket rocket) throws InvalidParamException {
		Iterator<Rocket> it = rocketList.iterator();
		while (it.hasNext()) {
			if (rocket.equals(it.next()))
				throw new InvalidParamException();
		}
	}

	public Circuit getCircuit() {
		return circuitList.get(0);
	}

	public Rocket getRocket() {
		return rocketList.get(1);
	}
}