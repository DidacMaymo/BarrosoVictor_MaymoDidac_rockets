package domain;

import java.util.ArrayList;
import java.util.List;

public class Estrategy {

	public List<String> accions = new ArrayList();

	public void addEstrategy(int time, double acceleration, Rocket rocket) {
		accions.add(
				"For time: " + time + " Has decided to accelerate: " + acceleration);
	}
}
