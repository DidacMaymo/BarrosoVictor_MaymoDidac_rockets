package domain;

import java.util.ArrayList;
import java.util.List;

import utilities.ConstantUtilities;

public class Rocket {

	private String id;
	private double speed = 0;
	private int metersTravelled = 0;
	private double acceleration = 0;
	private List<Propellant> propellants = new ArrayList<Propellant>();
	private FuelTank fueltank;
	private List<Score> scores = new ArrayList<Score>();
	private Strategy strategy;

	public Rocket(String id, List<Propellant> propellants, FuelTank fuelTank) throws Exception {
		validateAttributes(id, propellants, fuelTank);
		this.id = id;
		this.propellants = propellants;
		this.fueltank = fuelTank;
		this.strategy = new Strategy();
	}

	/* Validating attributes */
	private void validateAttributes(String id, List<Propellant> propellants, FuelTank fuelTank) throws Exception {
		if (id.isEmpty() || propellants.isEmpty() || fuelTank == null) {
			throw new Exception("Wrong attributes set!");
		}

	}

	/* getters and setters */
	public int getMetersTravelled() {
		return metersTravelled;
	}

	public double getMaxAcceleration() {
		double maxAcc = 0;
		for (Propellant p : propellants) {
			maxAcc += p.getMaxAcceleration();
		}
		return maxAcc;
	}

	public double getSpeed() {
		return speed;
	}

	public FuelTank getFuelTank() {
		return fueltank;
	}

	public double getAcceleration() {
		double acceleration = 0;
		for (Propellant p : propellants) {
			acceleration += p.getActualAcceleration();
		}
		return acceleration;
	}

	public String getId() {
		return this.id;
	}

	public void setAcceleration(double acceleration) {
		for (Propellant p : propellants) {
			p.setActualAcceleration(acceleration);
		}
	}

	/* Updating attributes */

	public void updateSpeed() { // speed of rocket right now. v = v0 + at
		this.speed += acceleration * ConstantUtilities.delay;
		fueltank.updateFuel(speed);
		updateMetersTravelled();
	}

	private void updateMetersTravelled() {
		metersTravelled += speed * ConstantUtilities.delay + 0.5 * acceleration * Math.pow(ConstantUtilities.delay, 2);
	}

	/* Race */
	public double decideAction(int currentTime, double length, double maxTime) {
		if (currentTime == 0)
			return length / maxTime;
		else if (currentTime < 5) {
			return 12;
		}
		return 0;
	}

	public void speedToAcceleration(double speed) {
		setAcceleration(0);
		while (getAcceleration() < speed) {
			setAcceleration(getAcceleration() + 1);
		}
		acceleration = this.getAcceleration();
		updateSpeed();
	}

	/* Adds score and strategy */
	public void addScore(Score score) {
		scores.add(score);
	}

	public void addStrategy(double acceleration) {
		strategy.addEstrategy(acceleration);
	}

}
