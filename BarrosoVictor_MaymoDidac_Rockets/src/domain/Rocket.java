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

	public void decideAction(double time) {
		if(time < ConstantUtilities.maxTime) {
			if(fueltank.getActualFuel() > 0) {
				if(metersTravelled < ConstantUtilities.length) {
					
				}//else ja has arribat a la meta
			}//else ja no pot correr més
		}//else no tens més temps
	}

}
