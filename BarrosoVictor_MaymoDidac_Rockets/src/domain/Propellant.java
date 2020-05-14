package domain;

public class Propellant {

	private double maxAcceleration, actualAcceleration = 0;
	private String id;

	public Propellant(double maxAcceleration, double actualAcceleration, String id) {
		this.maxAcceleration = maxAcceleration;
		this.actualAcceleration = actualAcceleration;
		this.id = id;
	}

	public Double getMaxAcceleration() {
		return maxAcceleration;
	}

	public Double getActualAcceleration() {
		return maxAcceleration;
	}

	public void setActualAcceleration(double newAcceleration) {
		if (actualAcceleration > maxAcceleration)
			actualAcceleration = maxAcceleration;
		this.actualAcceleration = newAcceleration;
	}

}
