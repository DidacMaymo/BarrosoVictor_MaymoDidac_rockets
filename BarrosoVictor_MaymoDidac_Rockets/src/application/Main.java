package application;

import java.util.ArrayList;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;
import domain.Circuit;
import domain.FuelTank;
import domain.Propellant;
import domain.Rocket;
import utilities.ConstantUtilities;

public class Main {
	public static Circuit circuit;
	public static Rocket rocket;
	public static int maxTime = 10; // time limit of race, and current time
	public static int length = 800;
	public static double[] maxAccProplellant = { 18, 24, 38 };
	public static double fuelTankCapacity = 1800;
	public static String nameRocket1 = "Star V";

	public static void main(String[] args) throws Exception {
		initialise();
		race();
	}

	public static void initialise() throws Exception { // iniciem les dades del circuit amb les del cohet etc
		rocket = initialiseRocket();
		circuit = new Circuit("tutorialCircuit", maxTime, length, rocket);
	}

	private static Rocket initialiseRocket() throws Exception { // iniciem el rocket que fara la cursa
		Rocket rocket = new Rocket(nameRocket1, initialisePropellants(),
				new FuelTank(fuelTankCapacity));
		return rocket;
	}

	private static List<Propellant> initialisePropellants() throws Exception { // same configuration of propellants for rocket.
		List<Propellant> propellants = new ArrayList<Propellant>();
		for (double d : maxAccProplellant) {
			propellants.add(new Propellant(d));
		}

		return propellants;
	}

	public static void race() throws Exception {
		System.out.println("Starting competition. Circuit: " + circuit.id + ". Length: " + circuit.length
				+ " . Max time: " + circuit.maxTime);
		doingRace();
	}
	
	private static void doingRace() throws Exception {
		while (maxTime >= circuit.getCurrentTime()
                && rocket.getMetersTravelled() < length && rocket.fueltank.getActualFuel() != 0) {
        	circuit.decideAction();
        	updatingCirucitInfo();
            circuit.currentTime += ConstantUtilities.delay;
        }
        circuit.result();
    }
	private static void updatingCirucitInfo() {
		System.out.println(
				"Current Time: " + (circuit.currentTime + 1) + " Acceleration: " + rocket.getAcceleration() + " Speed: "
						+ rocket.getSpeed() + " Distance: " + rocket.getMetersTravelled() + " Circuit " + circuit.length
						+ " Fuel: " + rocket.fueltank.getActualFuel() + "/" + rocket.fueltank.getFuelCapacity());
	}
}
