package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import application.dto.CircuitDTO;
import application.dto.RocketDTO;
import persistance.ScoresRepository;
import utilities.ConstantUtilities;
import utilities.InvalidParamException;

public class Circuit {

	private String id;
	private int maxTime, currentTime = 0;
	private double length;
	private Score bestScore;

	public Circuit(CircuitDTO circuitDTO) throws InvalidParamException {
		if (circuitDTO == null) {
			throw new InvalidParamException();
		}
		this.id = circuitDTO.getId();
		this.maxTime = circuitDTO.getMaxTime();
		this.length = circuitDTO.getLength();
		bestScore = getBestScoreFromDB();
	}

	private Score getBestScoreFromDB() {
		try {
			return ScoresRepository.getScore(id);
		} catch (Exception e) {
			return null;
		}
	}

	public Circuit(String id, int maxTime, int length) throws InvalidParamException {
		if (id == null || id.equals(""))
			throw new InvalidParamException();
		if (maxTime <= 0)
			throw new InvalidParamException();
		if (length <= 0)
			throw new InvalidParamException();

		this.id = id;
		this.maxTime = maxTime;
		this.length = length;
	}

	public int getCurrentTime() {
		return this.currentTime;
	}

	public int getMaxTime() {
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
			if (isBestWinner(new Score(rocket.getId(), this.getCurrentTime(), rocket.getMetersTravelled()))) {
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

	public void setScore(Score score) {
		bestScore = score;
	}

	public Score getScore() {
		return bestScore;
	}

}
