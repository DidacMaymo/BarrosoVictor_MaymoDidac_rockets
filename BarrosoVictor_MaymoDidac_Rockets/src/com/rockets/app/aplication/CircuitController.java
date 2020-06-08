package com.rockets.app.aplication;

import java.util.ArrayList;
import java.util.List;

import com.rockets.app.application.dto.CircuitDTO;
import com.rockets.app.domain.Circuit;
import com.rockets.app.utilities.InvalidParamException;

public class CircuitController {
	
	List<Circuit> circuit =  new ArrayList<Circuit>();
	
	public CircuitDTO createCircuit(CircuitDTO circuitdto) throws InvalidParamException {
		Circuit circuit = new Circuit(circuitdto);
		this.circuit.add(circuit);
		return new CircuitDTO(circuit);
	}
	public Circuit getCircuit(CircuitDTO circuit) throws InvalidParamException {
		for(Circuit c: this.circuit) {
			if(circuit.getId().equals(c.getId())) {
				return c;
			}
		} 
		throw new InvalidParamException();
		
	}
	

}
