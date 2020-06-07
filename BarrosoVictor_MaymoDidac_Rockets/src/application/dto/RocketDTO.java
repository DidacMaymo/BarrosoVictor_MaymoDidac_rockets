package application.dto;

import java.util.ArrayList;
import java.util.List;

import domain.FuelTank;
import domain.Propellant;
import domain.Rocket;
import utilities.InvalidParamException;

public class RocketDTO {

	private String id;
	private double speed = 0; // at start here counts as v0
	private double acceleration = 0;
	private int metersTravelled = 0;
	private List<Propellant> propellants = new ArrayList<Propellant>();
	private FuelTank fuelTank;

	public RocketDTO(String id, List<Propellant> propellants, FuelTank fuelTank) throws Exception {
		this.id = id;
		this.propellants = propellants;
		this.fuelTank = fuelTank;
	}

	public RocketDTO(Rocket rocket) {
		id = rocket.getId();
		speed = rocket.getSpeed();
		acceleration = rocket.getAcceleration();
		metersTravelled = rocket.getMetersTravelled();
		propellants = rocket.getPropellants();
		fuelTank = rocket.getFuelTank();
	}

	public String getId() throws InvalidParamException {
		if (id == null || id.equals(""))
			throw new InvalidParamException();
		return id;
	}

	public List<Propellant> getPropellants() throws InvalidParamException {
		if (propellants == null || propellants.isEmpty()) {
			throw new InvalidParamException();
		}
		return propellants;
	}

	public double getSpeed() throws InvalidParamException {
		if (speed < 0) {
			throw new InvalidParamException();
		}

		return speed;
	}

	public double getAcceleration() throws InvalidParamException {
		if (acceleration < 0) {
			throw new InvalidParamException();
		}
		return acceleration;
	}

	public int getMetersTravelled() throws InvalidParamException {
		if (metersTravelled < 0) {
			throw new InvalidParamException();
		}
		return metersTravelled;
	}

	public FuelTank getFuelTank() throws InvalidParamException {
		if (fuelTank == null) {
			throw new InvalidParamException();
		}
		return fuelTank;
	}

}
