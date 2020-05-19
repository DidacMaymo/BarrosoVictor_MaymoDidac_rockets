package domain;

import utilities.ConstantUtilities;

public class Circuit {
	private String id;
	private int maxTime;
	private double length;
	private Rocket rocket;
	private int currentTime = 0;

	public Circuit(String id, int maxtime, double length, Rocket rocket) throws Exception {
		if (!validateAttributes(id, maxtime, length, rocket))
			throw new Exception("Wrong attributes set!");

		this.id = id;
		this.maxTime = maxtime;
		this.length = length;
		this.rocket = rocket;
	}

	/* Validating attributes */
	private boolean validateAttributes(String id, int maxtime, double length, Rocket rocket) {
		if (id.isEmpty() || maxtime <= 0 || length <= 0 || rocket == null) {
			return false;
		}
		return true;
	}

	/* getters and setters methods */
	public void addScoreToRocket() throws Exception {
		rocket.addScore(new Score(rocket, this, currentTime));
	}

	public int getCurrentTime() {
		return currentTime;
	}

	public Rocket getRocket() {
		return rocket;
	}

	public String getId() {
		return id;
	}

	public int getMaxTime() {
		return maxTime;
	}

	public Integer getLimitTime() {
		return maxTime;
	}

	public Double getLength() {
		return length;
	}

	public void doingRace() throws Exception {
		decideAction();
		currentTime += ConstantUtilities.delay;
	}

	// race methods
	private void decideAction() throws Exception {
		double acceleration = rocket.decideAction(currentTime, length, maxTime);
		rocket.speedToAcceleration(acceleration);
		rocket.addStrategy(acceleration);
	}

	public boolean result() throws Exception {
		if (rocket.getMetersTravelled() < length || rocket.getFuelTank().getActualFuel() <= 0)
			return false;
		return true;
	}

}
