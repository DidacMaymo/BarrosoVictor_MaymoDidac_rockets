package view;

import java.util.ArrayList;

import java.util.List;

import application.CircuitController;
import application.dto.CircuitDTO;
import application.dto.FuelTankDTO;
import application.dto.PropellantDTO;
import application.dto.RocketDTO;
import application.dto.ScoreDTO;
import utilities.InvalidParamException;

public class Main {

	public static CircuitController controller = new CircuitController();

	public static void main(String[] args) throws Exception {
		createCircuits(createRockets());
		controller.startRace();
	}

	private static void createCircuits(ArrayList<RocketDTO> rocketsDTO) throws InvalidParamException {
		controller.createCircuit(new CircuitDTO("MadMax", 22, 1300));
		controller.createCircuit(new CircuitDTO("SpeedTrack", 10, 800));
		controller.createCircuit(new CircuitDTO("RisingLap", 15, 900));
		controller.createCircuit(new CircuitDTO("FreeWorld", 18, 1200));
	}

	private static ArrayList<RocketDTO> createRockets() throws InvalidParamException, Exception {
		ArrayList<RocketDTO> rocketsDTO = new ArrayList<>();
		rocketsDTO.add(
				new RocketDTO("Viper X", initialisePropellants(getPropellantAcceleration(0)), new FuelTankDTO(2500)));
		rocketsDTO.add(
				new RocketDTO("Star V", initialisePropellants(getPropellantAcceleration(1)), new FuelTankDTO(2800)));
		rocketsDTO.add(
				new RocketDTO("Falcon IX", initialisePropellants(getPropellantAcceleration(2)), new FuelTankDTO(1900)));
		rocketsDTO.add(
				new RocketDTO("Speedy X", initialisePropellants(getPropellantAcceleration(3)), new FuelTankDTO(2200)));

		return rocketsDTO;

	}

	private static double[] getPropellantAcceleration(int numberOfRocket) {
		switch (numberOfRocket) {
		case 0:
			double[] rocketOnePropellants = { 40, 50, 20, 38 };
			return rocketOnePropellants;
		case 1:
			double[] rocketTwoPropellants = { 30, 18, 24, 38 };
			return rocketTwoPropellants;
		case 2:
			double[] rocketThreePropellants = { 40, 29, 60 };
			return rocketThreePropellants;
		default:
			double[] rocketFourPropellants = { 10, 3, 20, 82 };
			return rocketFourPropellants;

		}

	}

	private static ArrayList<PropellantDTO> initialisePropellants(double[] maxAccProplellant)
			throws InvalidParamException {
		ArrayList<PropellantDTO> propellants = new ArrayList<PropellantDTO>();
		for (double d : maxAccProplellant) {
			propellants.add(new PropellantDTO(d));
		}
		return propellants;
	}

	public static void startRace(CircuitDTO circuitdto) throws Exception {
		for (RocketDTO rocketdto : circuitdto.getRocketsDTO()) {
			System.out.println("Starting competition. Circuit: " + circuitdto.getId() + ". Length: "
					+ circuitdto.getLength() + " . Max time: " + circuitdto.getMaxTime());
			Circuit circuit = controller.getCircuit(circuitdto);
			Rocket rocket = controllerRoquet.getRocket(rocketdto);
			while (circuit.raceIsGoing(rocket)) {
				circuit.doingRace(rocket);
				circuitInfo(rocket, circuit);
			}
			printResult(circuit, rocket);
			circuit.resetTime();
		}
		printBestScore(circuitdto.getBestScore());
	}

	private static void circuitInfo(Rocket rocket, Circuit circuit) {
		System.out.println("Current time: " + (circuit.getCurrentTime()) + " Acceleration: " + rocket.getAcceleration()
				+ " Speed: " + rocket.getSpeed() + " Distance: " + rocket.getMetersTravelled() + " Circuit: "
				+ circuit.getLength() + " Fuel: " + rocket.getActualFuel() + "/" + rocket.getFuelCapacity());
	}

	public static void printResult(Circuit circuit, Rocket rocket) throws Exception {
		if (circuit.isAWinner(rocket))
			win(rocket, circuit);
		else
			lose(rocket, circuit);
	}

	private static void win(RocketDTO rocket, CircuitDTO circuit) throws Exception {
		System.out.println("The rocket: " + rocket.getId() + " with a time of " + circuit.getCurrentTime()
				+ " is winning the race!\n");
	}

	private static void lose(RocketDTO rocket, CircuitDTO circuit) throws InvalidParamException {
		System.out.println("The rocket: " + rocket.getId() + " is not a winner\n");
	}

	private static void printBestScore(ScoreDTO score) throws InvalidParamException {
		System.out.println(
				"\nAnd the FINAL winner is: " + score.getRocketId() + " with a time of " + score.getTimeTaken());
	}

}