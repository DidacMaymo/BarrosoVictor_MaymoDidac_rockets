package application;

import java.util.ArrayList;
import java.util.List;

import domain.Circuit;
import domain.FuelTank;
import domain.Propellant;
import domain.Rocket;
import utilities.ConstantUtilities;

public class Main {
	public static Circuit circuit;
	public static List<Rocket> rockets = new ArrayList<Rocket>();

	public static void main(String[] args) throws Exception {
		initialise();
	}

	public static void initialise() throws Exception { //iniciem les dades del circuit amb les dels cohets etc
		List<Rocket> rockets= initialiseRockets(1);
		circuit = new Circuit("tutorialCircuit", ConstantUtilities.maxTime, ConstantUtilities.length, rockets);
	}

	private static List<Rocket> initialiseRockets(int howManyRockets) { //iniciem tots els rockets que faran la cursa 
		rockets.add(new Rocket(ConstantUtilities.nameRocket1, initialisePropellants(),new FuelTank(500), circuit));
		return rockets;
	}
	
	private static List<Propellant> initialisePropellants() { //same configuration of propellants for all rockets.
		List<Propellant> propellants= new ArrayList<Propellant>();
		propellants.add(new Propellant(100, "first"));
		return propellants;
	}

	public void displayRockets() {
		for (Rocket rocket : rockets) {
			System.out.println("Starting competition. Circuit: " + circuit.id + ". Length: " + circuit.length + " . Max time: " + circuit.maxTime);
			
		}
		
	}
}
