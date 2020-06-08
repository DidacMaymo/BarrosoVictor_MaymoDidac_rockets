package com.rockets.app.aplication;

import com.rockets.app.application.dto.CircuitDTO;
import com.rockets.app.domain.Circuit;
import com.rockets.app.utilities.InvalidParamException;

public class CircuitController {
	
	public CircuitDTO createCircuit(CircuitDTO circuitdto) throws InvalidParamException {
		Circuit circuit = new Circuit(circuitdto);
		return new CircuitDTO(circuit);
	}

}
