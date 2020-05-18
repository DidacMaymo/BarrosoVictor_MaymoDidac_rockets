package domain;

public class Propellant {

	private double maxAcceleration, actualAcceleration = 0;

	public Propellant(double maxAcceleration) throws Exception {
        super();
        if (validateAttributes(maxAcceleration))
            throw new Exception("Invalid attributes!");
        this.maxAcceleration = maxAcceleration;
    }

    private boolean validateAttributes(double maxAcceleration) {
        if (maxAcceleration <= 0) {
            return false;
        }
        return true;
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
		if (newAcceleration > maxAcceleration)
			newAcceleration = maxAcceleration;
		this.actualAcceleration = newAcceleration;
	}
}
