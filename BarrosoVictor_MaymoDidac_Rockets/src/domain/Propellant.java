package domain;

public class Propellant {

	private double maxAcceleration, actualAcceleration = 0;
	private String id;

	public Propellant(double maxAcceleration, String id) {
		super();
		this.maxAcceleration = maxAcceleration;
		this.id = id;
	}

	public double getMaxAcceleration() {
		return maxAcceleration;
	}

	public double setActualAcceleration(double actualAcceleration) {
		if (actualAcceleration < 0)
			actualAcceleration = 0;
		if (actualAcceleration > maxAcceleration)
			actualAcceleration = maxAcceleration;
		return this.actualAcceleration = actualAcceleration;

	}
	
	public double getActualAcceleration() {
		return actualAcceleration;
	}

}
