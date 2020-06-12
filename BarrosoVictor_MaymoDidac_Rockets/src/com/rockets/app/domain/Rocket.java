package com.rockets.app.domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import com.rockets.app.application.dto.PropellantDTO;
import com.rockets.app.application.dto.RocketDTO;
import com.rockets.app.utilities.ConstantUtilities;
import com.rockets.app.utilities.InvalidParamException;

public class Rocket {

	private String id;
	private double speed = 0;
	private double acceleration = 0;
	private int metersTravelled = 0;
	private List<Propellant> propellants = new ArrayList<Propellant>();
	private FuelTank fuelTank;
	private Strategy strategy;

	public Rocket(String id, List<Propellant> propellants, FuelTank fuelTank) throws Exception {
		validateAttributes(id, propellants, fuelTank);
		this.id = id;
		this.propellants = propellants;
		this.fuelTank = fuelTank;
	}

	public Rocket(RocketDTO rocketDTO) throws InvalidParamException {
		id = rocketDTO.getId();
		propellants = DTOToPropellants(rocketDTO.getPropellants());
		fuelTank = new FuelTank(rocketDTO.getFuelTank());
	}

	public Rocket(Rocket rocket) throws InvalidParamException {
		speed = rocket.speed;
		acceleration = rocket.acceleration;
		metersTravelled = rocket.metersTravelled;
		propellants = clonePropellants(rocket.propellants);
		fuelTank = new FuelTank(rocket.fuelTank);
	}

	private ArrayList<Propellant> clonePropellants(List<Propellant> propellants) {
		ArrayList<Propellant> ret = new ArrayList<>();
		for (Propellant propellant : propellants) {
			ret.add(new Propellant(propellant));
		}
		return ret;
	}

	private List<Propellant> DTOToPropellants(List<PropellantDTO> propellantsDTO) throws InvalidParamException {
		Iterator<PropellantDTO> it = propellantsDTO.iterator();
		List<Propellant> propellants = new ArrayList<>();
		while (it.hasNext()) {
			propellants.add(new Propellant(it.next()));
		}
		return propellants;
	}

	private void validateAttributes(String id, List<Propellant> propellants, FuelTank fuelTank) throws Exception {
		if (id.isEmpty() || propellants.isEmpty() || fuelTank == null)
			throw new Exception("Wrong attributes set!");
	}

	public int getMetersTravelled() {
		return metersTravelled;
	}

	public int getMaxAcceleration() {
		int maxAcc = 0;
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

	public int getAcceleration() {
		int acceleration = 0;
		for (Propellant p : propellants) {
			acceleration += p.getActualAcceleration();
		}
		return acceleration;
	}

	public double getActualFuel() {
		return fuelTank.getActualFuel();
	}

	public String getId() {
		return this.id;
	}

	public void setAcceleration(int acceleration) {
		for (Propellant p : propellants) {
			p.setActualAcceleration(acceleration);
		}
	}

	public List<Propellant> getPropellants() {
		return propellants;
	}

	public void acceleratePropellants(int acceleration) {
		for (Propellant p : propellants) {
			p.setActualAcceleration(acceleration);
		}
	}

	public void updateSpeed() throws Exception {
		this.speed += acceleration * ConstantUtilities.DELAY;
		updateFuel();
		updateMetersTravelled();
	}

	private void updateFuel() throws Exception {
		try {
			fuelTank.updateFuel(speed);
		} catch (Exception e) {
			speed = 0;
			acceleration = 0;
		}
	}

	private void updateMetersTravelled() {
		metersTravelled += speed * ConstantUtilities.DELAY + 0.5 * acceleration * Math.pow(ConstantUtilities.DELAY, 2);
	}

	public void setDesiredAcceleration(int acceleration) throws Exception {
		setAcceleration(0);
		while (getAcceleration() < acceleration) {
			setAcceleration(getAcceleration() + 1);
		}
		this.acceleration = this.getAcceleration();
		updateSpeed();
	}

	public void decideAction(Circuit circuit) throws Exception {
		strategy = new Strategy();
		strategy.backtracking(new ArrayList<Integer>(), 0, this, circuit.getLength(), circuit.getMaxTime());
	}

	public int getAccelerationAtCurrentTime(int currentTime) {
		return strategy.getAccelerationAtCurrentTime(currentTime);
	}

	public double getFuelCapacity() {
		// TODO Auto-generated method stub
		return fuelTank.getCapacity();
	}


	
	
	

	

}