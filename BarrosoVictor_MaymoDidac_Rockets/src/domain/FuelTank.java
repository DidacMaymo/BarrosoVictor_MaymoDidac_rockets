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

	/* Validating attributes */
	private boolean validateAttributes(double capacity) {
		if (capacity <= 0) {
			return false;
		}
		return true;
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
	public void updateFuel(double speed) {
		actualFuel -= getFuelConsumption(speed);
		if (actualFuel < 0)
			actualFuel = 0;
	}

}
