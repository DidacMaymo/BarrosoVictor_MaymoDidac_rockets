package domain;

public class Score {

	private Rocket winner;
	private Circuit circuit;
	private double timeTaken;

	public Score(Rocket winner, Circuit circuit, double timeTaken) throws Exception {
		validateAttributes(timeTaken, winner, circuit);
		this.winner = winner;
		this.circuit = circuit;
		this.timeTaken = timeTaken;
	}

	private void validateAttributes(double time, Rocket rocket, Circuit circuit) throws Exception {
		if (time <= 0 || rocket == null || circuit == null)
			throw new Exception("Wrong attributes set!");
	}

	public Rocket getWinner() {
		return winner;
	}

	public double getTimeTaken() {
		return timeTaken;
	}

}