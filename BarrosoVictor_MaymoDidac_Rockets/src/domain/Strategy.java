package domain;

public class Strategy {
// Adds an acceleration to the strategy

	public static double decideAction(int currentTime, double length, double maxTime) {
		if (currentTime == 0)
			return length / maxTime;
		else if (currentTime < 5) {
			return 12;
		}
		return 0;
	}
}
