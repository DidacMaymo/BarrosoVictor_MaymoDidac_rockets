package domain;

public class Propellant {

	private double maxAcceleration, actualAcceleration = 0;
	private String id;

	public Propellant(double maxAcceleration) {
		this.maxAcceleration = maxAcceleration;
		//this.id = id;
	}

	public Double getMaxAcceleration() {
		return maxAcceleration;
	}

	public Double getActualAcceleration() {
		return actualAcceleration;
	}

	public void setActualAcceleration(double newAcceleration)  {
		if (newAcceleration < 0)
			newAcceleration= 0 ; 
		if (newAcceleration > maxAcceleration)
			newAcceleration = maxAcceleration;
		this.actualAcceleration = newAcceleration;
	}
}
