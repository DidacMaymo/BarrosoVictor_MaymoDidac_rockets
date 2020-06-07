package application.dto;

import domain.Circuit;
import utilities.InvalidParamException;

public class CircuitDTO {

	private String id;
	private int maxTime;
	private int length;

	public CircuitDTO(String id, int maxTime, int length) throws Exception {
		this.id = id;
		this.maxTime = maxTime;
		this.length = length;
	}

	public CircuitDTO(Circuit circuit) throws InvalidParamException {
		if (circuit == null) {
			throw new InvalidParamException();
		}

	}

}
