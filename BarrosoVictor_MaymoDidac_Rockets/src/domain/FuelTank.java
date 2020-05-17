package domain;

public class FuelTank {

	double capacity;
	double actualFuel;

	public FuelTank(double capacity) {
		super();
		this.capacity = capacity;
		this.actualFuel = capacity;
	}

	public void updateFuel(double speed) {
		actualFuel -= getFuelConsumption(speed);
	}

	public double getFuelConsumption(double speed) {
		return 0.02 * Math.pow(speed, 2);

	}

	public double getCapacity() {
		return capacity;
	}

	public double getActualFuel() {
		return actualFuel;
	}

}
