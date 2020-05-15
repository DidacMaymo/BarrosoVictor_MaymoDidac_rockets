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
	public static Rocket rocket;

	public static void main(String[] args) throws Exception {
		initialise();
	}

	public static void initialise() throws Exception { //iniciem les dades del circuit amb les del cohet etc
		rocket= initialiseRocket();
		circuit = new Circuit("tutorialCircuit", ConstantUtilities.maxTime, ConstantUtilities.length, rocket);
	}

	private static Rocket initialiseRocket() { //iniciem el rocket que fara la cursa 
		Rocket rocket = new Rocket(ConstantUtilities.nameRocket1, initialisePropellants(),new FuelTank(500), circuit);
		return rocket;
	}
	
	private static List<Propellant> initialisePropellants() { //same configuration of propellants for rocket.
		List<Propellant> propellants= new ArrayList<Propellant>();
		propellants.add(new Propellant(100, "first"));
		return propellants;
	}

	public void displayRocket() {
		System.out.println("Starting competition. Circuit: " + circuit.id + ". Length: " + circuit.length + " . Max time: " + circuit.maxTime);
		while(rocket.getAcceleration()!=0) {
			System.out.println("Current Time: "+ circuit.currentTime+" Acceleration: "+ rocket.getAcceleration()+ " Speed: "+ rocket.getSpeed()+
					" Distance: "+ rocket.getMetersTravelled()+ "Circuit "+ circuit.length+ " Fuel: "+ rocket.getFuelConsumption() + "/"+ rocket.fueltank.getFuelCapacity());
			
		}
	}
		
}

