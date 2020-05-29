package application;

import java.util.ArrayList;

import java.util.List;
import domain.Circuit;
import domain.FuelTank;
import domain.Propellant;
import domain.Rocket;

public class Main {

	public static void main(String[] args) throws Exception {
		Rocket rocket = initialiseRocket();
		ArrayList<Rocket> rockets = new ArrayList<Rocket>();
		rockets.add(rocket);
		Circuit circuit = new Circuit("tutorialCircuit", 10, 800, rockets);
		startRace(circuit);
	}

	private static Rocket initialiseRocket() throws Exception { // iniciem el rocket que fara la cursa
		double[] maxAccProplellant = { 18, 24, 38 };
		Rocket rocket = new Rocket("Star V", initialisePropellants(maxAccProplellant), new FuelTank(1800));
		return rocket;
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
			printResult(rocket, circuit);
			circuit.resetTime();
		}
	}

	private static void circuitInfo(Rocket rocket, Circuit circuit) {
		System.out.println("Current time: " + (circuit.getCurrentTime()) + " Acceleration: " + rocket.getAcceleration()
				+ " Speed: " + rocket.getSpeed() + " Distance: " + rocket.getMetersTravelled() + " Circuit: "
				+ circuit.getLength() + " Fuel: " + rocket.getActualFuel() + "/" + rocket.getFuelCapacity());
	}

	public static void printResult(Rocket rocket, Circuit circuit) throws Exception {
		circuit.addScoreToRocket(rocket);
		if (circuit.isAWinner(rocket))
			win(rocket, circuit);
		else
			lose(rocket, circuit);
	}

	private static void win(Rocket rocket, Circuit circuit) throws Exception {
		System.out.println("And the winner is: " + rocket.getId() + " with a time of " + circuit.getCurrentTime());
	}

	private static void lose(Rocket rocket, Circuit circuit) {
		System.out.println("There is no winner");
	}

}