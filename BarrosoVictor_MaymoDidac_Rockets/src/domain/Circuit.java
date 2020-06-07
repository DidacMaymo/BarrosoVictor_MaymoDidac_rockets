package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import utilities.ConstantUtilities;

public class Circuit {

	private String id;
	private int maxTime, currentTime = 0;
	private int length;
	private Set<Rocket> rockets = new HashSet<Rocket>();
	private double 
	
	
	public Circuit(String id, int maxTime, int length) throws Exception {
		this.id = id;
		this.maxTime = maxTime;
		this.length = length;
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

	public void addRockets(ArrayList<Rocket> rockets) {
		this.rockets.addAll(rockets);

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
		return new ArrayList<>(rockets);
	}

	public void resetTime() {
		currentTime = 0;

	}

	public void setScore(Score score) {
		bestScore = score;
	}

	public Score getScore() {
		// TODO Auto-generated method stub
		return bestScore;
	}

}
