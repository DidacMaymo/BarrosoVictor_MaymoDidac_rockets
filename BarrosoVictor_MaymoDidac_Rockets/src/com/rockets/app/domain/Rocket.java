package com.rockets.app.domain;

import java.util.ArrayList;
import java.util.List;

import com.rockets.app.application.dto.RocketDTO;
import com.rockets.app.utilities.ConstantUtilities;
import com.rockets.app.utilities.InvalidParamException;

public class Rocket {

	private String id;
	private double speed = 0; // at start here counts as v0
	private double acceleration = 0;
	private int metersTravelled = 0;
	private List<Propellant> propellants = new ArrayList<Propellant>();
	private FuelTank fueltank;

	
	public List<Propellant> getPropellants() {
		return propellants;
	}

	public Rocket() {
		
	}
	
	public Rocket(String id, List<Propellant> propellants, FuelTank fuelTank) throws Exception {
		validateAttributes(id, propellants, fuelTank);
		this.id = id;
		this.propellants = propellants;
		this.fueltank = fuelTank;
	}
	
	public Rocket(RocketDTO rocket) throws InvalidParamException {
		if(rocket==null)throw new InvalidParamException();
		this.id=rocket.getId();
		this.fueltank=rocket.getFueltank();
	}
	public Rocket(Rocket rocket) {
        speed = rocket.getSpeed();
        acceleration = rocket.getAcceleration();
        metersTravelled = rocket.getMetersTravelled();
        propellants = rocket.getPropellants();
        fueltank = rocket.getFuelTank();
    }

	private void validateAttributes(String id, List<Propellant> propellants, FuelTank fuelTank) throws Exception {
		if (id.isEmpty() || propellants.isEmpty() || fuelTank == null)
			throw new Exception("Wrong attributes set!");
	}

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

	public double getActualFuel() {
		return fueltank.getActualFuel();
	}

	public String getId() {
		return this.id;
	}

	public void setAcceleration(double acceleration) {
		for (Propellant p : propellants) {
			p.setActualAcceleration(acceleration);
		}
	}

	public void updateSpeed() throws Exception { // speed of rocket right now. v = v0 + at
		this.speed += acceleration * ConstantUtilities.DELAY;
		fueltank.updateFuel(speed);
		updateMetersTravelled();
	}

	private void updateMetersTravelled() {
		metersTravelled += speed * ConstantUtilities.DELAY + 0.5 * acceleration * Math.pow(ConstantUtilities.DELAY, 2);
	}

	public double decideAction(int currentTime, double length, double maxTime) throws Exception {
		return Strategy.decideAction(this, currentTime, length, maxTime);
	}

	public void setDesiredAcceleration(double acceleration) throws Exception {
		setAcceleration(0);
		while (getAcceleration() < acceleration) {
			setAcceleration(getAcceleration() + 1);
		}
		this.acceleration = this.getAcceleration();
		updateSpeed();
	}

	public double getFuelCapacity() {
		// TODO Auto-generated method stub
		return fueltank.getCapacity();
	}
}