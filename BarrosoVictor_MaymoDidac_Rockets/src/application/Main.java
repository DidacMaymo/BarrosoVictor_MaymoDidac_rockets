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

	public static void main(String[] args) throws Exception {
		initialise();
	}

	public static void initialise() throws Exception { //iniciem les dades del circuit amb les dels cohets etc
		List<Rocket> rockets= initialiseRockets();
		circuit = new Circuit("tutorialCircuit", ConstantUtilities.maxTime, ConstantUtilities.length, rockets);
	}

	private static List<Rocket> initialiseRockets() { //iniciem tots els rockets que faran la cursa
		List<Rocket> rockets = new ArrayList<Rocket>();
		List<Propellant> propellantsRocketOne = initialisePropellants(); 
		rockets.add(new Rocket(ConstantUtilities.nameRocket1, propellantsRocketOne,new FuelTank(500), circuit));
		return rockets;
	}
	
	private static List<Propellant> initialisePropellants() {
		List<Propellant> propellants= new ArrayList<Propellant>();
		propellants.add(new Propellant(100, "first"));
		return propellants;
	}

	public void displayRockets() {
		System.out.println("Starting competition. Circuit: " + id + ". Length: " + length + " . Max time: " + maxTime);
	}
}
