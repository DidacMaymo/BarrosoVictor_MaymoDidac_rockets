package application.dto;

import domain.Circuit;
import utilities.InvalidParamException;

public class CircuitDTO {

	private String id;
	private int maxTime;
	private double length;
	private ScoreDTO bestScore;

	public CircuitDTO(String id, int maxTime, double length) throws InvalidParamException {
		this.id = id;
		this.maxTime = maxTime;
		this.length = length;

	}

	public CircuitDTO(Circuit circuit) throws InvalidParamException {
		if (circuit == null) {
			throw new InvalidParamException();
		}
		this.id = circuit.getId();
		this.maxTime = circuit.getMaxTime();
		this.length = circuit.getLength();

	}

	public String getId() throws InvalidParamException {
		if (id == null || id.equals(""))
			throw new InvalidParamException();
		return id;
	}

	public int getMaxTime() throws InvalidParamException {
		if (maxTime <= 0)
			throw new InvalidParamException();
		return maxTime;
	}

	public double getLength() throws InvalidParamException {
		if (length <= 0)
			throw new InvalidParamException();
		return length;
	}

	public ScoreDTO getBestScore() throws InvalidParamException {
		return bestScore;
	}
}
