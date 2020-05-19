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
	private static Circuit circuit;
	private static Rocket rocket;

	public static void main(String[] args) throws Exception {
		initialise();
		circuit.race();
	}

	public static void initialise() throws Exception { // iniciem les dades del circuit amb les del cohet etc
		rocket = initialiseRocket();
		circuit = new Circuit("tutorialCircuit", 10, 800, rocket); // 10 is seconds, and 800 is fuel capacity
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

	

}
