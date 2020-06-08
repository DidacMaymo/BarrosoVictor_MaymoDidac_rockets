package com.rockets.app.domain;

import java.util.ArrayList;

import java.util.List;

import com.rockets.app.application.dto.CircuitDTO;
import com.rockets.app.application.dto.RocketDTO;
import com.rockets.app.utilities.ConstantUtilities;
import com.rockets.app.utilities.InvalidParamException;

public class Circuit {

	private String id;
	private int maxTime, currentTime = 0;
	private int length;
	private List<RocketDTO> rocket = new ArrayList<RocketDTO>();
	private Score bestScore;
	
	public  Circuit (){

	}
	
	public Circuit(String id, int maxTime, int length, List<RocketDTO> rocket) throws Exception {
		validateAttributes(id, maxTime, length, rocket);
		this.id = id;
		this.maxTime = maxTime;
		this.length = length;
		this.rocket = rocket;
	}

	private void validateAttributes(String id, int maxtime, double length, List<RocketDTO> rockets) throws Exception {
		if (id.isEmpty() || maxtime <= 0 || length <= 0 || rockets == null)
			throw new Exception("Wrong attributes set!");
	}
	
	public Circuit(CircuitDTO circuit) throws InvalidParamException {
		if(circuit == null) throw new InvalidParamException();
		this.id=circuit.getId();
		this.maxTime=circuit.getMaxTime();
		this.length=circuit.getLength();
		this.rocket=circuit.getRocket();
	}

	public double getCurrentTime() {
		return this.currentTime;
	}

	public int getMaxTime() {
		return this.maxTime;
	}

	public String getId() {
		return this.id;
	}

	public int getLength() {
		return this.length;
	}
	public List<RocketDTO> getRocket() {
		return rocket;
	}
	public Score getScore() {
		// TODO Auto-generated method stub
		return bestScore;
	}

	public void increaseTime(double time) {
		this.currentTime += time;
	}
	public void setScore(Score score) throws Exception {
		if (score == null)
			throw new Exception();
		bestScore = score;
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
	
	public void resetTime() {
		currentTime = 0;

	}
	
	//seria necessari un update circuit¿?
}
