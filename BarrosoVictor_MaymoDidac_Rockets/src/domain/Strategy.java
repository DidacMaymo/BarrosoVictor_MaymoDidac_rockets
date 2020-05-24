package domain;

import java.util.ArrayList;
import java.util.List;

public class Strategy {
	public Strategy() throws Exception {

	}

	// Adds an acceleration to the strategy

	public double decideAction(int currentTime, double length, double maxTime) {
		if (currentTime == 0)
			return length / maxTime;
		else if (currentTime < 5) {
			return 12;
		}
		return 0;
	}
}
