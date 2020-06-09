package com.rockets.app.view;

import java.util.ArrayList;

import java.util.List;

import com.rockets.app.aplication.CircuitController;
import com.rockets.app.application.dto.CircuitDTO;
import com.rockets.app.application.dto.FuelTankDTO;
import com.rockets.app.application.dto.PropellantDTO;
import com.rockets.app.application.dto.RocketDTO;
import com.rockets.app.application.dto.ScoreDTO;
import com.rockets.app.utilities.IObserver;
import com.rockets.app.utilities.InvalidParamException;

public class Main implements IObserver {

	public static CircuitController controller = new CircuitController();

	public static void main(String[] args) throws Exception {
		createCircuits(createRockets());
		controller.startRace();
	}

	private static void createCircuits(ArrayList<RocketDTO> rocketsDTO) throws InvalidParamException {
		controller.createCircuit(new CircuitDTO("MadMax", 22, 1300));
		controller.createCircuit(new CircuitDTO("SpeedTrack", 10, 800));
		controller.createCircuit(new CircuitDTO("RisingLap", 15, 900));
		controller.createCircuit(new CircuitDTO("FreeWorld", 18, 1200));
	}

	private static ArrayList<RocketDTO> createRockets() throws InvalidParamException, Exception {
		ArrayList<RocketDTO> rocketsDTO = new ArrayList<>();
		rocketsDTO.add(
				new RocketDTO("Viper X", initialisePropellants(getPropellantAcceleration(0)), new FuelTankDTO(2500)));
		rocketsDTO.add(
				new RocketDTO("Star V", initialisePropellants(getPropellantAcceleration(1)), new FuelTankDTO(2800)));
		rocketsDTO.add(
				new RocketDTO("Falcon IX", initialisePropellants(getPropellantAcceleration(2)), new FuelTankDTO(1900)));
		rocketsDTO.add(
				new RocketDTO("Speedy X", initialisePropellants(getPropellantAcceleration(3)), new FuelTankDTO(2200)));
		return rocketsDTO;
	}

	private static double[] getPropellantAcceleration(int numberOfRocket) {
		switch (numberOfRocket) {
		case 0:
			double[] rocketOnePropellants = { 40, 50, 20, 38 };
			return rocketOnePropellants;
		case 1:
			double[] rocketTwoPropellants = { 30, 18, 24, 38 };
			return rocketTwoPropellants;
		case 2:
			double[] rocketThreePropellants = { 40, 29, 60 };
			return rocketThreePropellants;
		default:
			double[] rocketFourPropellants = { 10, 3, 20, 82 };
			return rocketFourPropellants;
		}
	}

	private static ArrayList<PropellantDTO> initialisePropellants(double[] maxAccProplellant)
			throws Exception {
		ArrayList<PropellantDTO> propellants = new ArrayList<PropellantDTO>();
		for (double d : maxAccProplellant) {
			propellants.add(new PropellantDTO(d));
		}
		return propellants;
	}

	private static void circuitInfo(String info) {
		System.out.println(info);
	}

	// en els prints hem de usar els dtos
	private static void win(RocketDTO rocket, double currentTime) throws Exception {
		System.out.println(
				"The rocket: " + rocket.getId() + " with a time of " + currentTime + " is winning the race!\n");
	}

	private static void lose(RocketDTO rocket) throws InvalidParamException {
		System.out.println("The rocket: " + rocket.getId() + " is not a winner\n");
	}

	private static void printBestScore(ScoreDTO score) throws InvalidParamException {
		System.out.println(
				"\nAnd the FINAL winner is: " + score.getRocket().getId() + " with a time of " + score.getTimeTaken());
	}

	@Override
	public void update() {
		System.out.println("Starting competition. Circuit: " + circuitdto.getId() + ". Length: "
				+ circuitdto.getLength() + " . Max time: " + circuit.getMaxTime());
	}
}
