package domain;

import java.util.ArrayList;

import utilities.ConstantUtilities;
import utilities.InvalidParamException;

public class Strategy {
	private ArrayList<Integer> solution;
	private boolean solved = false;
	private int maxSolutions;
	private int actualSolution = 0;

	public Strategy(int maxSolutions) {
		this.maxSolutions = maxSolutions;
	}

	public static int decideAction(int currentTime, double length, double maxTime) {
		if (currentTime == 0)
			return (int) (length / maxTime);
		else if (currentTime < 5) {
			return 12;
		}
		return 0;
	}

	public ArrayList<Integer> getSolution() {
		return solution;
	}

	public void backtracking(ArrayList<Integer> accelerationArray, Circuit circuit, int currentTime, Rocket rocket)
			throws InvalidParamException {
		for (int acceleration = rocket.getMaxAcceleration(); acceleration >= 0 && actualSolution < maxSolutions
				&& currentTime < circuit.getMaxTime(); acceleration--) {

			if (rocket.getActualFuel() >= 0) {
				Rocket iterable = new Rocket(rocket);
				iterable.setDesiredAcceleration(acceleration);

				accelerationArray.add(acceleration);
				if ((rocket.getMetersTravelled() >= circuit.getLength() && iterable.getActualFuel() >= 0)
						|| (actualSolution == 0 && currentTime >= ((circuit.getMaxTime() / 2)) - 4)) {
					updateBestSolution(accelerationArray);
					actualSolution++;

				} else {
					backtracking(accelerationArray, circuit, currentTime + 1, iterable);
				}
				accelerationArray.remove(accelerationArray.size() - 1);
			}
		}
	}

	private void updateBestSolution(ArrayList<Integer> newSolution) {
		if (solution == null) {
			solution = newSolution;
			for (int it : solution) {
				System.out.println(it);
			}
		} else if (solved == false) {
			solution = newSolution;
			solved = true;
			for (int it : solution) {
				System.out.println(it);
			}

		} else if (newSolution.size() < solution.size()) {
			System.out.println();
			solution = newSolution;

			for (int it : solution) {
				System.out.println(it);
			}
		}

	}
}
