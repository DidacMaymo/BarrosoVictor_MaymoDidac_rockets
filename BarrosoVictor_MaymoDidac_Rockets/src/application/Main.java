package application;

import java.util.ArrayList;

import java.util.List;
import domain.Circuit;
import domain.FuelTank;
import domain.Propellant;
import domain.Rocket;
import domain.Score;

public class Main {

	public static void main(String[] args) throws Exception {

		ArrayList<Rocket> rockets = initialiseRockets();
		Circuit circuit = new Circuit("tutorialCircuit", 10, 800, rockets);
		startRace(circuit);
	}

	private static ArrayList<Rocket> initialiseRockets() throws Exception { // iniciem el rocket que fara la cursa
		double[] maxAccProplellant = { 18, 24, 38 };
		ArrayList<Rocket> rockets = new ArrayList<Rocket>();

		rockets.add(
				new Rocket("Falcon IX", initialisePropellants(new double[] { 50, 50, 60, 60 }), new FuelTank(200000)));
		rockets.add(new Rocket("Star V", initialisePropellants(maxAccProplellant), new FuelTank(1800)));
		return rockets;
	}

	private static List<Propellant> initialisePropellants(double[] maxAccProplellant) throws Exception { // same
		List<Propellant> propellants = new ArrayList<Propellant>();
		for (double d : maxAccProplellant) {
			propellants.add(new Propellant(d));
		}

		return propellants;
	}

	public static void startRace(Circuit circuit) throws Exception {
		for (Rocket rocket : circuit.getRockets()) {
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
