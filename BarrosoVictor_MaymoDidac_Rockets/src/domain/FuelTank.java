package domain;

public class FuelTank {

	double capacity;
	String id;
	double fuel;
	
	public FuelTank(double capacity, String id, double fuel) {
		this.capacity = capacity;
		this.id = id;
		this.fuel = fuel;
	}

	public void updateFuel(double fuel) {
		this.fuel=fuel;
	}

	public double getCapacity() {
		return capacity;
	}

	public double getFuel() {
		return fuel;
	}
	
}
