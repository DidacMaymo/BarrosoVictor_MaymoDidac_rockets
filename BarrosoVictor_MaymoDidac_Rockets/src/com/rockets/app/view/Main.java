package com.rockets.app.view;

import java.util.ArrayList;
import com.rockets.app.application.CircuitController;
import com.rockets.app.application.dto.CircuitDTO;
import com.rockets.app.application.dto.FuelTankDTO;
import com.rockets.app.application.dto.PropellantDTO;
import com.rockets.app.application.dto.RocketDTO;
import com.rockets.app.utilities.IObserver;
import com.rockets.app.utilities.InvalidParamException;

public class Main {

	public static CircuitController controller = new CircuitController();
	

	public static void main(String[] args) throws Exception {
		createCircuits();
		createRockets();
		controller.addObserver(new IObserver() {
			public void update(String str) {
				System.out.println(str);
			}
		});		
		controller.startRace();
		
	}

	private static void createCircuits() throws InvalidParamException {
		//controller.createCircuit(new CircuitDTO("MadMax", 22, 1300));
		//controller.createCircuit(new CircuitDTO("SpeedTrack", 10, 800));
		//controller.createCircuit(new CircuitDTO("RisingLap", 15, 900));
		controller.createCircuit(new CircuitDTO("FreeWorld", 18, 1200));
	}

	private static void createRockets() throws InvalidParamException, Exception  {
		//controller.createRocket(new RocketDTO("Viper X", initialisePropellants(propellantViper()), new FuelTankDTO(2500)));
		controller.createRocket(new RocketDTO("Star V", initialisePropellants(propellantStarV()), new FuelTankDTO(2800)));
		//controller.createRocket(new RocketDTO("Falcon IX", initialisePropellants(propellantFalconIX()), new FuelTankDTO(1900)));
		//controller.createRocket(new RocketDTO("Speedy X", initialisePropellants(propellantSpeedyX()), new FuelTankDTO(3800)));
	}
	
	private static double[] propellantViper() {
		 double[] rocketOnePropellants = { 40, 50, 20, 38 };
		 return rocketOnePropellants;
	}
	private static double[] propellantStarV() {
		 double[] rocketOnePropellants = { 30, 18, 24, 38 };
		 return rocketOnePropellants;
	}
	private static double [] propellantFalconIX() {
		double[] rocketThreePropellants = { 40, 29, 60 };
		return rocketThreePropellants;
	}
	private static double [] propellantSpeedyX() {
		double[] rocketFourPropellants = { 10, 3, 20, 82 };
		return rocketFourPropellants;
	}

	private static ArrayList<PropellantDTO> initialisePropellants(double[] maxAccProplellant)
			throws Exception {
		ArrayList<PropellantDTO> propellants = new ArrayList<PropellantDTO>();
		for (double d : maxAccProplellant) {
			propellants.add(new PropellantDTO(d));
		}
		return propellants;
	}


	
}
