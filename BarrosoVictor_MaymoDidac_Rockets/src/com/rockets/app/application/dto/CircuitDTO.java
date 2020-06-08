package com.rockets.app.application.dto;

import java.util.ArrayList;
import java.util.List;

import com.rockets.app.domain.Circuit;
import com.rockets.app.domain.Rocket;
import com.rockets.app.domain.Score;
import com.rockets.app.utilities.InvalidParamException;

public class CircuitDTO {

	private String id;
	private int maxTime;
	private int length;
	private List<RocketDTO> rocket = new ArrayList<RocketDTO>();
	private Score bestScore;

	public CircuitDTO(String id,int maxTime, int length, List<RocketDTO> rocket) throws InvalidParamException {
		this.id=id;
		this.maxTime = maxTime;
		this.length = length;
		this.rocket=rocket;
	}

	public CircuitDTO(Circuit circuit) throws InvalidParamException {
		if (circuit == null)
			throw new InvalidParamException();
		this.id = circuit.getId();
		this.maxTime = circuit.getMaxTime();
		this.length = circuit.getLength();
		this.rocket = rocketsToRocketsDTO(circuit.getRocket());
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
		if (maxTime == 0)
			throw new InvalidParamException();
		return maxTime;
	}

	public int getLength() throws InvalidParamException {
		if (length == 0)
			throw new InvalidParamException();
		return length;
	}

	public List<RocketDTO> getRocket() throws InvalidParamException {
		if (rocket == null)
			throw new InvalidParamException();
		return new ArrayList<>(rocket);
	}

	public Score getBestScore() throws InvalidParamException {
		if (bestScore == null)
			throw new InvalidParamException();
		return bestScore;
	}

	@Override
	public String toString() {
		return "CircuitDTO [id=" + id + ", maxTime=" + maxTime + ", length=" + length + ", rocket=" + rocket
				+ ", bestScore=" + bestScore + "]";
	}

}
