package com.rockets.app.application.dto;

import java.util.ArrayList;
import java.util.List;

import com.rockets.app.domain.FuelTank;
import com.rockets.app.domain.Propellant;
import com.rockets.app.domain.Rocket;
import com.rockets.app.utilities.InvalidParamException;

public class RocketDTO {
	
	private String id;
	private List<Propellant> propellants = new ArrayList<Propellant>();
	private FuelTank fueltank;
	
	
	public RocketDTO(List<Propellant> propellants, FuelTank fuelTank) throws Exception {
		validateAttributes( propellants, fuelTank);
		this.propellants = propellants;
		this.fueltank = fuelTank;
	}

	private void validateAttributes(List<Propellant> propellants, FuelTank fuelTank) throws Exception {
		if (propellants.isEmpty() || fuelTank == null)
			throw new Exception("Wrong attributes set!");
	}
	public RocketDTO(Rocket rocket) throws InvalidParamException {
		if(rocket==null) throw new InvalidParamException();
		this.id=rocket.getId();
		this.fueltank=rocket.getFuelTank();
	}

	public String getId() throws InvalidParamException {
		if (id == null || id.equals("")) throw new InvalidParamException();
		return id;
	}

	public List<Propellant> getPropellants() throws InvalidParamException {
		if(propellants==null) throw new InvalidParamException();
		return propellants;
	}

	public FuelTank getFueltank() throws InvalidParamException {
		if(fueltank==null) throw new InvalidParamException();
		return fueltank;
	}
	
	
}
