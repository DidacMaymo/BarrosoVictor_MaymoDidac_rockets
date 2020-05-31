package domain;

import java.util.ArrayList;

import java.util.List;

import utilities.ConstantUtilities;

public class Circuit {

	private String id;
	private int maxTime, currentTime = 0;
	private int length;
	private Rocket winner;
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
		if (winner == null || isBestWinner(rocket)) {
			setWinner(rocket);
			bestScore = new Score(this.getCurrentTime(), rocket.getMetersTravelled());
			return true;
		}
		return false;
	}

	private boolean isBestWinner(Rocket rocket) throws Exception {
		Score score = new Score(this.getCurrentTime(), rocket.getMetersTravelled());
		if(score.getTimeTaken()  == bestScore.getTimeTaken()) {
			if(score.getMetersTravelled() > bestScore.getMetersTravelled()) {
				return true;
			}
		} else if (score.getTimeTaken() < bestScore.getTimeTaken()) {
			return true;
		}
		return false;
	}

	private void setWinner(Rocket r) {
		winner = r;
	}

	public Rocket getWinner() {
		return winner;
	}

	public List<Rocket> getRockets() {
		return rocket;
	}

	public void resetTime() {
		currentTime = 0;

	}

}
