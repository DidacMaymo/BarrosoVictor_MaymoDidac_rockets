package domain;

import java.util.ArrayList;


import java.util.List;

import utilities.ConstantUtilities;


public class Circuit {

	private String id;
	private int maxTime, currentTime = 0;
	private int length;
	private Rocket rocket;

	public Circuit(String id, int maxTime, int length, Rocket rocket) throws Exception {
		if (validAtributes(maxTime, length)) {
			this.id = id;
			this.maxTime = maxTime;
			this.length = length;
			this.rocket = rocket;
		}
	}

	public boolean validAtributes(double maxTime, int length) throws Exception {
		if (maxTime <= 0) {
			throw new Exception("maxTime of circuit not valid");
		}
		if (length <= 0) {
			throw new Exception("length of circuit not valid");
		}
		return true;
	}

	private void decideAction() throws Exception {
		double acceleration = rocket.decideAction(currentTime, maxTime, length);
		rocket.speedToAcceleration(acceleration);
		rocket.addStrategy(acceleration);
	}

	public double getCurrentTime() {
		return this.currentTime;
	}
	public double getMaxTime() {
		return this.maxTime;
	}
	public String getId() {
		return this.id;
	}
	public double getLength() {
		return this.length;
	}

	public void setCurrentTime(double time) {
		this.currentTime += time;
	}
	
	public void doingRace() throws Exception {
			decideAction();
			currentTime += ConstantUtilities.DELAY;		
	}
	public boolean result() throws Exception {
        if (rocket.getMetersTravelled() < length || rocket.getFuelTank().getActualFuel() <= 0)
            return false;
        return true;
    }

	public Rocket getRocket() {
		return rocket;
	}
	public static boolean raceIsGoing(Rocket rocket,	Circuit circuit) {
		if(circuit.getCurrentTime() < circuit.getMaxTime() && rocket.getMetersTravelled() < circuit.getLength()
				&& circuit.getRocket().getActualFuel() != 0)
			return true;
		return false;
	}
	 public void addScoreToRocket() throws Exception {
	        rocket.addScore(new Score(rocket, this, currentTime));
	 }

}
