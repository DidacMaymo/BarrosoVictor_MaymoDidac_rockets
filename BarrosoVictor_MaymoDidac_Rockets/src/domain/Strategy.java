package domain;

import java.util.ArrayList;
import java.util.List;

public class Strategy {

	private List<Double> accelerations = new ArrayList<Double>();

	public Strategy() throws Exception {

	}
	
	//Adds an acceleration to the strategy
	public void addEstrategy(double acceleration) {
		accelerations.add(acceleration);
	}
}
