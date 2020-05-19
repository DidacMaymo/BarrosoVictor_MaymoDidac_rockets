package domain;

import java.util.ArrayList;
import java.util.List;

public class Strategy {

	private List<Double> accelerations = new ArrayList<Double>();

	public Strategy() throws Exception {
	}

	public void addEstrategy(double acceleration) {
		accelerations.add(acceleration);
	}
}