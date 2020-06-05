package com.rockets.app.domain;

import javax.xml.crypto.Data;

import com.rockets.app.application.dto.ScoreDTO;
import com.rockets.app.utilities.ConstantUtilities;
import com.rockets.app.utilities.InvalidParamException;

public class Score {

	private double timeTaken;
	private int metersTravelled;
	private Rocket rocket;

	public Score() {

	}

	public Score(Rocket rocket, double timeTaken, int MetersTravelled) throws Exception {
		validateAttributes(rocket, timeTaken, MetersTravelled);
		this.rocket = rocket;
		this.timeTaken = timeTaken;
		this.metersTravelled = MetersTravelled;
	}

	public Score(ScoreDTO score) throws InvalidParamException {
		if(score==null)throw new InvalidParamException();
		this.metersTravelled=score.getMetersTravelled();
		this.timeTaken=score.getTimeTaken();
		this.rocket=score.getRocket();
	}

	private void validateAttributes(Rocket rocket, double time, double metersTravelled) throws Exception {
		if (time <= 0 || metersTravelled == 0) {
			throw new Exception();
		}
	}

	public double getTimeTaken() {
		return timeTaken;
	}

	public int getMetersTravelled() {
		return metersTravelled;
	}

	public Rocket getRocket() {
		return rocket;
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
