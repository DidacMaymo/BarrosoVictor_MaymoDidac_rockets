package com.rockets.app.domain;

import java.util.ArrayList;

import java.util.List;

import com.rockets.app.utilities.ConstantUtilities;

public class Circuit {

	private String id;
	private int maxTime, currentTime = 0;
	private int length;
	private List<Rocket> rocket = new ArrayList<Rocket>();
	private Score bestScore;

	public Circuit(String id, int maxTime, int length, List<Rocket> rocket) throws Exception {
		validateAttributes(id, maxTime, length, rocket);
		this.id = id;
		this.maxTime = maxTime;
		this.length = length;
		this.rocket = rocket;
	}

	private void validateAttributes(String id, int maxtime, double length, List<Rocket> rockets) throws Exception {
		if (id.isEmpty() || maxtime <= 0 || length <= 0 || rockets == null)
			throw new Exception("Wrong attributes set!");
	}

	public double getCurrentTime() {
		return this.currentTime;
	}

	public double getMaxTime() {
		return this.maxTime;
	}

	public String getId() {
		return this.id;
	}

	public double getLength() {
		return this.length;
	}

	public void setCurrentTime(double time) {
		this.currentTime += time;
	}

	public void doingRace(Rocket rocket) throws Exception {
		rocket.setDesiredAcceleration(rocket.decideAction(currentTime, length, maxTime));
		currentTime += ConstantUtilities.DELAY;
	}

	public boolean raceIsGoing(Rocket rocket) {
		return (currentTime < getMaxTime() && rocket.getMetersTravelled() < length && rocket.getActualFuel() != 0);
	}

	public boolean isAWinner(Rocket rocket) throws Exception {
		if (rocket.getMetersTravelled() >= this.length && this.currentTime <= this.maxTime)
			if (isBestWinner(new Score(rocket, this.getCurrentTime(), rocket.getMetersTravelled()))) {
				return true;
			}
		return false;
	}

	public boolean isBestWinner(Score score) throws Exception {
		if (score.compareTo(bestScore) > 0) {
			bestScore = score;
			return true;
		}
		return false;
	}

	public List<Rocket> getRockets() {
		return rocket;
	}

	public void resetTime() {
		currentTime = 0;

	}

	public void setScore(Score score) throws Exception { 
		if(score==null) throw new Exception();
		bestScore = score;
	}

	public Score getScore() {
		// TODO Auto-generated method stub
		return bestScore;
	}

}
