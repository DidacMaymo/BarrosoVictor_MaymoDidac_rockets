package com.rockets.app.application;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rockets.app.application.dto.CircuitDTO;
import com.rockets.app.application.dto.RocketDTO;
import com.rockets.app.domain.Circuit;
import com.rockets.app.domain.Rocket;
import com.rockets.app.utilities.IObserver;
import com.rockets.app.utilities.ISubject;
import com.rockets.app.utilities.InvalidParamException;

public class CircuitController {

	private ArrayList<IObserver> observers = new ArrayList<IObserver>();
	static List<Circuit> circuitList = new ArrayList<Circuit>();
	static List<Rocket> rocketList = new ArrayList<Rocket>();
	static Circuit currentCircuit;
	static Rocket rocket;
	String info;

	

	public CircuitDTO createCircuit(CircuitDTO circuitdto) throws InvalidParamException {
		if (circuitList == null) {
			circuitList = new ArrayList<Circuit>();
		}
		currentCircuit = new Circuit(circuitdto);
		if (repeated(currentCircuit))
			throw new InvalidParamException();
		circuitList.add(currentCircuit);
		return new CircuitDTO(currentCircuit);
	}

	public Circuit getCircuit(CircuitDTO circuit) throws InvalidParamException {
		for (Circuit c : CircuitController.circuitList) {
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
	

	public RocketDTO createRocket(RocketDTO rocketdto) throws InvalidParamException {
        if (rocketList == null) {
            rocketList = new ArrayList<Rocket>();
        }
        rocket = new Rocket(rocketdto);
        repeated(rocket);
        rocketList.add(rocket);
        System.out.println(rocket.getMaxAcceleration());
        return new RocketDTO(rocket);
    }

	public  Rocket getRocket(RocketDTO rocketdto) throws InvalidParamException {
		for (Rocket c : CircuitController.rocketList) {
			if (rocketdto.getId().equals(c.getId())) {
				return c;
			}
		}
		throw new InvalidParamException();
	}
	
	private void repeated(Rocket rocket) throws InvalidParamException {
        Iterator<Rocket> it = rocketList.iterator();
        while (it.hasNext()) {
            if (rocket.equals(it.next()))
                throw new InvalidParamException();
        }
    }

	public void startRace() throws Exception {
		for (Rocket rockett : rocketList) {
			currentCircuit.startRace(rockett);
		}
	}
	

	public void addObserver(IObserver iObserver) throws InvalidParamException {
		currentCircuit.addObserver(iObserver);

	}

}
