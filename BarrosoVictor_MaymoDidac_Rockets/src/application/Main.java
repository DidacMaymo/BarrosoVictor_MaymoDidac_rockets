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
		circuit = new Circuit("tutorialCircuit", 10, 800, rocket); // 10 is seconds, and 800 is fuel capacity
	}

	private static Rocket initialiseRocket() throws Exception { // iniciem el rocket que fara la cursa
		double[] maxAccProplellant = { 18, 24, 38 };
		Rocket rocket = new Rocket("Star V", initialisePropellants(maxAccProplellant),
				new FuelTank(1800));
		return rocket;
	}

	private static List<Propellant> initialisePropellants(double[] maxAccProplellant) throws Exception { // same configuration of propellants for rocket.
		List<Propellant> propellants = new ArrayList<Propellant>();
		for (double d : maxAccProplellant) {
			propellants.add(new Propellant(d));
		}

		return propellants;
	}

	public static void race() throws Exception {
		System.out.println("Starting competition. Circuit: " + circuit.id + ". Length: " + circuit.length
				+ " . Max time: " + circuit.maxTime);
		circuit.doingRace();
	}
	
	
}
