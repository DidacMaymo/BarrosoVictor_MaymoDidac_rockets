package domain;

public class Propellant {
	
	private double maxAcceleration, actualAcceleration=0;
	private String id;
	public Propellant(double maxAcceleration, String id) {
		super();
		this.maxAcceleration = maxAcceleration;
		this.id = id;
	}
	public double getMaxAcceleration() {
		return maxAcceleration;
	}
	public void setActualAcceleration(double actualAcceleration) throws Exception {
		
		if (actualAcceleration>maxAcceleration)
			actualAcceleration = maxAcceleration;
		this.actualAcceleration = actualAcceleration;
		
	}

	
}

