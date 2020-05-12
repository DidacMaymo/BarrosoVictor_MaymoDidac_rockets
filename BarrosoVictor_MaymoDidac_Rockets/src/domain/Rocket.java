package domain;

import java.util.ArrayList;
import java.util.List;

import com.vehicles.project.Wheel;

public class Rocket {

	private String id;
	private double speed;
	private double acceleration;
	private int metersTravelled;
	private List<Propellant> propellants = new ArrayList<Propellant>();
	
	public Rocket(String id, double speed, double acceleration, int metersTravelled) {
		super();
		this.id = id;
		this.speed = speed;
		this.acceleration = acceleration;
		this.metersTravelled = metersTravelled;
	}
	
	
	public int getMetersTravelled() {
		return metersTravelled;
	}
	public void setSpeed(double speed) {
		this.speed = speed;
	}
	
	
}
