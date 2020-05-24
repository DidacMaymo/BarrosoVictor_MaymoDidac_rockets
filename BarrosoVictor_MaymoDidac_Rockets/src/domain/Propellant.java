package domain;

public class Propellant {

	private double maxAcceleration, actualAcceleration = 0;

	public Propellant(double maxAcceleration) throws Exception {
       
        validateAttributes(maxAcceleration);
        this.maxAcceleration = maxAcceleration;
    }

    private void validateAttributes(double maxAcceleration) throws Exception {
        if (maxAcceleration <= 0) {
        	throw new Exception();
        }
    }
	public Double getMaxAcceleration() {
		return maxAcceleration;
	}

	public Double getActualAcceleration() {
		return actualAcceleration;
	}

	public void setActualAcceleration(double newAcceleration) {
		if (newAcceleration < 0)
			newAcceleration = 0;
		else if (newAcceleration > maxAcceleration)
			newAcceleration = maxAcceleration;
		this.actualAcceleration = newAcceleration;
	}
}
