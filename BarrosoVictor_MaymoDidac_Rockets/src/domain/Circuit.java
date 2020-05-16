package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

public class Circuit {

	private static final int accelerate = 1;
	private static final int slowDonw = 2;
	private static final int sameAcceleration = 3;

	public String id;
	public int maxTime, currentTime = 0; // time limit of race, and current time
	public int length; // circuit distance
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

	public void decideAction() { //also need to decide when to accelerate when he decides that
		
		rocket.decideAction(currentTime);
	}

	public Integer getLength() {
		return length;
	}
	public double getMaxTime() {
		return this.maxTime;
	}
	public double getCurrentTime() {
		return this.currentTime;
	}

	public void updateRocketInfo(double acceleration) throws Exception { 
		rocket.setAcceleration(acceleration);
	}

	private double newAcceleration() { //NOT YET
		return 0;
	}

	public void setCurrentTime(double time) {
		this.currentTime += time;
	}
	
}
