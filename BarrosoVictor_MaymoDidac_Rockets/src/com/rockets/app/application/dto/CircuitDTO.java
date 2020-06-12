package com.rockets.app.application.dto;

import com.rockets.app.domain.Circuit;
import com.rockets.app.utilities.InvalidParamException;

public class CircuitDTO {

	private String id;
	private int maxTime;
	private int length;
	private ScoreDTO bestScore;

	public CircuitDTO(String id, int maxTime, int length) throws InvalidParamException {
		this.id = id;
		this.maxTime = maxTime;
		this.length = length;
	}

	public CircuitDTO(Circuit circuit) throws InvalidParamException {
		if (circuit == null)
			throw new InvalidParamException();
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

	public int getLength() throws InvalidParamException {
		if (length <= 0)
			throw new InvalidParamException();
		return length;
	}

	public ScoreDTO getBestScore() throws InvalidParamException {
		if (bestScore == null)
			throw new InvalidParamException();
		return bestScore;
	}

}
