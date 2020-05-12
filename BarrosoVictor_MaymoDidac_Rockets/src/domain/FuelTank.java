package domain;

public class FuelTank {

	double capacity;
	String id;
	double fuel;
	
	
	
	public FuelTank(double capacity, String id) {
		super();
		this.capacity = capacity;
		this.id = id;
		this.fuel = capacity;
	}

	public void updateFuel(double speed) {
		
		fuel -=  0.02 * Math.pow(Math.abs(speed), 2);
	}

	public double getCapacity() {
		return capacity;
	}

	public double getFuel() {
		return fuel;
	}
	
}
