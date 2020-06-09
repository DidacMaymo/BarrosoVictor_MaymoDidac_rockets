package application.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import domain.Propellant;
import domain.Rocket;
import utilities.InvalidParamException;

public class RocketDTO {

	private String id;
	private List<PropellantDTO> propellants = new ArrayList<>();
	private FuelTankDTO fuelTank;

	public RocketDTO(String id, ArrayList<PropellantDTO> propellants, FuelTankDTO fuelTank) throws Exception {
		this.id = id;
		this.propellants = propellants;
		this.fuelTank = fuelTank;
	}

	public RocketDTO(Rocket rocket) {
		id = rocket.getId();
		propellants = propellantsToDTO(rocket.getPropellants());
		fuelTank = new FuelTankDTO(rocket.getFuelTank());

	}

	private List<PropellantDTO> propellantsToDTO(List<Propellant> propellants) {
		Iterator<Propellant> it = propellants.iterator();
		List<PropellantDTO> propellantsDTO = new ArrayList<>();
		while (it.hasNext()) {
			propellantsDTO.add(new PropellantDTO(it.next()));
		}
		return propellantsDTO;
	}

	public String getId() throws InvalidParamException {
		if (id == null || id.equals(""))
			throw new InvalidParamException();
		return id;
	}

	public FuelTankDTO getFuelTank() throws InvalidParamException {
		if (fuelTank == null) {
			throw new InvalidParamException();
		}
		return fuelTank;
	}

	public ArrayList<PropellantDTO> getPropellants() throws InvalidParamException {
		if (propellants == null || propellants.isEmpty())
			throw new InvalidParamException();
		return new ArrayList<>(propellants);
	}
}
