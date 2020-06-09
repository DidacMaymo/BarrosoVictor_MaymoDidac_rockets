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

public class Main implements IObserver{
	
	public static CircuitController controller = new CircuitController();
	
	public static void main(String[] args) throws Exception {
		ArrayList<RocketDTO> rockets = initialiseRockets();
		CircuitDTO circuit = new CircuitDTO("tutorialCircuit", 10, 800, rockets);//POSAR LES DADES BONES
		controller.startRace(circuit);
	}
	
	private static ArrayList<RocketDTO> initialiseRockets() throws Exception { 
		double[] maxAccProplellant = { 18, 24, 38 };
		ArrayList<RocketDTO> rockets = new ArrayList<RocketDTO>();
		RocketDTO rocket = new RocketDTO("Star V", initialisePropellants(maxAccProplellant), new FuelTankDTO(1800));
		rocket = controller.createRocket(rocket);
		rockets.add(rocket);
		return rockets;
	}

	private static List<PropellantDTO> initialisePropellants(double[] maxAccProplellant) throws Exception { // same
		List<PropellantDTO> propellants = new ArrayList<PropellantDTO>();
		for (double d : maxAccProplellant) {
			propellants.add(new PropellantDTO(d));
		}
		return propellants;
	}
	
	private static void circuitInfo(String info) {
		System.out.println(info);
	}
	
	//en els prints hem de usar els dtos
	private static void win(RocketDTO rocket, double currentTime) throws Exception {
		System.out.println("The rocket: " + rocket.getId() + " with a time of " + currentTime
				+ " is winning the race!\n");
	}

	private static void lose(RocketDTO rocket) throws InvalidParamException {
		System.out.println("The rocket: " + rocket.getId() + " is not a winner\n");
	}

	private static void printBestScore(ScoreDTO score) throws InvalidParamException {
		System.out.println("\nAnd the FINAL winner is: " + score.getRocket().getId() + " with a time of "
				+ score.getTimeTaken());
	}

	@Override
	public void update() {
		System.out.println("Starting competition. Circuit: " + circuitdto.getId() + ". Length: " + circuitdto.getLength()
		+ " . Max time: " + circuit.getMaxTime());
	}

	

}
