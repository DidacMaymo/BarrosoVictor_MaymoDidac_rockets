package com.rockets.app.application.dto;

import com.rockets.app.domain.Rocket;
import com.rockets.app.domain.Score;
import com.rockets.app.utilities.InvalidParamException;

public class ScoreDTO {

	
	private double timeTaken;
	private int metersTravelled;
	private Rocket rocket;
	
	public ScoreDTO(Rocket rocket, double timeTaken, int MetersTravelled) throws Exception {
		validateAttributes(rocket, timeTaken, MetersTravelled);
		this.rocket = rocket;
		this.timeTaken = timeTaken;
		this.metersTravelled = MetersTravelled;
	}
	private void validateAttributes(Rocket rocket, double time, double metersTravelled) throws Exception {
		if (time <= 0 || metersTravelled == 0) {
			throw new Exception();
		}
	}
	public ScoreDTO(Score score) throws InvalidParamException {
		if(score==null) throw new InvalidParamException();
		this.metersTravelled=score.getMetersTravelled();
		this.timeTaken=score.getTimeTaken();
		this.rocket=score.getRocket();
	}
	public double getTimeTaken() throws InvalidParamException {
		if (timeTaken==0)
			throw new InvalidParamException();
		return timeTaken;
	}
	public int getMetersTravelled() throws InvalidParamException {
		if (metersTravelled==0)
			throw new InvalidParamException();
		return metersTravelled;
	}
	public Rocket getRocket() throws InvalidParamException {
		if (rocket==null)
			throw new InvalidParamException();
		return rocket;
	}
}
