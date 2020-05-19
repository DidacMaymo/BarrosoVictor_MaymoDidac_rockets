package domain;

import java.util.ArrayList;
import java.util.List;

public class Estrategy {

	private List<Double> accelerations = new ArrayList<Double>();

	public Estrategy() throws Exception {
	}

	public void addEstrategy(double acceleration) {
		accelerations.add(acceleration);
	}
}