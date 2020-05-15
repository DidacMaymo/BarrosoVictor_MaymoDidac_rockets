package domain;

import Keyboard.*;

public class Circuit {
	private String id;
	private double maxTime;
	private int length;
	private Rocket rocket;

	public Circuit(String id, double maxtime, int length, Rocket rocket) {
		super();
		this.id = id;
		this.maxTime = maxtime;
		this.length = length;
		this.rocket = rocket;
	}
	
	public void race() {
		System.out.println("Starting competition. Circuit: " + id + ". Length: " + length + " . Max time: " + maxTime);
		double end = 1;
		int currentTime = 0;
		while (end >= 0) {
			end = decideAction(currentTime);
			circuitInfo(currentTime);
			currentTime++;
		}
	}

	public Double getLimitTime() {
		return maxTime;
	}

	public Integer getDistance() {
		return length;
	}

	public void updateRocketInfo(double acceleration) {
		rocket.setAcceleration(acceleration);
	}

	public double decideAction(int currentTime) {
		double acceleration = -1;
		if (currentTime < maxTime) {
			acceleration = askAcceleration();
			updateRocketInfo(acceleration);
		}
		return acceleration;

	}

	private double askAcceleration() {
		double acceleration = -1;
		while (acceleration < 0) {
			System.out.println("Enter the acceleration of the rocket (must be greater than 0");
			acceleration = Keyboard.readDouble();
		}
		return acceleration;
	}

	private void circuitInfo(int currentTime) {
		System.out.println("Current time: " + currentTime + " Acceleration: " + rocket.getAcceleration() + " Speed: "
				+ rocket.getSpeed() + " Distance: " + rocket.getMetersTravelled() + " Circuit: " + length + " Fuel: "
				+ rocket.getFuelTank().getActualFuel() + "/" + rocket.getFuelTank().getCapacity());
	}
}
