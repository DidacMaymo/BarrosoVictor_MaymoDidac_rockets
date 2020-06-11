package domain;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import application.dto.PropellantDTO;
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

	public void acceleratePropellants(double acceleration) {
		for (Propellant p : propellants) {
			p.setActualAcceleration(acceleration);
		}
	}

	public void updateSpeed() { // speed of rocket right now. v = v0 + at
		this.speed += acceleration * ConstantUtilities.DELAY;
	}

	private void updateMetersTravelled() {
		metersTravelled += speed * ConstantUtilities.DELAY + 0.5 * acceleration * Math.pow(ConstantUtilities.DELAY, 2);

	}

	public double decideAction(int currentTime, double length, double maxTime) {
		return Strategy.decideAction(currentTime, length, maxTime);
	}

	public void setDesiredAcceleration(double acceleration) throws InvalidParamException {
		acceleratePropellants(0);
		while (getAcceleration() < acceleration) {
			acceleratePropellants(getAcceleration() + 1);
		}
		this.acceleration = this.getAcceleration();
		updateSpeed();
		updateFuel();
		updateMetersTravelled();
	}

	public void revertChanges(int acceleration) throws InvalidParamException {
		fuelTank.updateFuel(speed);
		updateMetersTravelled();
		revertSpeed(acceleration);
	}

	private void revertSpeed(int acceleration) {
		this.speed -= acceleration * ConstantUtilities.DELAY;
	}

	public double getFuelCapacity() {
		// TODO Auto-generated method stub
		return fuelTank.getCapacity();
	}

	public List<Propellant> getPropellants() {
		return propellants;
	}

	private void updateFuel() throws InvalidParamException {
		try {
			fuelTank.updateFuel(speed);
		} catch (InvalidParamException e) {
			speed = 0;
			acceleration = 0;
		}
	}

}
