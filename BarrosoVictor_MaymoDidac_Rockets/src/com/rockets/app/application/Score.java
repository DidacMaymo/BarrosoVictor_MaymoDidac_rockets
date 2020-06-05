package com.rockets.app.application;

import javax.xml.crypto.Data;

import com.rockets.app.utilities.ConstantUtilities;

public class Score {

	private double timeTaken;
	private int metersTravelled;
	private Rocket winner;

	public Score(Rocket rocket, double timeTaken, int MetersTravelled) throws Exception {
		validateAttributes(rocket, timeTaken, MetersTravelled);
		this.winner = rocket;
		this.timeTaken = timeTaken;
		this.metersTravelled = MetersTravelled;
	}

	private void validateAttributes(Rocket rocket, double time, double metersTravelled) throws Exception {
		if (time <= 0 || metersTravelled == 0) {
			throw new Exception();
		}
	}

	public double getTimeTaken() {
		return timeTaken;
	}

	public double getMetersTravelled() {
		return metersTravelled;
	}
	
	public Rocket getRocket() {
		return winner;
	}

	public double compareTo(Object obj) {
        Score other = (Score) obj;
        if (obj == null)
            return 1;
        if (timeTaken < other.timeTaken)
            return 1;
        if (timeTaken == other.timeTaken) {
            return metersTravelled - other.metersTravelled;
        }
        return -1;
    }

}
