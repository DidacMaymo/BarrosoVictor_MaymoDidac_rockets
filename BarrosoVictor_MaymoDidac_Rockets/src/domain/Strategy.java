package domain;

import java.util.ArrayList;

public class Strategy {
	public static double decideAction(int currentTime, double length, double maxTime) {
		if (currentTime == 0)
			return length / maxTime;
		else if (currentTime < 5) {
			return 12;
		}
		return 0;
	}

	public static ArrayList<Integer> backtracking(ArrayList<Integer> accelerationArray, int maxTime, int currentTime,
			double circuitLength, double currentFuel) {

		return null;
	}
}
