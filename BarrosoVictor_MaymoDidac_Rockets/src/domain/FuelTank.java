package domain;

public class FuelTank {

	double capacity;
	double actualFuel;

	public FuelTank(double capacity) throws Exception {
		validateAttributes(capacity);
		this.capacity = capacity;
		this.actualFuel = capacity;
	}

	/* Validating attributes */
	private void validateAttributes(double capacity) throws Exception {
		if (capacity <= 0)
			throw new Exception("Invalid attribute!");

	}

	/* getters and setters methods */
	public double getFuelConsumption(double speed) {
		return 0.02 * Math.pow(speed, 2);

	}

	public double getCapacity() {
		return capacity;
	}

	public double getActualFuel() {
		return actualFuel;
	}

	/* Updating attributes */
	public void updateFuel(double speed) throws Exception {
		actualFuel -= getFuelConsumption(speed);
		if (actualFuel < 0)
			throw new Exception("No fuel remainng!");
	}

}
