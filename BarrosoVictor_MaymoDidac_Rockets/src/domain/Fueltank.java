package domain;

public class Fueltank {

	double capacity, fuel;
	String id;
	
	public Fueltank(double capacity, double fuel, String id) {
		super();
		this.capacity = capacity;
		this.fuel = fuel;
		this.id = id;
	}
	
	public void updateFuel() {
		
	}

	public double getCapacity() {
		return capacity;
	}

	public double getFuel() {
		return fuel;
	}
	
	
	
}
