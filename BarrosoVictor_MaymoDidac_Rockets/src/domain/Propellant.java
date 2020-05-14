package domain;

public class Propellant {

	private double maxAcceleration, actualAcceleration;
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
		 this.actualAcceleration = newAcceleration;
	}

}
