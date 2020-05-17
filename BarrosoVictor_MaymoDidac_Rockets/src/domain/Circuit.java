package domain;

import java.time.Duration;
import java.time.Instant;

import utilities.ConstantUtilities;

public class Circuit {
	private String id;
	private int maxTime;
	private double length;
	private Rocket rocket;
	private int currentTime = 0;

	public Circuit(String id, int maxtime, double length, Rocket rocket) {
		super();
		this.id = id;
		this.maxTime = maxtime;
		this.length = length;
		this.rocket = rocket;
	}

	public void race() {
		System.out.println("Starting competition. Circuit: " + id + ". Length: " + length + " . Max time: " + maxTime);
		while (currentTime <= maxTime && rocket.getFuelTank().getActualFuel() > 0
				&& rocket.getMetersTravelled() <= length) {
			decideAction();
			circuitInfo();
			currentTime += ConstantUtilities.delay;
		}
		result();
	}

	public Integer getLimitTime() {
		return maxTime;
	}

	public Double getLenght() {
		return length;
	}

	public void decideAction() {
		double acceleration = rocket.decideAction(currentTime);
		rocket.speedToAcceleration(acceleration);

		// ara actualitzem les variables del rocket
	}

	private void circuitInfo() {
		System.out.println("Current time: " + (currentTime + 1) + " Acceleration: " + rocket.getAcceleration()
				+ " Speed: " + rocket.getSpeed() + " Distance: " + rocket.getMetersTravelled() + " Circuit: " + length
				+ " Fuel: " + rocket.getFuelTank().getActualFuel() + "/" + rocket.getFuelTank().getCapacity());
	}

	private void result() {
		if (rocket.getMetersTravelled() < length || rocket.getFuelTank().getActualFuel() <= 0)
			System.out.println("There is no winner");
		else if (rocket.getMetersTravelled() >= length) {
			System.out
					.println("And the winner is: " + ConstantUtilities.nameRocket1 + " with a time of " + currentTime);
		} else if (rocket.getFuelTank().getActualFuel() <= 0)
			System.out.println("");
	}
}
