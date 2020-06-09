package com.rockets.app.domain;

import java.util.ArrayList;


import java.util.List;
import java.util.Observer;

import com.rockets.app.application.dto.CircuitDTO;
import com.rockets.app.application.dto.RocketDTO;
import com.rockets.app.utilities.ConstantUtilities;
import com.rockets.app.utilities.IObserver;
import com.rockets.app.utilities.ISubject;
import com.rockets.app.utilities.InvalidParamException;


public class Circuit {

	private String id;
	private int maxTime, currentTime = 0;
	private int length;
	private List<Rocket> rocket = new ArrayList<Rocket>();
	private Score bestScore;
		
	public  Circuit (){

	}
	
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
	
	public Circuit(CircuitDTO circuit) throws InvalidParamException {
		if(circuit == null) throw new InvalidParamException();
		this.id=circuit.getId();
		this.maxTime=circuit.getMaxTime();
		this.length=circuit.getLength();
		this.rocket=rocketsDTOTorockets(circuit.getRocket());
	}
	
	private List<Rocket> rocketsDTOTorockets(List<RocketDTO> rocketsDTO) throws InvalidParamException {
        List<Rocket> rockets = new ArrayList<Rocket>();
        for (RocketDTO rocketDTO : rocketsDTO) {
            rockets.add(new Rocket(rocketDTO));
        }
        return rockets;
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
	public List<Rocket> getRocket() {
		return new ArrayList<>(rocket);
	}
	public Score getScore() {
		return bestScore;
	}

	public void increaseTime(double time) {
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
	
	public void resetTime() {
		currentTime = 0;

	}

}
