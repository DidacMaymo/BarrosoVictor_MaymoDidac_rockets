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
		if (repeated(circuit))
			throw new InvalidParamException();
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

	private boolean repeated(Circuit circuit) {
		Iterator<Circuit> it = circuitList.iterator();
		while (it.hasNext()) {
			if (circuit.equals(it.next()))
				return true;
		}
		return false;
	}

	public void startRace() {

	}

	public ArrayList<RocketDTO> getRockets() {
		// TODO Auto-generated method stub
		return null;
	}
}