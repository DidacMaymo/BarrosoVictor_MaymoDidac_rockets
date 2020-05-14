package domain;

public class FuelTank {

	private double Fuelcapacity, Actualfuel;
	//String id;
		
	public FuelTank(double capacity) {
		this.Fuelcapacity = capacity;
		Actualfuel = Fuelcapacity;
	}

	public void updateFuel(double speed) {
		this.Actualfuel -= 0.02*Math.pow(speed, 2); //is math abs necessary?
	}

	public double getFuelCapacity() {
		return Fuelcapacity;
	}

	public double getActualFuel() {
		return Actualfuel;
	}
	
}
