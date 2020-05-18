package domain;

import java.util.ArrayList;
import java.util.List;

public class Strategy {

	private List<String> accions = new ArrayList<String>();
	int timesAccelerated = 0;

	public Strategy() throws Exception {

	}

	public void addEstrategy(int time, double acceleration) {
		accions.add("For time: " + time + "Has decided to accelerate: " + acceleration);
	}
}
