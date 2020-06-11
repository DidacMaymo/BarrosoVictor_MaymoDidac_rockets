package com.rockets.app.domain;

import java.util.ArrayList;

public class Strategy {

	private ArrayList<Integer> solution;
	private int maxSolutions = 1;
	private int actualSolution = 0;

	public Strategy() {

	}

	public ArrayList<Integer> getSolution() {
		return solution;
	}

	public void backtracking(ArrayList<Integer> accelerationArray,int currentTime, Rocket rocket, double length, int maxTime)
			throws Exception {
		for (int acceleration = (int) rocket.getMaxAcceleration(); acceleration >= 0 && actualSolution < maxSolutions
				&& currentTime < maxTime; acceleration--) {
			 Rocket iterable = new Rocket(rocket);
			iterable.setDesiredAcceleration(acceleration);
			accelerationArray.add(acceleration);
			if ((iterable.getMetersTravelled() >= length && iterable.getActualFuel() > 0)) {
				updateBestSolution(accelerationArray);
				actualSolution++;
			} else if (iterable.getActualFuel() > 0) {
				backtracking(accelerationArray,  currentTime + 1, iterable ,length, maxTime);
			}
			accelerationArray.remove(accelerationArray.size() - 1);
		}
	}

	private void updateBestSolution(ArrayList<Integer> newSolution) {
		solution = new ArrayList<Integer>(newSolution);
	}

	public int getAccelerationAtCurrentTime(int time) {
		int cont = 0;
		int ret = 0;
		java.util.Iterator<Integer> it = solution.iterator();
		while (cont != time && it.hasNext()) {
			ret = it.next();
			cont++;
		}
		ret = it.next();
		return ret;
	}

}
