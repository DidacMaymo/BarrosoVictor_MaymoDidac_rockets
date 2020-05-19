package application;

import java.util.ArrayList;

import java.util.List;
import domain.Circuit;
import domain.FuelTank;
import domain.Propellant;
import domain.Rocket;

public class Main {
	private Circuit circuit;
	private Rocket rocket;

	public  void main(String[] args) throws Exception {
		initialise();
		race();
	}

	public  void initialise() throws Exception { // iniciem les dades del circuit amb les del cohet etc
		rocket = initialiseRocket();
		circuit = new Circuit("tutorialCircuit", 10, 800, rocket); // 10 is seconds, and 800 is fuel capacity
	}

	private  Rocket initialiseRocket() throws Exception { // iniciem el rocket que fara la cursa
		double[] maxAccProplellant = { 18, 24, 38 };
		Rocket rocket = new Rocket("Star V", initialisePropellants(maxAccProplellant), new FuelTank(1800));
		return rocket;
	}

	private  List<Propellant> initialisePropellants(double[] maxAccProplellant) throws Exception { // same
		List<Propellant> propellants = new ArrayList<Propellant>();
		for (double d : maxAccProplellant) {
			propellants.add(new Propellant(d));
		}

		return propellants;
	}
	public  void race() throws Exception {
		System.out.println("Starting competition. Circuit: " + circuit.getId()+ ". Length: " + circuit.getLength()+ " . Max time: " + circuit.getMaxTime());
		while (circuit.getMaxTime() >= circuit.getCurrentTime() && rocket.getMetersTravelled() < circuit.getLength() && rocket.fueltank.getActualFuel() != 0) {
			circuit.doingRace();
			circuitInfo();
		}
		circuit.result();
	}
	
	 private  void circuitInfo() {
	        System.out.println("Current time: " + (circuit.getCurrentTime()) + " Acceleration: " + circuit.getRocket().getAcceleration()
	                + " Speed: " + circuit.getRocket().getSpeed() + " Distance: " + rocket.getMetersTravelled() + " Circuit: " + circuit.getLength()
	                + " Fuel: " + circuit.getRocket().getFuelTank().getActualFuel() + "/" + circuit.getRocket().getFuelTank().getFuelCapacity());
	    }
	
	public void displayScore(double timeTaken) {
		System.out.println(circuit.getId() + " Your are a WINNER !! With a time of " + timeTaken + " at: "
				+ circuit);
	}

}
