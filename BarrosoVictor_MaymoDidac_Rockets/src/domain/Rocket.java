package domain;

import java.util.ArrayList;
import java.util.List;

import utilities.ConstantUtilities;

public class Rocket {

	public String idRocket;
	private double speed = 0; // at start here counts as v0
	public double acceleration = 0;
	public int metersTravelled = 0;
	private List<Propellant> propellants = new ArrayList<Propellant>();
	public FuelTank fueltank;

	public Rocket(String id, List<Propellant> propellants, FuelTank fueltank) {
		this.idRocket = id;
		this.propellants = propellants;
		this.fueltank = fueltank;
	}

	public void setAcceleration(double acceleration, int currentTime) throws Exception {
		for (Propellant p : propellants) {
			p.setActualAcceleration(acceleration);
		}
		setSpeed(currentTime);
	}

	public double getAcceleration() { // acceleration right now
		double acc = 0;
		for (Propellant p : propellants) {
			acc += p.getActualAcceleration();
		}
		return acc;
	}

	public double getMaxAcceleration() { // acceleration right now
		double maxAcc = 0;
		for (Propellant p : propellants) {
			maxAcc += p.getMaxAcceleration();
		}
		return maxAcc;
	}

	public void setSpeed(int currentTime) { // speed of rocket right now.
		this.speed += acceleration * currentTime;
		fueltank.updateFuel(speed);
		setMetersTravelled(currentTime);
	}

	public double getSpeed() {
		return speed;
	}

	public void setMetersTravelled(int currentTime) { // x = xo + v*t + ½ a * t^2
		metersTravelled += speed + speed * currentTime + (acceleration / 2) * Math.pow(currentTime, 2);
	}

	public int getMetersTravelled() {
		return metersTravelled;
	}

	public double getFuelConsumption() {
		return fueltank.getFuelConsumption(speed);
	}
	
	public double decideAction(double currentTime) {
		return 0;
	}

	/*public double decideAction(double currentTime) {
		double acceleration = 0; // create mtehod to get the new acceleration we are going to use
		if (suficientFuel(acceleration, currentTime, this.fueltank.getActualFuel() )) {

		}
		return acceleration;

	}

	private boolean suficientFuel(double acceleration, double currentTime, double currentFuel) {
		double newSpeed = this.speed, fuelWaste = ConstantUtilities.fuelTankCapacity - currentFuel,	metersTravelled = this.metersTravelled;
		for (double i = currentTime; currentTime < ConstantUtilities.maxTime
				&& metersTravelled <= ConstantUtilities.length && fuelWaste < ConstantUtilities.fuelTankCapacity; i++) {
			newSpeed += acceleration * currentTime;
			fuelWaste += fueltank.getFuelConsumption(newSpeed);
			metersTravelled += newSpeed + newSpeed * currentTime + (acceleration / 2) * Math.pow(currentTime, 2);
		}
		if (fuelWaste >= ConstantUtilities.fuelTankCapacity && metersTravelled >= ConstantUtilities.length) {
			return true;
		}
		return false;
	}
	*/
}
