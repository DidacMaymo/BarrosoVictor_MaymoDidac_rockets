package domain;

import java.util.ArrayList;

import utilities.ConstantUtilities;
import utilities.InvalidParamException;

public class Strategy {
	private ArrayList<Integer> solution;
	private int maxSolutions;
	private int actualSolution = 0;
	private int cont = 0;

	public Strategy(int maxSolutions) {
		this.maxSolutions = maxSolutions;
	}

	public static double decideAction(int currentTime, double length, double maxTime) {
		if (currentTime == 0)
			return length / maxTime;
		else if (currentTime < 5) {
			return 12;
		}
		return 0;
	}

	/*
	 * public static ArrayList<Integer> backtracking(ArrayList<Integer>
	 * accelerationArray, int maxTime, int currentTime, double circuitLength, Rocket
	 * rocket) throws InvalidParamException { for (int acceleration = 0;
	 * acceleration < rocket.getMaxAcceleration(); acceleration++) {
	 * rocket.setDesiredAcceleration(acceleration); if (rocket.getMetersTravelled()
	 * >= circuitLength || maxTime == currentTime) return accelerationArray;
	 * 
	 * rocket.revertChanges(acceleration);
	 * accelerationArray.remove(accelerationArray.size() - 1); } return
	 * accelerationArray; }
	 */

	public void backtracking(ArrayList<Integer> accelerationArray, Circuit circuit, int currentTime, Rocket rocket)
			throws InvalidParamException {

		for (int acceleration = rocket.getMaxAcceleration(); acceleration >= 0 && actualSolution < maxSolutions
				&& currentTime < circuit.getMaxTime(); acceleration--) {

			if (rocket.getActualFuel() >= 0) {
				Rocket iterable = new Rocket(rocket);
				iterable.setDesiredAcceleration(acceleration);

				accelerationArray.add(acceleration);
				if ((rocket.getMetersTravelled() >= circuit.getLength() && iterable.getActualFuel() >= 0)
						|| (actualSolution == 0
								&& (currentTime == (circuit.getMaxTime() - 1) || iterable.getActualFuel() == 0))) {
					System.out.println("============================================================");
					updateBestSolution(accelerationArray);
					actualSolution++;
					System.out.println("\n" + actualSolution);
					return;

				} else {
					backtracking(accelerationArray, circuit, currentTime + 1, iterable);
				}

				accelerationArray.remove(accelerationArray.size() - 1);
			}
		}
	}

	public ArrayList<Integer> getSolution() {
		return solution;
	}

	private void updateBestSolution(ArrayList<Integer> newSolution) {
		if (solution == null) {
			solution = newSolution;
			System.out.println("POSIBLE NO SOLUCION\n");
			for (int it : solution) {
				System.out.println(it);
			}
		} else if (newSolution.size() < solution.size()) {
			System.out.println("SOLUCTION: " + cont);
			System.out.println();
			solution = newSolution;

			for (int it : solution) {
				System.out.println(it);
			}
		}
		System.out.println("==============");
		cont++;

	}

	public static double decideAction(Rocket rocket, int currentTime, double length, double maxTime) throws Exception {
		for (double acc = rocket.getMaxAcceleration(); acc >= 0; acc--) {
			if (tryAcceleration(rocket, acc, maxTime - currentTime, length - rocket.getMetersTravelled(),
					rocket.getActualFuel())) {
				return acc;
			}
		}
		return 0;
	}

	private static boolean tryAcceleration(Rocket rocket, double acc, double timeRemaining, double metersRemaining,
			double fuelRemaining) throws Exception {
		double newSpeed = rocket.getSpeed() + acc * ConstantUtilities.DELAY;
		double newFuelConsumption = rocket.getFuelTank().getFuelConsumption(newSpeed);
		if (rocket.getMetersTravelled() + newSpeed * timeRemaining >= metersRemaining) {
			if (fuelRemaining - newFuelConsumption * timeRemaining >= 0) {
				return true;
			}
		}
		return false;
	}
}
