package domain;

public class Circuit {

	private String id;
	private double limitTime, distance;
	
	
	
	public Circuit(String id, double limitTime, double distance) {
		super();
		this.id = id;
		this.limitTime = limitTime;
		this.distance = distance;
	}
//hoaosajdof
	
	
	public double getLimitTime() {
		return limitTime;
	}

	public double getDistance() {
		return distance;
	}


	public void decideAction() {
	
		
	}
	
	public void updateRocketInfo() {
		
	}
	
	
	
	
}
