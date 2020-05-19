package domain;

public class Score {

	public Rocket winner;
	public Circuit circuit;
	public double timeTaken;

	public Score(Rocket winner, Circuit circuit, double timeTaken) throws Exception {
		validateAttributes(timeTaken, winner, circuit);
		this.winner = winner;
		this.circuit = circuit;
		this.timeTaken = timeTaken;
	}

	/* Validating attributes */
	private void validateAttributes(double time, Rocket rocket, Circuit circuit) throws Exception {
		if (time <= 0 || rocket == null || circuit == null)
			throw new Exception("Wrong attributes set!");

	}

}