package domain;

import javax.xml.crypto.Data;


import utilities.ConstantUtilities;

public class Score {

	private Rocket rocket;
	private Circuit circuit;
	private double timeTaken;
	private double metersTravelled;

	public Score(Rocket rocket, Circuit circuit, double timeTaken, double MetersTravelled) throws Exception {
		validateAttributes(timeTaken, rocket, MetersTravelled);
			this.rocket = rocket;
			this.circuit = circuit;
			this.timeTaken = timeTaken;
			this.metersTravelled = MetersTravelled;
	}

	private void validateAttributes(double time, Rocket rocket, double metersTravelled) throws Exception {
		if (time <= 0 || rocket == null || metersTravelled == 0) {
			throw new Exception();
		}
	}

	public double getTimeTaken() {
		return timeTaken;
	}
	public double getMetersTravelled() {
		return metersTravelled;
	}
	public Circuit getCircuit() {
		return circuit;
	}
}
