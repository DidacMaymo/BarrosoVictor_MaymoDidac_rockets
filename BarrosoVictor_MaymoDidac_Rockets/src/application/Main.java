package application;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.time.LocalTime;

import domain.Circuit;
import domain.FuelTank;
import domain.Propellant;
import domain.Rocket;
import utilities.ConstantUtilities;

public class Main {
	public static Circuit circuit;
	public static Rocket rocket;
	public static long start;
	public static long elapsedTime;

	public static void main(String[] args) throws Exception {
		initialise();
		circuitInfo();
	}

	public static void initialise() throws Exception { //iniciem les dades del circuit amb les del cohet etc
		rocket= initialiseRocket();
		circuit = new Circuit("tutorialCircuit", ConstantUtilities.maxTime, ConstantUtilities.length, rocket);
		//circuit.addRocket(rocket);
	}

	private static Rocket initialiseRocket() { //iniciem el rocket que fara la cursa 
		Rocket rocket = new Rocket(ConstantUtilities.nameRocket1, initialisePropellants(),new FuelTank(500), circuit);
		return rocket;
	}
	
	private static List<Propellant> initialisePropellants() { //same configuration of propellants for rocket.
		List<Propellant> propellants= new ArrayList<Propellant>();
		propellants.add(new Propellant(ConstantUtilities.maxAccProplellant, "first"));
		return propellants;
	}

	public static void circuitInfo() throws InterruptedException {
		System.out.println("Starting competition. Circuit: " + circuit.id + ". Length: " + circuit.length + " . Max time: " + circuit.maxTime);
		//while(circuit.getMaxTime()<circuit.currentTime) { //per ara que vagi fent mentres tinguis temps es igual lo demes
			start = System.nanoTime();        		//Comença contador del timing
			TimeUnit.SECONDS.sleep(1);
			System.out.println("Current Time: "+ circuit.currentTime+" Acceleration: "+ rocket.getAcceleration()+ " Speed: "+ rocket.getSpeed()+
					" Distance: "+ rocket.getMetersTravelled()+ "Circuit "+ circuit.length+ " Fuel: "+ rocket.getFuelConsumption() + "/"+ rocket.fueltank.getFuelCapacity());
			elapsedTime = System.nanoTime() - start; //compta el temps que ha passat ara(hauria de ser 1 segon)
			System.out.println(elapsedTime);
			//circuit.setCurrentTime(elapsedTime);		//aumentem contador de time +1 segons suposadament
		//}
	}
		
}

