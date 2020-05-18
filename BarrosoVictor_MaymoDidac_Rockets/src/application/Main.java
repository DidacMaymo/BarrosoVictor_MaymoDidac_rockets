package application;

import java.util.ArrayList;
import java.util.List;

import domain.Circuit;
import domain.Fueltank;
import domain.Propellant;
import domain.Rocket;
import utilities.ConstantUtilities;

public class Main {
	public static Circuit circuit;
	public static Rocket rocket;

	public static void main(String[] args) throws Exception {
		initialise();
		circuit.race();
	}

	public static void initialise() throws Exception {
		rocket = initialiseRocket();
		circuit = new Circuit("tutorialCircuit", ConstantUtilities.maxTime, ConstantUtilities.length, rocket);
		// circuit.addRocket(rocket);
	}

	private static Rocket initialiseRocket() throws Exception { // iniciem el rocket que fara la cursa
		Rocket rocket = new Rocket(ConstantUtilities.nameRocket1, initialisePropellants(),
				new Fueltank(ConstantUtilities.fuelTankCapacity));
		return rocket;
	}

	private static List<Propellant> initialisePropellants() throws Exception { // same configuration of propellants for
																				// rocket.
		List<Propellant> propellants = new ArrayList<Propellant>();
		for (double d : ConstantUtilities.maxAccProplellant) {
			propellants.add(new Propellant(d));
		}

		return propellants;
	}
}