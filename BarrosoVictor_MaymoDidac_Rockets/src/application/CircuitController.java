package application;

import java.util.ArrayList;
import java.util.List;

import application.dto.CircuitDTO;
import domain.Circuit;
import utilities.InvalidParamException;

public class CircuitController {

	List<Circuit> circuit = new ArrayList<Circuit>();

	public CircuitDTO createCircuit(CircuitDTO circuitdto) throws InvalidParamException {
		Circuit circuit = new Circuit(circuitdto);
		this.circuit.add(circuit);
		return new CircuitDTO(circuit);
	}

	public Circuit getCircuit(CircuitDTO circuit) throws InvalidParamException {
		for (Circuit c : this.circuit) {
			if (circuit.getId().equals(c.getId())) {
				return c;
			}
		}
		throw new InvalidParamException();

	}

}