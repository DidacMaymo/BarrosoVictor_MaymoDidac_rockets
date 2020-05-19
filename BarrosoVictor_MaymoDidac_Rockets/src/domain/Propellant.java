package domain;

public class Propellant {

	private double maxAcceleration, actualAcceleration = 0;

	public Propellant(double maxAcceleration) throws Exception {
		super();
		if (!validateAttributes(maxAcceleration))
			throw new Exception("Invalid attributes!");
		this.maxAcceleration = maxAcceleration;
	}

	/* Validating attributes */
	private boolean validateAttributes(double maxAcceleration) {
		if (maxAcceleration <= 0) {
			return false;
		}
		return true;
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
