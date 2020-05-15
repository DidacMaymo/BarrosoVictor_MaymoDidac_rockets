package domain;

import java.util.ArrayList;
import java.util.List;

public class Rocket {

	public String idRocket;
	private double speed = 0; // at start here counts as v0
	public double acceleration = 0;
	public int metersTravelled = 0;
	private List<Propellant> propellants = new ArrayList<Propellant>();
	public FuelTank fueltank;
	Score score;
	Circuit circuit;

	public Rocket(String id, List<Propellant> propellants, FuelTank fueltank) {
		this.idRocket = id;
		this.propellants = propellants;
		this.fueltank = fueltank;
	}

	
	public void setAcceleration(double acceleration) throws Exception {
		double acc = 0;
		for (Propellant p : propellants) {
			p.setActualAcceleration(acceleration);
			acc += p.getActualAcceleration();
		}
		setSpeed();
	}
	public void setSpeed() { // speed of rocket right now.
		this.speed += acceleration * circuit.currentTime;
		fueltank.updateFuel(speed);
		setMetersTravelled();
	}
	public void setMetersTravelled() { // x = xo + v*t + ½ a * t^2
		metersTravelled += speed + speed * circuit.currentTime + (acceleration / 2) * Math.pow(circuit.currentTime, 2);
	}

	
	public double getSpeed() {
		return speed;
	}
	
	public int getMetersTravelled() {
		return metersTravelled;
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

	public double getFuelConsumption() {
		return fueltank.getFuelConsumption(speed);
	}

	public void accelerateRocket(double whenAccelerate) {
		// and how much does it have to accelerate each time it wants to?
	}

	public void slowDown() {
		// how much?
	}
	
	public void decideAction(double time, int x) {
		if(x-this.metersTravelled < 100) {
			this.accelerateRocket(whenAccelerate);
		}
	}

}
