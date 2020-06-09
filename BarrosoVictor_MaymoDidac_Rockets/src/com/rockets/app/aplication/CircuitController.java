package com.rockets.app.aplication;

import java.util.ArrayList;
import java.util.List;

import com.rockets.app.application.dto.CircuitDTO;
import com.rockets.app.application.dto.RocketDTO;
import com.rockets.app.domain.Circuit;
import com.rockets.app.domain.Rocket;
import com.rockets.app.utilities.IObserver;
import com.rockets.app.utilities.ISubject;
import com.rockets.app.utilities.InvalidParamException;

public class CircuitController implements ISubject {
	private ArrayList<IObserver> observers = new ArrayList<IObserver>();

	static List<Circuit> circuitList = new ArrayList<Circuit>();
	
	String info;

	 public CircuitDTO getRandomCircuit() throws InvalidParamException {
	        return new CircuitDTO(circuitList.get((int) Math.floor(Math.random() * circuitList.size())));
	 }
	
	public CircuitDTO createCircuit(CircuitDTO circuitdto) throws InvalidParamException {
		Circuit circuit = new Circuit(circuitdto);
		this.circuitList.add(circuit);
		return new CircuitDTO(circuit);
	}

	public Circuit getCircuit(CircuitDTO circuit) throws InvalidParamException {
		for (Circuit c : this.circuitList) {
			if (circuit.getId().equals(c.getId())) {
				return c;
			}
		}
		throw new InvalidParamException();
	}

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

	public String startRace() {
		Circuit circuit = getCircuit(getRandomCircuit());
		for (Rocket rocket : rocket) {
			notiffy();
			while (circuit.raceIsGoing(rocket)) {
				circuit.doingRace(rocket);
				info = ("Current time: " + (circuit.getCurrentTime()) + " Acceleration: "
						+ rocket.getAcceleration() + " Speed: " + rocket.getSpeed() + " Distance: "
						+ rocket.getMetersTravelled() + " Circuit: " + circuit.getLength() + " Fuel: "
						+ rocket.getActualFuel() + "/" + rocket.getFuelCapacity());
				circuitInfo(info);
			}
			printResult(circuit, rocket);
			circuit.resetTime();
		}
		printBestScore(circuitdto.getBestScore());
	}

	public static void printResult(Circuit circuit, Rocket rocket) throws Exception {
		if (circuit.isAWinner(rocket))
			win(rocket, circuit.getCurrentTime());
		else
			lose(rocket);
	}

	public void mixObserver(IObserver o) {
		observers.add(o);
	}

	@Override
	public void notiffy() {
		for (IObserver o : observers) {
			o.update();
		}
	}
}
