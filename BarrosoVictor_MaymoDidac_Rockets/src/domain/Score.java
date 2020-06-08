package domain;

import application.dto.ScoreDTO;
import utilities.InvalidParamException;

public class Score {
	private String circuitId;
	private String rocketId;
	private double timeTaken;
	private double metersTravelled;

	public Score(String circuitId, String rocketId, double timeTaken, double metersTravelled)
			throws InvalidParamException {
		if (circuitId == null || circuitId.equals(""))
			throw new InvalidParamException();
		if (rocketId == null || rocketId.equals(""))
			throw new InvalidParamException();
		if (timeTaken <= 0)
			throw new InvalidParamException();
		if (metersTravelled <= 0)
			throw new InvalidParamException();
		this.circuitId = circuitId;
		this.rocketId = rocketId;
		this.timeTaken = timeTaken;
		this.metersTravelled = metersTravelled;
	}

	public Score(ScoreDTO score) throws InvalidParamException {
		this.circuitId = score.getCircuitId();
		this.rocketId = score.getRocketId();
		this.timeTaken = score.getTimeTaken();
		this.metersTravelled = score.getMetersTravelled();
	}

	public String getCircuitId() {
		return circuitId;
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