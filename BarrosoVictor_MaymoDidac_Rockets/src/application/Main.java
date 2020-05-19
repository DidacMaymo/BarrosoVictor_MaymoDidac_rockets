package application;

import java.util.ArrayList;

import java.util.List;
import domain.Circuit;
import domain.FuelTank;
import domain.Propellant;
import domain.Rocket;

public class Main {
	private static Circuit circuit;
	private static Rocket rocket;

	public static void main(String[] args) throws Exception {
		initialise();
		race();
	}

	public static void initialise() throws Exception {
		rocket = initialiseRocket();
		circuit = new Circuit("tutorialCircuit", 10, 800, rocket);
	}

	private static Rocket initialiseRocket() throws Exception {
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

	// starting race

	public static void race() throws Exception {
		System.out.println("Starting competition. Circuit: " + circuit.getId() + ". Length: " + circuit.getLength()
				+ " . Max time: " + circuit.getMaxTime());
		while (circuit.getMaxTime() > circuit.getCurrentTime() && rocket.getMetersTravelled() < circuit.getLength()
				&& circuit.getRocket().getFuelTank().getActualFuel() != 0) {
			circuit.doingRace();
			circuitInfo();
		}
		printResult();
	}

	// prints
	private static void circuitInfo() {
		System.out.println("Current time: " + (circuit.getCurrentTime()) + " Acceleration: "
				+ circuit.getRocket().getAcceleration() + " Speed: " + circuit.getRocket().getSpeed() + " Distance: "
				+ rocket.getMetersTravelled() + " Circuit: " + circuit.getLength() + " Fuel: "
				+ circuit.getRocket().getFuelTank().getActualFuel() + "/"
				+ circuit.getRocket().getFuelTank().getCapacity());
	}

	// result prints
	public static void printResult() throws Exception {
		if (circuit.result())
			win();
		else
			lose();
	}

	private static void win() throws Exception {
		System.out.println(
				"And the winner is: " + circuit.getRocket().getId() + " with a time of " + circuit.getCurrentTime());
		circuit.addScoreToRocket();
	}

	private static void lose() {
		System.out.println("There is no winner");
	}
}