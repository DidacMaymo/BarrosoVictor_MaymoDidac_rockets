package domain;

public class FuelTank {

	double capacity;
	double actualFuel;

	public FuelTank(double capacity) throws Exception {
		super();
		if (!validateAttributes(capacity))
			throw new Exception("Invalid attribute!");
		this.capacity = capacity;
		this.actualFuel = capacity;
	}

	private boolean validateAttributes(double capacity) {
		if (capacity <= 0) {
			return false;
		}
		return true;
	}

	public void updateFuel(double speed) {
		actualFuel -= getFuelConsumption(speed);
		if (actualFuel < 0)
			actualFuel = 0;
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
