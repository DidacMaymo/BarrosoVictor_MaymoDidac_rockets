package view;

import java.util.ArrayList;
import java.util.List;

import application.CircuitController;
import application.RocketController;
import application.dto.CircuitDTO;
import application.dto.FuelTankDTO;
import application.dto.PropellantDTO;
import application.dto.RocketDTO;
import application.dto.ScoreDTO;
import domain.Circuit;
import domain.Rocket;
import domain.Score;
import utilities.InvalidParamException;

public class Main {

	public static CircuitController controllerCricuit = new CircuitController();
	public static RocketController controllerRoquet = new RocketController();

	public static void main(String[] args) throws Exception {
		ArrayList<RocketDTO> rockets = initialiseRockets();
		CircuitDTO circuit = new CircuitDTO("tutorialCircuit", 10, 800, rockets);
		startRace(circuit);
	}

	private static ArrayList<RocketDTO> initialiseRockets() throws Exception {
		double[] maxAccProplellant = { 18, 24, 38 };
		ArrayList<RocketDTO> rockets = new ArrayList<RocketDTO>();
		RocketDTO rocket = new RocketDTO("Star V", initialisePropellants(maxAccProplellant), new FuelTankDTO(1800));
		rocket = controllerRoquet.createRocket(rocket);
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

	public static void startRace(CircuitDTO circuitdto) throws Exception {
		for (RocketDTO rocketdto : circuitdto.getRocketsDTO()) {
			System.out.println("Starting competition. Circuit: " + circuitdto.getId() + ". Length: "
					+ circuitdto.getLength() + " . Max time: " + circuitdto.getMaxTime());
			Circuit circuit = controllerCricuit.getCircuit(circuitdto);
			Rocket rocket = controllerRoquet.getRocket(rocketdto);
			while (circuit.raceIsGoing(rocket)) {
				circuit.doingRace(rocket);
				circuitInfo(rocket, circuit);
			}
			printResult(circuit, rocket);
			circuit.resetTime();
		}
		printBestScore(circuitdto.getBestScore());
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

	private static void printBestScore(ScoreDTO score) throws InvalidParamException {
		System.out.println(
				"\nAnd the FINAL winner is: " + score.getRocketId() + " with a time of " + score.getTimeTaken());
	}

}