package domain;

import java.util.ArrayList;
import java.util.List;

import utilities.ConstantUtilities;

public class Circuit {
	private String id;
	private int maxTime;
	private double length;
	private List<Rocket> rockets = new ArrayList<Rocket>();
	private int currentTime = 0;

	public Circuit(String id, int maxtime, double length, List<Rocket> rockets) throws Exception {
		validateAttributes(id, maxtime, length, rockets);
		this.id = id;
		this.maxTime = maxtime;
		this.length = length;
		this.rockets = rockets;
	}

	private void validateAttributes(String id, int maxtime, double length, List<Rocket> rockets) throws Exception {
		if (id.isEmpty() || maxtime <= 0 || length <= 0 || rockets == null)
			throw new Exception("Wrong attributes set!");
	}

	/* getters and setters methods */
	public void addScoreToRocket(Rocket rocket) throws Exception {
		rocket.addScore(new Score(rocket, this, currentTime));
	}

	public int getCurrentTime() {
		return currentTime;
	}

	public List<Rocket> getRockets() {
		return rockets;
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

	public void doingRace(Rocket rocket) throws Exception {
		decideAction(rocket);
		currentTime += ConstantUtilities.DELAY;
	}

	private void decideAction(Rocket rocket) throws Exception {
		double acceleration = rocket.decideAction(currentTime, length, maxTime);
		rocket.setDesiredAcceleration(acceleration);
		rocket.addStrategy(acceleration);
	}

	public boolean isAWinner(Rocket rocket) throws Exception {
		return (rocket.getMetersTravelled() < length || rocket.getFuelTank().getActualFuel() <= 0);
	}

	public boolean raceIsGoing(Rocket rocket) {
		return currentTime < getMaxTime() && rocket.getMetersTravelled() < length && rocket.getActualFuel() != 0;
	}

	public void resetTime() {
		currentTime = 0;
	}

}
