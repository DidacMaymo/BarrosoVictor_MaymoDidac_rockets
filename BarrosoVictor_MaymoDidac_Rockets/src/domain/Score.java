package domain;

import javax.xml.crypto.Data;

import utilities.ConstantUtilities;

public class Score {

	private Rocket winner;
	private Circuit circuit;
	private double timeTaken;

	public Score(Rocket winner, Circuit circuit, double timeTaken) throws Exception {
		validateAttributes(timeTaken, winner);
		this.winner = winner;
		this.circuit = circuit;
		this.timeTaken = timeTaken;
	}
	private void validateAttributes(double time, Rocket rocket) throws Exception {
        if (time <= 0 || rocket == null) {
        	throw new Exception();
        }
    }

	public void setWinner(Rocket winner) {
		this.winner = winner;
	}
	

	
}
