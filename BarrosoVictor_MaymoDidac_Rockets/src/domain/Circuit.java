package domain;

public class Circuit {
	private String id;
	private double maxTime;
	private int length;
	
	public Circuit(String id, double maxtime, int length) {
		super();
		this.id = id;
		this.maxTime = maxtime;
		this.length = length;
	}

	public void decideAction() {
		System.out.println("Starting competition. Circuit: "+ id +". Length: " + length + " . Max time: " + maxTime);
		boolean end=false;
		while (!end) {
			
		}
	}

	public Double getLimitTime() {
		return maxTime;
		
	}

	public Integer getDistance() {
		return length;
	}
	public void updateRocketInfo() {
		
	}
	
	public void race (double currentTime) {
		
	}
}
