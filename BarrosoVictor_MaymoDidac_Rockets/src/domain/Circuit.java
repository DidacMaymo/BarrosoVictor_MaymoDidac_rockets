package domain;

import java.util.ArrayList;
import java.util.List;

public class Circuit {

	private static final int accelerate = 1;
	private static final int slowDonw = 2;
	private static final int sameAcceleration = 3;

	public String id;
	public double maxTime, currentTime = 0; // time limit of race, and current time
	public int length; // circuit distance
	private Rocket rocket;

	public Circuit(String id, double maxTime, int length, Rocket rockets) throws Exception {
		if (validAtributes(id, maxTime, length)) {
			this.id = id;
			this.maxTime = maxTime;
			this.length = length;
			this.rocket = rockets;
		}
	}

	public boolean validAtributes(String id, double maxTime, int length) throws Exception {
		if (id != null && id != "") {
			throw new Exception("id of circuit not valid");
		}
		if (maxTime <= 0) {
			throw new Exception("maxTime of circuit not valid");
		}
		if (length <= 0) {
			throw new Exception("length of circuit not valid");
		}
		return true;
	}

	public void decideAction(int i, double whenAccelerate) { // each second of race this method is executed.
		// Does rocket want to accelerate (and when), same speed or slow down.
		if (i == accelerate) {
			rocket.accelerateRocket(whenAccelerate);
		} else if (i == slowDonw) {
			rocket.slowDown();
		}
		// else it is same acceleration
	}

	public Integer getLength() {
		return length;
	}

	public void updateRocketInfo(int i, double acceleration) throws Exception { // aixo farà cambiar la velocitat,
																				// acceleracio i metres per tant de																// rocket
		acceleration = newAcceleration();
		rocket.setActualSpeed();
		rocket.setAcceleration(acceleration);
		rocket.setMetersTravelled();
	}

	private double newAcceleration() {

		return 0;
	}

	public void setCurrentTime(double time) {
		this.currentTime = time;
	}

}
