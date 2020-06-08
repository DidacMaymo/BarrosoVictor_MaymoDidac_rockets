package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import application.dto.RocketDTO;
import utilities.ConstantUtilities;
import utilities.InvalidParamException;

public class Rocket {

	private String id;
	private double speed = 0; // at start here counts as v0
	private double acceleration = 0;
	private int metersTravelled = 0;
	private List<Propellant> propellants = new ArrayList<Propellant>();
	private FuelTank fuelTank;

	public Rocket(String id, List<Propellant> propellants, FuelTank fuelTank) throws InvalidParamException {
		if (id == null || id.equals(""))
			throw new InvalidParamException();
		if (propellants == null || propellants.isEmpty()) {
			throw new InvalidParamException();
		}
		if (speed < 0) {
			throw new InvalidParamException();
		}
		if (acceleration < 0) {
			throw new InvalidParamException();
		}
		this.id = id;
		this.propellants = propellants;
		this.fuelTank = fuelTank;
	}

	public Rocket(RocketDTO rocketDTO) throws InvalidParamException {
		id = rocketDTO.getId();
		speed = rocketDTO.getSpeed();
		acceleration = rocketDTO.getAcceleration();
		metersTravelled = rocketDTO.getMetersTravelled();
		propellants = createPropellants(rocketDTO.getMaxAcceleration(), rocketDTO.getActualAcceleration());
		fuelTank = new FuelTank(rocketDTO.getCapacity(), rocketDTO.getActualFuel());
	}

	private List<Propellant> createPropellants(List<Double> maxAcceleration, List<Double> actualAcceleration)
			throws InvalidParamException {
		Iterator<Double> maxAccIt = maxAcceleration.iterator();
		Iterator<Double> actualAccIt = actualAcceleration.iterator();
		List<Propellant> propellants = new ArrayList<>();
		while (maxAccIt.hasNext() && actualAccIt.hasNext()) {
			propellants.add(new Propellant(maxAccIt.next(), actualAccIt.next()));
		}
		return propellants;
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
		return fuelTank;
	}

	public double getAcceleration() {
		double acceleration = 0;
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

	public void setAcceleration(double acceleration) {
		for (Propellant p : propellants) {
			p.setActualAcceleration(acceleration);
		}
	}

	public void updateSpeed() throws Exception { // speed of rocket right now. v = v0 + at
		this.speed += acceleration * ConstantUtilities.DELAY;
		fuelTank.updateFuel(speed);
		updateMetersTravelled();
	}

	private void updateMetersTravelled() {
		metersTravelled += speed * ConstantUtilities.DELAY + 0.5 * acceleration * Math.pow(ConstantUtilities.DELAY, 2);
	}

	public double decideAction(int currentTime, double length, double maxTime) {
		return Strategy.decideAction(currentTime, length, maxTime);
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
		return fuelTank.getCapacity();
	}

	public List<Propellant> getPropellants() {
		return propellants;
	}

}
