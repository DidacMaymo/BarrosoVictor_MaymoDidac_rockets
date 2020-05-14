package domain;

public class FuelTank {

	private double capacity, fuel;
	String id;
		
	public FuelTank(double capacity, String id, double fuel) {
		this.capacity = capacity;
		this.id = id;
		this.fuel = fuel;
	}

	public void updateFuel(double speed) {
		this.fuel -= 0.02*Math.pow(speed, 2); //is math abs necessary?
	}

	public double getCapacity() {
		return capacity;
	}

	public double getFuel() {
		return fuel;
	}
	
}
