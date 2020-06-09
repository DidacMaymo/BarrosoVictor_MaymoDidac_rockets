package application.dto;

import java.util.ArrayList;

import java.util.List;

import domain.Circuit;
import domain.Rocket;
import utilities.InvalidParamException;

public class CircuitDTO {

	private String id;
	private int maxTime;
	private int currentTime;
	private double length;
	private List<RocketDTO> rocketsDTO = new ArrayList<RocketDTO>();
	private ScoreDTO bestScore;

	public CircuitDTO(String id, int maxTime, int currentTime, double length, ArrayList<RocketDTO> rocketsDTO,
			ScoreDTO bestScore) throws InvalidParamException {
		this.id = id;
		this.maxTime = maxTime;
		this.currentTime = currentTime;
		this.length = length;
		this.rocketsDTO = rocketsDTO;
		this.bestScore = bestScore;

	}

	public CircuitDTO(Circuit circuit) throws InvalidParamException {
		if (circuit == null) {
			throw new InvalidParamException();
		}
		this.id = circuit.getId();
		this.maxTime = circuit.getMaxTime();
		this.currentTime = circuit.getCurrentTime();
		this.length = circuit.getLength();
		this.rocketsDTO = rocketsToRocketsDTO(circuit.getRockets());

	}

	private List<RocketDTO> rocketsToRocketsDTO(List<Rocket> list) throws InvalidParamException {
		List<RocketDTO> rocketsDTO = new ArrayList<RocketDTO>();
		for (Rocket rocket : list) {
			rocketsDTO.add(new RocketDTO(rocket));
		}
		return rocketsDTO;
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

	public int getCurrentTime() throws InvalidParamException {
		if (currentTime < 0 || currentTime > maxTime)
			throw new InvalidParamException();
		return currentTime;
	}

	public ArrayList<RocketDTO> getRocketsDTO() throws InvalidParamException {
		if (rocketsDTO == null || rocketsDTO.isEmpty())
			throw new InvalidParamException();
		return new ArrayList<>(rocketsDTO);
	}

	public ScoreDTO getBestScore() throws InvalidParamException {
		return bestScore;
	}
}
