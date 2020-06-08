package application.dto;

import domain.Score;
import utilities.InvalidParamException;

public class ScoreDTO {

	private String rocketId;
	private double timeTaken;
	private double metersTravelled;

	public ScoreDTO(String rocketId, double timeTaken, double MetersTravelled) throws InvalidParamException {
		this.rocketId = rocketId;
		this.timeTaken = timeTaken;
		this.metersTravelled = MetersTravelled;
	}

	public ScoreDTO(Score score) {
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

}
