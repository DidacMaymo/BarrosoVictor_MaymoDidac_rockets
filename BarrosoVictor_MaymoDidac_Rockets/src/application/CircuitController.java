package application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

import application.dto.CircuitDTO;
import domain.Circuit;
import utilities.InvalidParamException;

public class CircuitController {

	private static List<Circuit> circuitList;

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

	private boolean repeated(Circuit circuit) {
		Iterator<Circuit> it = circuitList.iterator();
		while (it.hasNext()) {
			if (circuit.equals(it.next()))
				return true;
		}
		return false;
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

}