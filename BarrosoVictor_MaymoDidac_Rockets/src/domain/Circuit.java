package domain;

public class Circuit {
	private String id;
	private double maxTime;
	private int length;
	private Rocket rocket;
	
	public Circuit(String id, double maxtime, int length) {
		super();
		this.id = id;
		this.maxTime = maxtime;
		this.length = length;
	}
	public void addRocket(Rocket rocket) {
		this.rocket = rocket;
	}
	public void decideAction() {
		System.out.println("Starting competition. Circuit: "+ id +". Length: " + length + " . Max time: " + maxTime);
		boolean end=false;
		while (!end) {
			end = race(0);
		}
	}

	public Double getLimitTime() {
		return maxTime;
		
	}

	public Integer getDistance() {
		return length;
	}
	public void updateRocketInfo(double acceleration) {
		rocket.setAcceleration(acceleration);
	}
	
	public boolean race (double currentTime) {
		if (currentTime<maxTime) {
			
		}
		
	}
	public double askAcceleration() {
		
	}
}
