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
	public int maxTime, currentTime = 0;
	public int length;
	private Rocket rocket;
	private List<Score> score = new ArrayList<Score>();

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
		double acceleration = rocket.decideAction(currentTime, maxTime, length);
		rocket.speedToAcceleration(acceleration);
	}

	public double getCurrentTime() {
		return this.currentTime;
	}

	public void setCurrentTime(double time) {
		this.currentTime += time;
	}
	public void result() throws Exception {
        if (rocket.getMetersTravelled() < length)
            lose();
        else if (rocket.getMetersTravelled() >= length) {
            win();
        }
    }

    private void win() throws Exception {
        System.out.println("And the winner is: " + rocket.getId() + " with a time of " + currentTime);
        score.add(new Score(rocket, this, currentTime));
    }

    private void lose() {
        System.out.println("There is no winner");
    }

}
