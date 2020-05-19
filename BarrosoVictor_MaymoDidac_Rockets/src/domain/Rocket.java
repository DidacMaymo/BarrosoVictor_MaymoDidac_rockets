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
		super();
		if (!validateAttributes(id, propellants, fuelTank))
			throw new Exception("Wrong attributes set!");

		this.id = id;
		this.propellants = propellants;
		this.fueltank = fuelTank;
		this.strategy = new Strategy();
	}

	private boolean validateAttributes(String id, List<Propellant> propellants, FuelTank fuelTank) {
		if (id.isEmpty() || propellants.isEmpty() || fuelTank == null) {
			return false;
		}
		return true;
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

	private void setMetersTravelled() {
		metersTravelled += speed * ConstantUtilities.delay + 0.5 * acceleration * Math.pow(ConstantUtilities.delay, 2);
	}

	/* Race */

	// This is the method that is being called by Strategy.decideAction and is the
	// one who will accelerate the rocket, the acceleration parameter is a real one
	// m/s^2)

	// This method accelerates all the propellants

	public void updateSpeed() {
		speed += acceleration * ConstantUtilities.delay;
		setMetersTravelled();
		fueltank.updateFuel(speed);
	}

	public double decideAction(int currentTime, double length, double maxTime) {
		if (currentTime == 0)
			return length / maxTime;
		else if (currentTime < 5) {
			return 12;
		}
		return 0;
	}

	/*
	 * public boolean tryAcceleration(double acc, double timeRemaining, double
	 * metersRemaining, double fuelRemaining) { double newSpeed = this.getSpeed() +
	 * acc * ConstantUtilities.delay; double newFuelConsumption =
	 * fueltank.getFuelConsumption(newSpeed); if (fuelRemaining - newFuelConsumption
	 * * timeRemaining >= 0) { if (this.metersTravelled + newSpeed * timeRemaining
	 * >= metersRemaining) { return true; // aqui es que amb la nova acceleracio
	 * arribariem a temps a la meta i amb la // gasolina. } } return false; }
	 */
	public void speedToAcceleration(double speed) {
		setAcceleration(0);
		while (getAcceleration() < speed) {
			setAcceleration(getAcceleration() + 1);
		}
		acceleration = this.getAcceleration();
		setSpeed();
	}

	public void setAcceleration(double acceleration) {
		for (Propellant p : propellants) {
			p.setActualAcceleration(acceleration);
		}
	}

	public void setSpeed() { // speed of rocket right now. v = v0 + at
		this.speed += acceleration * ConstantUtilities.delay;
		fueltank.updateFuel(speed);
		setMetersTravelled();
	}

	public void addScore(Score score) { 
		scores.add(score);
	}

	public void addStrategy(int time, double acceleration) {
		strategy.addEstrategy(time, acceleration);
	}

}
