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
		Circuit circuit = new Circuit("tutorialCircuit", 10, 800, rocket); // 10 is seconds, and 800 is fuel capacity
		startRace(rocket,circuit);
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

	public static void startRace(Rocket rocket,	Circuit circuit) throws Exception {
		System.out.println("Starting competition. Circuit: " + circuit.getId() + ". Length: " + circuit.getLength()
				+ " . Max time: " + circuit.getMaxTime());
		while (circuit.raceIsGoing(rocket, circuit)) {
			circuit.doingRace();
			circuitInfo(rocket, circuit);
		}
		printResult(rocket, circuit);
	}
	

	private static void circuitInfo(Rocket rocket,	Circuit circuit) {
		System.out.println("Current time: " + (circuit.getCurrentTime()) + " Acceleration: "
				+ circuit.getRocket().getAcceleration() + " Speed: " + circuit.getRocket().getSpeed() + " Distance: "
				+ rocket.getMetersTravelled() + " Circuit: " + circuit.getLength() + " Fuel: "
				+ circuit.getRocket().getFuelTank().getActualFuel() + "/"
				+ circuit.getRocket().getFuelTank().getFuelCapacity());
	}

	public static void printResult(Rocket rocket,	Circuit circuit) throws Exception {
        if (circuit.result())
            win(rocket, circuit);
        else
            lose(rocket, circuit);
    }

    private static void win(Rocket rocket,	Circuit circuit) throws Exception {
        System.out.println(
                "And the winner is: " + circuit.getRocket().getId() + " with a time of " + circuit.getCurrentTime());
        circuit.addScoreToRocket();
    }

    private static void lose(Rocket rocket,	Circuit circuit) {
        System.out.println("There is no winner");
    }

}
