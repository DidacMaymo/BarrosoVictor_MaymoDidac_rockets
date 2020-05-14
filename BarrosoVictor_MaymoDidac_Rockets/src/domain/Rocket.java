package domain;

import java.util.ArrayList;
import java.util.List;

public class Rocket {

	private String idRocket;
	private double speed = 0; //here counts as v0
	private double acceleration = 0;
	private int metersTravelled = 0;
	private List<Propellant> propellants = new ArrayList<Propellant>();
	private FuelTank fueltank;
	Score score;
	Circuit circuit;

	public Rocket(String id,List<Propellant> propellants,
			FuelTank fueltank, Circuit circuit) {
		this.idRocket = id;
		this.propellants = propellants;
		this.fueltank = fueltank;
		this.circuit= circuit;
	}
	public double getAcceleration() {
		double acc = 0;
		for (Propellant p : propellants) {
			acc += p.getActualAcceleration();
		}
		return acc;
	}

	public int getMetersTravelled() { //x = xo + v*t + ½ a * t^2
		metersTravelled += speed + speed*circuit.currentTime+(acceleration/2)*Math.pow(circuit.currentTime, 2);
		return metersTravelled;
	}

	public void getActualSpeed() { // speed of rocket right now.
		this.speed += acceleration * circuit.currentTime;
	}
	
	public double getMaxAcceleration() { // acceleration right now
		double maxAcc = 0;
		for (Propellant p : propellants) {
			maxAcc += p.getMaxAcceleration();
		}
		return maxAcc;
	}
	public void accelerateRocket(double whenAccelerate) {
		// TODO Auto-generated method stub
		
	}
	public void changePropellantAccelertion(int i, double newAcceleration) throws Exception {
		propellants.get(i).setActualAcceleration(newAcceleration);
	}
	

	/*
	 * public void getFuelConsumption() {
	 * 
	 * }
	 */

}
