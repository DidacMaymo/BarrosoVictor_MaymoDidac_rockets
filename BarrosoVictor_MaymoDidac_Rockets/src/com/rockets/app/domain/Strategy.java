package com.rockets.app.domain;

import java.util.ArrayList;

import com.rockets.app.utilities.InvalidParamException;

public class Strategy {

		private ArrayList<Integer> solution;
		private int maxSolutions;
		private int actualSolution = 0;

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

		public void backtracking(ArrayList<Integer> accelerationArray, int maxTime, int currentTime, double circuitLength,
				Rocket rocket) throws InvalidParamException {
			
			for (int acceleration = 0; acceleration < rocket.getMaxAcceleration() && actualSolution < maxSolutions
					&& currentTime < maxTime; acceleration++) {
				
				Rocket iterable = new Rocket(rocket);
				iterable.setDesiredAcceleration(acceleration);
				
				if (rocket.getMetersTravelled() >= circuitLength || maxTime == currentTime) {
					
					updateBestSolution(accelerationArray);
					
					actualSolution++;
				}
				backtracking(accelerationArray, maxTime, currentTime + 1, circuitLength, new Rocket(iterable));
				accelerationArray.remove(accelerationArray.size() - 1);
			}
		}

		public ArrayList<Integer> getSolution() {
			return solution;
		}

		private void updateBestSolution(ArrayList<Integer> newSolution) {
			if (solution == null)
				solution = newSolution;
			else if (newSolution.size() < solution.size())
				solution = newSolution;
			System.out.println("\n" + solution.toString());

		}
	}

}