package application.dto;

import java.util.ArrayList;

import java.util.List;

import domain.Circuit;
import domain.Rocket;
import domain.Score;
import utilities.InvalidParamException;

public class CircuitDTO {

	private String id;
	private int maxTime;
	private double length;
	private List<RocketDTO> rocketsDTO = new ArrayList<RocketDTO>();
	private String scoreRocketId;
	private double scoreTimeTaken;
	private double scoreMetersTravelled;
	private ScoreDTO bestScore;

	public CircuitDTO(String id, int maxTime, double length, ArrayList<RocketDTO> rocketsDTO, String scoreRocketId,
			double scoreTimeTaken, double scoreMetersTravelled) throws InvalidParamException {
		this.id = id;
		this.maxTime = maxTime;
		this.length = length;
		this.rocketsDTO = rocketsDTO;
		this.scoreRocketId = scoreRocketId;
		this.scoreTimeTaken = scoreTimeTaken;
		this.scoreMetersTravelled = scoreMetersTravelled;

	}

	public CircuitDTO(Circuit circuit) throws InvalidParamException {
		if (circuit == null) {
			throw new InvalidParamException();
		}
		this.id = circuit.getId();
		this.maxTime = circuit.getMaxTime();
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

	public ArrayList<RocketDTO> getRocketsDTO() throws InvalidParamException {
		if (rocketsDTO == null || rocketsDTO.isEmpty())
			throw new InvalidParamException();
		return new ArrayList<>(rocketsDTO);
	}

	public String getScoreRocketId() throws InvalidParamException {
		if (scoreRocketId == null || scoreRocketId.equals(""))
			throw new InvalidParamException();
		return scoreRocketId;
	}

	public double getScoreTimeTaken() throws InvalidParamException {
		if (scoreTimeTaken <= 0)
			throw new InvalidParamException();
		return scoreTimeTaken;
	}

	public double getScoreMetersTravelled() throws InvalidParamException {
		if (scoreMetersTravelled < length)
			throw new InvalidParamException();
		return scoreMetersTravelled;
	}

	public ScoreDTO getBestScore() throws InvalidParamException {
		if (bestScore == null)
			throw new InvalidParamException();
		return bestScore;
	}
}
