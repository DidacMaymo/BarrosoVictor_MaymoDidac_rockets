package domain;

import application.dto.ScoreDTO;
import utilities.InvalidParamException;

public class Score {

	private String rocketId;
	private double timeTaken;
	private double metersTravelled;

	public Score(String rocketId, double timeTaken, double MetersTravelled) throws InvalidParamException {
		if (rocketId == null || rocketId.equals(""))
			throw new InvalidParamException();
		if (timeTaken <= 0)
			throw new InvalidParamException();
		if (metersTravelled <= 0)
			throw new InvalidParamException();
		this.rocketId = rocketId;
		this.timeTaken = timeTaken;
		this.metersTravelled = MetersTravelled;
	}

	public Score(ScoreDTO score) throws InvalidParamException {
		this.rocketId = score.getRocketId();
		this.timeTaken = score.getTimeTaken();
		this.metersTravelled = score.getMetersTravelled();
	}

	public double getTimeTaken() {
		return timeTaken;
	}

	public double getMetersTravelled() {
		return metersTravelled;
	}

	public String getRocketId() {
		return rocketId;
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