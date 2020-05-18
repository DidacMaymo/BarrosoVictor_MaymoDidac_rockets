package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import utilities.ConstantUtilities;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalTime;

public class Circuit {

	public String id;
	public int maxTime, currentTime = 0; // time limit of race, and current time
	public int length; // circuit distance
	private Rocket rocket;

	public Circuit(String id, int maxTime, int length, Rocket rocket) throws Exception {
		if (validAtributes(maxTime, length)) {
			this.id = id;
			this.maxTime = maxTime;
			this.length = length;
			this.rocket = rocket;
		}
	}

	public boolean validAtributes(double maxTime, int length) throws Exception {
		if (maxTime <= 0) {
			throw new Exception("maxTime of circuit not valid");
		}
		if (length <= 0) {
			throw new Exception("length of circuit not valid");
		}
		return true;
	}

	public void decideAction() throws Exception {
		double acceleration = rocket.decideAction(currentTime);
		rocket.speedToAcceleration(acceleration);
		//ara actualitzem les variables del rocket
	}
	
	public double getCurrentTime() {
		return this.currentTime;
	}
	
	public void setCurrentTime(double time) {
		this.currentTime += time;
	}
	public void winnerOrLoser() {
		if (rocket.getMetersTravelled() >= ConstantUtilities.length) {
			if (currentTime <= ConstantUtilities.maxTime) {
				//crear score
				System.out.println(ConstantUtilities.nameRocket1+" Your are a WINNER !! With a time of "+currentTime);
			} 		
		}else if (currentTime == ConstantUtilities.maxTime) {
			System.out.println("LOOOSEEER");
		}
	}

}
