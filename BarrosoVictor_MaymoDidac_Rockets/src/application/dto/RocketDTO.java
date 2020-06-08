package application.dto;

import java.util.ArrayList;
import java.util.List;
import domain.Rocket;
import utilities.InvalidParamException;

public class RocketDTO {

	private String id;
	private double speed = 0; // at start here counts as v0
	private double acceleration = 0;
	private int metersTravelled = 0;
	private List<Double> maxAcceleration = new ArrayList<Double>();
	private List<Double> actualAcceleration = new ArrayList<Double>();
	private double capacity;
	private double actualFuel;

	public RocketDTO(String id, List<Double> maxAcceleration, List<Double> actualAcceleration, double capacity,
			double actualFuel) throws Exception {
		this.id = id;
		this.maxAcceleration = maxAcceleration;
		this.actualAcceleration = actualAcceleration;
		this.capacity = capacity;
		this.actualFuel = actualFuel;
	}

	public RocketDTO(Rocket rocket) {
		id = rocket.getId();
		speed = rocket.getSpeed();
		acceleration = rocket.getAcceleration();
		metersTravelled = rocket.getMetersTravelled();
		// maxAcceleration = rocket.getMaxAcceleration();
		// actualAcceleration = rocket.getActualAcceleration();
		capacity = rocket.getFuelCapacity();
		actualFuel = rocket.getActualFuel();

	}

	public String getId() throws InvalidParamException {
		if (id == null || id.equals(""))
			throw new InvalidParamException();
		return id;
	}

	public List<Double> getMaxAcceleration() throws InvalidParamException {
		if (maxAcceleration == null || maxAcceleration.isEmpty())
			throw new InvalidParamException();
		return maxAcceleration;
	}

	public List<Double> getActualAcceleration() throws InvalidParamException {
		if (actualAcceleration == null || actualAcceleration.isEmpty())
			throw new InvalidParamException();
		return actualAcceleration;
	}

	public double getCapacity() throws InvalidParamException {
		if (capacity <= 0)
			throw new InvalidParamException();
		return capacity;
	}

	public double getActualFuel() throws InvalidParamException {
		if (actualFuel > capacity || actualFuel < 0)
			throw new InvalidParamException();
		return actualFuel;
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

}
