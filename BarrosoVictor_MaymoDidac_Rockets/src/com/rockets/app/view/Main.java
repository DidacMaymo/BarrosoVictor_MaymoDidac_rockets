package com.rockets.app.view;


import java.util.ArrayList;

import java.util.List;

import com.rockets.app.aplication.CircuitController;
import com.rockets.app.application.dto.CircuitDTO;
import com.rockets.app.application.dto.FuelTankDTO;
import com.rockets.app.application.dto.PropellantDTO;
import com.rockets.app.application.dto.RocketDTO;
import com.rockets.app.domain.Circuit;
import com.rockets.app.domain.FuelTank;
import com.rockets.app.domain.Propellant;
import com.rockets.app.domain.Rocket;
import com.rockets.app.domain.Score;

public class Main {
	
	public static CircuitController controller = new CircuitController();
	
	public static void main(String[] args) throws Exception {
		ArrayList<RocketDTO> rockets = initialiseRockets();
		CircuitDTO circuit = new CircuitDTO("tutorialCircuit", 10, 800, rockets);
		startRace(circuit);
	}

	private static ArrayList<RocketDTO> initialiseRockets() throws Exception { 
		double[] maxAccProplellant = { 18, 24, 38 };
		ArrayList<RocketDTO> rockets = new ArrayList<RocketDTO>();
		rockets.add(new RocketDTO("Falcon IX", initialisePropellants(new double[] { 50, 50, 60, 60 }), new FuelTankDTO(200000)));
		rockets.add(new RocketDTO("Star V", initialisePropellants(maxAccProplellant), new FuelTankDTO(1800)));
		return rockets;
	}

	private static List<PropellantDTO> initialisePropellants(double[] maxAccProplellant) throws Exception { // same
		List<PropellantDTO> propellants = new ArrayList<PropellantDTO>();
		for (double d : maxAccProplellant) {
			propellants.add(new Propellant(d));
		}
		return propellants;
	}

	public static void startRace(CircuitDTO circuit) throws Exception {
		for (Rocket rocket : circuit.getRocket()) {
			System.out.println("Starting competition. Circuit: " + circuit.getId() + ". Length: " + circuit.getLength()
					+ " . Max time: " + circuit.getMaxTime());
			while (circuit.raceIsGoing(rocket)) {
				circuit.doingRace(rocket);
				circuitInfo(rocket, circuit);
			}
			printResult(circuit, rocket);
			circuit.resetTime();
		}
		printBestScore(circuit.getScore());
	}

	private static void circuitInfo(Rocket rocket, Circuit circuit) {
		System.out.println("Current time: " + (circuit.getCurrentTime()) + " Acceleration: " + rocket.getAcceleration()
				+ " Speed: " + rocket.getSpeed() + " Distance: " + rocket.getMetersTravelled() + " Circuit: "
				+ circuit.getLength() + " Fuel: " + rocket.getActualFuel() + "/" + rocket.getFuelCapacity());
	}

	public static void printResult(Circuit circuit, Rocket rocket) throws Exception {
		if (circuit.isAWinner(rocket))
			win(rocket, circuit);
		else
			lose(rocket, circuit);
	}

	private static void win(Rocket rocket, Circuit circuit) throws Exception {
		System.out.println("The rocket: " + rocket.getId() + " with a time of " + circuit.getCurrentTime()
				+ " is winning the race!\n");
	}

	private static void lose(Rocket rocket, Circuit circuit) {
		System.out.println("The rocket: " + rocket.getId() + " is not a winner\n");
	}

	private static void printBestScore(Score score) {
		System.out.println("\nAnd the FINAL winner is: " + score.getRocket().getId() + " with a time of "
				+ score.getTimeTaken());
	}

}
