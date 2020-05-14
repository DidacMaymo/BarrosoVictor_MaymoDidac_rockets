package domain;

import javax.xml.crypto.Data;

public class Score {

	public String id;
	public Data Date;
	public double time;
	public Rocket winner;
	
	public void registerScore() {
		
	}
	public Score(String id, Data date, double time) {
		super();
		this.id = id;
		Date = date;
		this.time = time;
	}
	public void setWinner(Rocket winner) {
		this.winner = winner;
	}
}
