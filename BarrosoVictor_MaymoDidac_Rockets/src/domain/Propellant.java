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

	public void setActualAcceleration(double newAcceleration) throws Exception {
		if(newAcceleration <0) throw new Exception ("Acceleration below 0 not valid");
		if (actualAcceleration > maxAcceleration)
			actualAcceleration = maxAcceleration;
		this.actualAcceleration = newAcceleration;
	}

}
