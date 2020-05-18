package domain;

public class Score {

	public Rocket winner;
	public Circuit circuit;
	public double timeTaken;

	public Score(Rocket winner, Circuit circuit, double timeTaken) {
		if (validateAttributes(timeTaken, winner))
			this.winner = winner;
		this.circuit = circuit;
		this.timeTaken = timeTaken;
	}

	private boolean validateAttributes(double time, Rocket rocket) {
		if (time <= 0 || rocket == null) {
			return false;
		}
		return true;
	}

	public void setWinner(Rocket winner) {
		this.winner = winner;
	}

	public void displayScore() {
		System.out.println(winner.getId() + " Your are a WINNER !! With a time of " + timeTaken + " at: " + circuit);
	}
}