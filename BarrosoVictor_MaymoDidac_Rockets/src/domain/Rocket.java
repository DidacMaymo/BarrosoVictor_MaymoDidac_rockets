package domain;

import java.util.ArrayList;
import java.util.List;

import utilities.ConstantUtilities;

public class Rocket {

	private String id;
	private double speed = 0;
	private double acceleration = 0;
	private int metersTravelled=0;
	private List<Propellant> propellants = new ArrayList<Propellant>();
	private FuelTank fuelTank;

	public Rocket(String id, List<Propellant> propellants, FuelTank fuelTank) {
		super();
		this.id = id;
		this.propellants = propellants;
		this.fuelTank = fuelTank;
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

	public void accelerate(double acceleration) {
		this.acceleration=0;
			for (Propellant p: propellants) {
				this.acceleration += p.setActualAcceleration(acceleration);
			}
	}
	
	public void updateSpeed() {
		speed += acceleration * ConstantUtilities.delay;
		setMetersTravelled();
		fuelTank.updateFuel(speed);
	}
	
	private void setMetersTravelled() {
		metersTravelled += speed*ConstantUtilities.delay + 0.5 * acceleration * Math.pow(ConstantUtilities.delay, 2);
	}
	
	public double getAcceleration() {
		return acceleration;
	}

	public double getSpeed() {
		return speed;
	}
		
	public FuelTank getFuelTank() {
		return fuelTank;
	}
	
	/*public void accelerate(double acceleration) {
		this.acceleration=0;
			for (Propellant p: propellants) {
				this.acceleration += p.setActualAcceleration(acceleration);
			}
			setSpeed();
	}
	
	private void setSpeed() {
		speed = speed + acceleration;
		setMetersTravelled();
		fuelTank.updateFuel(speed);
	} */
	

}
