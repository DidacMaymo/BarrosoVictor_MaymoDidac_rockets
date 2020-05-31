package domain;

import javax.xml.crypto.Data;


import utilities.ConstantUtilities;

public class Score {

	private Circuit circuit;
	private double timeTaken;
	private double metersTravelled;
	private Rocket winner;

	public Score(Circuit circuit, double timeTaken, double MetersTravelled) throws Exception {
		validateAttributes(timeTaken, MetersTravelled);
			this.circuit = circuit;
			this.timeTaken = timeTaken;
			this.metersTravelled = MetersTravelled;
	}

	private void validateAttributes(double time,double metersTravelled) throws Exception {
		if (time <= 0 || metersTravelled == 0) {
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
