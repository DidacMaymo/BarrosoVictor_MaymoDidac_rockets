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
	private FuelTank fuelTank;
	private List<Score> scores = new ArrayList<Score>();

	public Rocket(String id, List<Propellant> propellants, FuelTank fuelTank) throws Exception {
		super();
		if (validateAttributes(id, propellants, fuelTank))
			throw new Exception("Wrong attributes set!");
		
		this.id = id;
		this.propellants = propellants;
		this.fuelTank = fuelTank;
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
		return fuelTank;
	}

	public double getAcceleration() {
		double acceleration = 0;
		for (Propellant p : propellants) {
			acceleration += p.getActualAcceleration();
		}
		return acceleration;
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
		fuelTank.updateFuel(speed);
	}

	public double decideAction(int currentTime) { // retorna la acceleracio que has decidit posar, pot ser 0 o >, no <
		for (double acc = this.getMaxAcceleration(); acc >= 0; acc--) { // comencem per la acceleracio mes alta
			if (tryAcceleration(acc, ConstantUtilities.maxTime - currentTime,
					ConstantUtilities.length - this.metersTravelled, this.fuelTank.getActualFuel())) {
				return acc;
			}
		}
		return 0;
	}

	public boolean tryAcceleration(double acc, double timeRemaining, double metersRemaining, double fuelRemaining) {
		double newSpeed = this.getSpeed() + acc * ConstantUtilities.delay;
		double newFuelConsumption = fuelTank.getFuelConsumption(newSpeed);
		if (fuelRemaining - newFuelConsumption * timeRemaining >= 0) {
			if (this.metersTravelled + newSpeed * timeRemaining >= metersRemaining) {
				return true; // aqui es que amb la nova acceleracio arribariem a temps a la meta i amb la
								// gasolina.
			}
		}
		return false;
	}

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
		fuelTank.updateFuel(speed);
		setMetersTravelled();
	}

	public void addScore(Score score) {
		scores.add(score);
	}
}
