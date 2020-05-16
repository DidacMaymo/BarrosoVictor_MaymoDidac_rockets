package domain;

import java.time.Duration;
import java.time.Instant;

import utilities.ConstantUtilities;

public class Circuit {
	private String id;
	private int maxTime;
	private double length;
	private Rocket rocket;
	private int currentTime=0;
	public static Instant start;
	public static Instant end;
	public static Duration Interval;
	
	
	public Circuit(String id, int maxtime, double length, Rocket rocket) {
		super();
		this.id = id;
		this.maxTime = maxtime;
		this.length = length;
		this.rocket = rocket;
	}
	
	public void race() {
		System.out.println("Starting competition. Circuit: " + id + ". Length: " + length + " . Max time: " + maxTime);
		double end = 1;
		while (end >= 0) {
			end = decideAction();
			currentTime++;
		}
		
	}

	public Integer getLimitTime() {
		return maxTime;
	}

	public Double getLenght() {
		return  length;
	}
	
	public void updateRocketInfo(double acceleration) {
		rocket.setAcceleration(acceleration);
	}

	public double decideAction() {
		double acceleration = -1;
		if (currentTime < maxTime) {
			// acceleration = askAcceleration();
			updateRocketInfo(acceleration);
		}
		circuitInfo();
		result();
		return acceleration;

	}



	private void circuitInfo() {
		System.out.println("Current time: " + currentTime + " Acceleration: " + rocket.getAcceleration() + " Speed: "
				+ rocket.getSpeed() + " Distance: " + rocket.getMetersTravelled() + " Circuit: " + length + " Fuel: "
				+ rocket.getFuelTank().getActualFuel() + "/" + rocket.getFuelTank().getCapacity());
	}
	
	private void result(){
		if (currentTime == maxTime)
			System.out.println("There is no winner");
		else if(rocket.getMetersTravelled()>= length) {
			System.out.println("And the winner is: " + ConstantUtilities.nameRocket1 + " with a time of " + currentTime);
		}
		else if (rocket.getFuelTank().getActualFuel() <= 0)
			System.out.println("");
	}
}
