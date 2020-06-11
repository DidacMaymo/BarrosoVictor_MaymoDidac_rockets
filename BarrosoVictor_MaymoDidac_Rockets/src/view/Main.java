package view;

import java.util.ArrayList;

import java.util.List;

import application.CircuitController;
import application.dto.CircuitDTO;
import application.dto.FuelTankDTO;
import application.dto.PropellantDTO;
import application.dto.RocketDTO;
import application.dto.ScoreDTO;
import domain.Circuit;
import domain.Rocket;
import domain.Strategy;
import utilities.InvalidParamException;

public class Main {

	public static CircuitController controller = new CircuitController();

	public static void main(String[] args) throws Exception {
		createCircuits();
		createRockets();

		Strategy strat = new Strategy(3);

		Rocket rocket = controller.getRocket();
		Circuit circuit = controller.getCircuit();
		strat.backtracking(new ArrayList<Integer>(), circuit, 0, rocket);

	}

	private static void createCircuits() throws InvalidParamException {
		controller.createCircuit(new CircuitDTO("MadMax", 22, 1300));
		controller.createCircuit(new CircuitDTO("SpeedTrack", 10, 800));
		controller.createCircuit(new CircuitDTO("RisingLap", 15, 900));
		controller.createCircuit(new CircuitDTO("FreeWorld", 18, 1200));
	}

	private static void createRockets() throws InvalidParamException, Exception {
		controller.createRocket(
				new RocketDTO("Viper X", initialisePropellants(propellantViper()), new FuelTankDTO(2500)));
		controller
				.createRocket(new RocketDTO("Star V", initialisePropellants(propellantStarV()), new FuelTankDTO(2800)));
		controller.createRocket(
				new RocketDTO("Falcon IX", initialisePropellants(propellantFalconIX()), new FuelTankDTO(1900)));
		controller.createRocket(
				new RocketDTO("Speedy X", initialisePropellants(propellantSpeedyX()), new FuelTankDTO(3800)));
	}

	private static int[] propellantViper() {
		int[] rocketOnePropellants = { 40, 50, 20, 38 };
		return rocketOnePropellants;
	}

	private static int[] propellantStarV() {
		int[] rocketOnePropellants = { 30, 18, 24, 38 };
		return rocketOnePropellants;
	}

	private static int[] propellantFalconIX() {
		int[] rocketThreePropellants = { 40, 29, 60 };
		return rocketThreePropellants;
	}

	private static int[] propellantSpeedyX() {
		int[] rocketFourPropellants = { 10, 3, 20, 82 };
		return rocketFourPropellants;
	}

	private static ArrayList<PropellantDTO> initialisePropellants(int[] maxAccProplellant)
			throws InvalidParamException {
		ArrayList<PropellantDTO> propellants = new ArrayList<PropellantDTO>();
		for (int d : maxAccProplellant) {
			propellants.add(new PropellantDTO(d));
		}
		return propellants;
	}
}