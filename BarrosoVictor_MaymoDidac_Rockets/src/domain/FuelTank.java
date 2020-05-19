package domain;

public class FuelTank {

	private double fuelCapacity, actualFuel;


	public FuelTank(double capacity) throws Exception {
        super();
        validateAttributes(capacity);
        this.fuelCapacity = capacity;
        this.actualFuel = capacity;
    }
	private void validateAttributes(double capacity) throws Exception {
        if (capacity <= 0) {
        	throw new Exception();
        }
    }
	public void updateFuel(double speed) throws Exception {
        actualFuel -= getFuelConsumption(speed);
        if (actualFuel < 0)
            throw new Exception();
    }
	
	public double getFuelConsumption(double speed) {
		double consumpiton = 0.02 * Math.pow(speed, 2);
		return consumpiton;
	}

	public double getFuelCapacity() {
		return fuelCapacity;
	}

	public double getActualFuel() {
		return Math.round(actualFuel * 100) / 100;
	}

}
