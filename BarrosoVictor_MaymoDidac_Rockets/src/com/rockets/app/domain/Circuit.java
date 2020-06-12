package com.rockets.app.domain;

import java.util.ArrayList;

import java.util.List;

import com.rockets.app.application.dto.CircuitDTO;
import com.rockets.app.utilities.IObserver;
import com.rockets.app.utilities.ISubject;
import com.rockets.app.utilities.InvalidParamException;

public class Circuit implements ISubject {

	private List<IObserver> observers = new ArrayList<>();

	private String id;
	private int maxTime, currentTime = 0;
	private int length;
	private Score bestScore;

	public Circuit() {

	}

	public Circuit(String id, int maxTime, int length, List<Rocket> rocket) throws Exception {
		validateAttributes(id, maxTime, length, rocket);
		this.id = id;
		this.maxTime = maxTime;
		this.length = length;
	}

	private void validateAttributes(String id, int maxtime, double length, List<Rocket> rockets) throws Exception {
		if (id.isEmpty() || maxtime <= 0 || length <= 0 || rockets == null)
			throw new Exception("Wrong attributes set!");
	}

	public Circuit(CircuitDTO circuit) throws InvalidParamException {
		if (circuit == null)
			throw new InvalidParamException();
		this.id = circuit.getId();
		this.maxTime = circuit.getMaxTime();
		this.length = circuit.getLength();
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

	public Score getScore() {
		return bestScore;
	}

	public void increaseTime(double time) {
		this.currentTime += time;
	}

	public void generateSolutions(ArrayList<Rocket> rockets) throws Exception {
		for (Rocket r : rockets) {
			r.decideAction(this);
		}
	}

	public void doingRace(ArrayList<Rocket> rockets) throws Exception {
		notifyallObservers("Current time: " + (getCurrentTime() + 1));
		for (Rocket r : rockets) {
			r.setDesiredAcceleration(r.getAccelerationAtCurrentTime(currentTime));
			notifyallObservers(circuitInfo(r));
		}
		currentTime++;
	}

	public boolean raceIsGoing(ArrayList<Rocket> rockets) {
		for (Rocket rocket : rockets) {
			if (!(currentTime < getMaxTime() && rocket.getMetersTravelled() < length && rocket.getActualFuel() != 0)) {
				return false;
			}
		}
		return true;
	}

	public boolean raceIsGoing(Rocket rocket) {
		return (currentTime < getMaxTime() && rocket.getMetersTravelled() < length && rocket.getActualFuel() != 0);
	}

	public boolean isAWinner(Rocket rocket) throws Exception {
		if (rocket.getMetersTravelled() >= this.length && this.currentTime <= this.maxTime)
			if (isBestWinner(new Score(id, rocket.getId(), this.getCurrentTime(), rocket.getMetersTravelled()))) {
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

	public void startRace(ArrayList<Rocket> rockets) throws Exception {
		notifyallObservers("Starting competition. Circuit: " + getId() + ". Length: " + getLength() + " . Max time: "
				+ getMaxTime());
		while (raceIsGoing(rockets)) {
			doingRace(rockets);
		}
		printResult(rockets);
	}

	public String circuitInfo(Rocket rocket) {
		return ("\t" + rocket.getId() + " Acceleration: " + rocket.getAcceleration() + " Speed: " + rocket.getSpeed()
				+ " Distance: " + rocket.getMetersTravelled() + " Circuit: " + getLength() + " Fuel: "
				+ rocket.getActualFuel() + "/" + rocket.getFuelCapacity());
	}

	public void printResult(ArrayList<Rocket> rockets) throws Exception {
		Rocket winner = whichRocketWon(rockets);
		if (winner != null) {
			notifyallObservers("The rocket: " + winner.getId() + " with a time of " + currentTime + " won the race!\n");
			bestScore(winner);
		} else
			notifyallObservers("There is no winner!");

	}

	private Rocket whichRocketWon(ArrayList<Rocket> rockets) {
		Rocket winner = null;
		for (Rocket rocket : rockets) {
			if (rocket.getMetersTravelled() >= length) {
				if (winner == null)
					winner = rocket;
				else if (rocket.getMetersTravelled() > winner.getMetersTravelled())
					winner = rocket;
			}
		}
		return winner;
	}

	@Override
	public void addObserver(IObserver observer) throws InvalidParamException {
		if (observer == null)
			throw new InvalidParamException();
		this.observers.add(observer);
	}

	@Override
	public void notifyallObservers(String s) {
		for (IObserver observer : observers) {
			observer.update(s);
		}
	}

	public void bestScore(Rocket rocket) throws Exception {
		isBestWinner(new Score(this.id, rocket.getId(), currentTime, rocket.getMetersTravelled()));
		notifyallObservers("\nAnd the FINAL winner is: " + getScore().getRocketId() + " with a time of "
				+ getScore().getTimeTaken());
	}

}
