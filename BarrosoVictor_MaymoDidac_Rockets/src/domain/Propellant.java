package domain;

public class Propellant {

	private double maxAcceleration, actualAcceleration = 0;

	public Propellant(double maxAcceleration) throws Exception {
		validateAttributes(maxAcceleration);
		this.maxAcceleration = maxAcceleration;
	}

	/* Validating attributes */
	private void validateAttributes(double maxAcceleration) throws Exception {
		if (maxAcceleration <= 0)
			throw new Exception("Invalid attribute!");

	}

	/* getters and setters */
	public double getMaxAcceleration() {
		return maxAcceleration;
	}

	public double getActualAcceleration() {
		return actualAcceleration;
	}

	public double setActualAcceleration(double actualAcceleration) {
		if (actualAcceleration < 0)
			actualAcceleration = 0;
		if (actualAcceleration > maxAcceleration)
			actualAcceleration = maxAcceleration;
		return this.actualAcceleration = actualAcceleration;

	}

}
