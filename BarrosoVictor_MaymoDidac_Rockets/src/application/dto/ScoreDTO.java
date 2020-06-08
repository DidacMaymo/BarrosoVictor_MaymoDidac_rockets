package application.dto;

import domain.Score;
import utilities.InvalidParamException;

public class ScoreDTO {
	private String circuitId;
	private String rocketId;
	private double timeTaken;
	private double metersTravelled;

	public ScoreDTO(String circuitId, String rocketId, double timeTaken, double metersTravelled)
			throws InvalidParamException {

		this.circuitId = circuitId;
		this.rocketId = rocketId;
		this.timeTaken = timeTaken;
		this.metersTravelled = metersTravelled;
	}

	public ScoreDTO(Score score) {
		this.circuitId = score.getCircuitId();
		this.rocketId = score.getRocketId();
		this.timeTaken = score.getTimeTaken();
		this.metersTravelled = score.getMetersTravelled();
	}

	public String getRocketId() throws InvalidParamException {
		if (rocketId == null || rocketId.equals(""))
			throw new InvalidParamException();
		return rocketId;
	}

	public double getTimeTaken() throws InvalidParamException {
		if (timeTaken <= 0)
			throw new InvalidParamException();
		return timeTaken;
	}

	public double getMetersTravelled() throws InvalidParamException {
		if (metersTravelled <= 0)
			throw new InvalidParamException();
		return metersTravelled;
	}

	public String getCircuitId() throws InvalidParamException {
		if (circuitId == null || circuitId.equals(""))
			throw new InvalidParamException();
		return circuitId;
	}

}
