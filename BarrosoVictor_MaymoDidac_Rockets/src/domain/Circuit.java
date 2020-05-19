package domain;

import java.util.ArrayList;


import java.util.List;

import utilities.ConstantUtilities;


public class Circuit {

	private String id;
	private int maxTime, currentTime = 0;
	private int length;
	private Rocket rocket;
	private List<Score> score = new ArrayList<Score>();

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

	public void decideAction() throws Exception {
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
			currentTime += ConstantUtilities.delay;		
	}

	public void result() throws Exception {
		if (rocket.getMetersTravelled() < length)
			lose();
		else if (rocket.getMetersTravelled() >= length) {
			win();
		}
	}

	private void win() throws Exception {
		System.out.println("And the winner is: " + rocket.getId() + " with a time of " + currentTime);
		score.add(new Score(rocket, this, currentTime));
	}

	private void lose() {
		System.out.println("There is no winner");
	}

	public Rocket getRocket() {
		return rocket;
	}

}
