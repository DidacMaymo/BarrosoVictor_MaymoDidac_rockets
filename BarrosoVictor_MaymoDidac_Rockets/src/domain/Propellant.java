package domain;

public class Propellant {

	private double maxAcceleration, actualAcceleration = 0;
	private String id;

	public Propellant(double maxAcceleration, String id) throws Exception {
		super();
		if (validateAttributes(maxAcceleration, id))
			throw new Exception ("Invalid attributes!");
		this.maxAcceleration = maxAcceleration;
		this.id = id;
	}
	private boolean validateAttributes(double maxAcceleration, String id) {
		if (id.isEmpty() ||maxAcceleration<=0) {
			return false;
		}
	  	return true;
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
