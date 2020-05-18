package domain;

import javax.xml.crypto.Data;

import utilities.ConstantUtilities;

public class Score {

	public Rocket winner;
	public Circuit circuit;
	public double timeTaken;

	public Score(Rocket winner, Circuit circuit, double timeTaken) {
		this.winner = winner;
		this.circuit = circuit;
		this.timeTaken = timeTaken;
	}

	public void setWinner(Rocket winner) {
		this.winner = winner;
	}

	public void displayScore() {
		System.out.println(winner.idRocket + " Your are a WINNER !! With a time of " + timeTaken + " at: "
				+ circuit);
	}
}
