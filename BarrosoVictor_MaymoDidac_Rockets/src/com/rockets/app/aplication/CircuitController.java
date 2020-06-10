package com.rockets.app.aplication;

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
	
	static Circuit currentCircuit;

	static List<Rocket> rocket = new ArrayList<Rocket>();
	
	String info;

	 public CircuitDTO getRandomCircuit() throws InvalidParamException {
	        return new CircuitDTO(circuitList.get((int) Math.floor(Math.random() * circuitList.size())));
	 }
	 
	public CircuitDTO createCircuit(CircuitDTO circuitdto) throws InvalidParamException {
        if (circuitList == null) {
            circuitList = new ArrayList<Circuit>();
        }
        currentCircuit = new Circuit(circuitdto);
        if (repeated(currentCircuit))
            throw new InvalidParamException();
        circuitList.add(new Circuit(circuitdto));
        return new CircuitDTO(currentCircuit);
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
		currentCircuit.startRace();
	}

	public Circuit getCircuit(CircuitDTO circuit) throws InvalidParamException {
		for (Circuit c : this.circuitList) {
			if (circuit.getId().equals(c.getId())) {
				return c;
			}
		}
		throw new InvalidParamException();
	}


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

	

	public static void printResult(Circuit circuit, Rocket rocket) throws Exception {
		if (circuit.isAWinner(rocket))
			win(rocket, circuit.getCurrentTime());
		else
			lose(rocket);
	}

	

	

	
	


	
}
