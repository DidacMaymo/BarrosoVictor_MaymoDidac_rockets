package domain;

public class Score {

	public Rocket winner;
	public Circuit circuit;
	public double timeTaken;

	public Score(Rocket winner, Circuit circuit, double timeTaken) throws Exception {
		if (!validateAttributes(timeTaken, winner, circuit))
			throw new Exception("Invalid attributes");
		this.winner = winner;
		this.circuit = circuit;
		this.timeTaken = timeTaken;
	}
	
	/* Validating attributes */
	private boolean validateAttributes(double time, Rocket rocket, Circuit circuit) {
		if (time <= 0 || rocket == null || circuit == null) {
			return false;
		}
		return true;
	}

}