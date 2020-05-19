package domain;

import java.util.ArrayList;

import java.util.List;

import utilities.ConstantUtilities;

public class Rocket {

	private String idRocket;
	private double speed = 0; // at start here counts as v0
	private double acceleration = 0;
	private int metersTravelled = 0;
	private List<Propellant> propellants = new ArrayList<Propellant>();
	private FuelTank fueltank;
	private Estrategy estrategy = new Estrategy();


	public Rocket(String id, List<Propellant> propellants, FuelTank fueltank) throws Exception {
		if (validateAttributes(propellants, fueltank)) {
			this.idRocket = id;
			this.propellants = propellants;
			this.fueltank = fueltank;
		}
	}

	private boolean validateAttributes(List<Propellant> propellants, FuelTank fuelTank) throws Exception {
        if ( propellants.isEmpty() || fuelTank == null) {
        	throw new Exception();
        }
        return true;
    }

	public void setAcceleration(double acceleration) {
		for (Propellant p : propellants) {
			p.setActualAcceleration(acceleration);
		}
	}

	public double getAcceleration() {
		double acc = 0;
		for (Propellant p : propellants) {
			acc += p.getActualAcceleration();
		}
		return acc;
	}

	public double getMaxAcceleration() {
		double maxAcc = 0;
		for (Propellant p : propellants) {
			maxAcc += p.getMaxAcceleration();
		}
		return maxAcc;
	}

	public void updateSpeed() { // v = v0 + at
		this.speed += acceleration * ConstantUtilities.delay;
		fueltank.updateFuel(speed);
		updateMetersTravelled();
	}

	public double getSpeed() {
		return speed;
	}
	public String getId() {
		return this.idRocket;
	}

	public void updateMetersTravelled() { // x = xo + v*t + ½ a * t^2
		metersTravelled += speed * ConstantUtilities.delay + (acceleration / 2) * Math.pow(ConstantUtilities.delay, 2);
	}

	public int getMetersTravelled() {
		return metersTravelled;
	}

	public double getFuelConsumption() {
		return fueltank.getFuelConsumption(speed);
	}
	
	 public double decideAction(int currentTime, double maxTime,double length) {
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
	public void addStrategy(double acceleration) {
        estrategy.addEstrategy(acceleration);
    }

	public FuelTank getFuelTank() {
		// TODO Auto-generated method stub
		return this.fueltank;
	}

}
