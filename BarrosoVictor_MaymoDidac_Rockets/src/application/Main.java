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

	public static void main(String[] args) throws Exception {
		initialise();
		race();
	}

	public static void initialise() throws Exception { // iniciem les dades del circuit amb les del cohet etc
		rocket = initialiseRocket();
		circuit = new Circuit("tutorialCircuit", ConstantUtilities.maxTime, ConstantUtilities.length, rocket);
	}

	private static Rocket initialiseRocket() throws Exception { // iniciem el rocket que fara la cursa
		Rocket rocket = new Rocket(ConstantUtilities.nameRocket1, initialisePropellants(),
				new FuelTank(ConstantUtilities.fuelTankCapacity));
		return rocket;
	}

	private static List<Propellant> initialisePropellants() throws Exception { // same configuration of propellants for rocket.
		List<Propellant> propellants = new ArrayList<Propellant>();
		for (double d : ConstantUtilities.maxAccProplellant) {
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
		while (ConstantUtilities.maxTime >= circuit.getCurrentTime()
                && rocket.getMetersTravelled() < ConstantUtilities.length && rocket.fueltank.getActualFuel() != 0) {
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
