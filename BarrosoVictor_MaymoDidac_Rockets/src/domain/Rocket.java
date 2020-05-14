package domain;

import java.util.ArrayList;
import java.util.List;

public class Rocket {

	private String id;
	private double speed = 0;
	private double acceleration = 0;
	private int metersTravelled;
	private List<Propellant> propellants = new ArrayList<Propellant>();
	private FuelTank fueltank;
	Score score;
	Circuit circuit;

	public Rocket(String id, double speed, double acceleration, int metersTravelled, List<Propellant> propellants,
			FuelTank fueltank, Score score) {

		this.id = id;
		this.speed = speed;
		this.acceleration = acceleration;
		this.metersTravelled = metersTravelled;
		this.score = score;
		this.propellants = propellants;
		this.fueltank = fueltank;
	}

	public int getMetersTravelled() {
		return metersTravelled;
	}

	public void setSpeed(double speed) { //speed of rocket right now.
		this.speed += acceleration*circuit.currentTime ;
	}

	public void decideAction() {

	}

	public double getMaxAcceleration() { //acceleration right now 
		double maxAcc = 0;
		for (Propellant p : propellants) {
			maxAcc += p.getMaxAcceleration();
		}
		return maxAcc;
	}

}
