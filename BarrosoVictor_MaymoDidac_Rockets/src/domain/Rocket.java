package domain;

public class Rocket {

	String id;
	double speed;
	double acceleration;
	int metersTravelled;
	Score score;
	
	public Rocket(String id, double speed, double acceleration, int metersTravelled, Score score) {

		this.id = id;
		this.speed = speed;
		this.acceleration = acceleration;
		this.metersTravelled = metersTravelled;
		this.score = score;
	}

	public int getMetersTravelled() {
		return metersTravelled;
	}

	public void setSpeed(double speed) {
		this.speed = speed;
	}

	public void decideAction() {

	}

	

}
