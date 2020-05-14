package domain;

public class Circuit {

	private static String id; // son necessaris els static?
	public static double maxTime, currentTime = 0; // time limit of race, and current time
	private static int length;
	private static Rocket rocket;

	public Circuit(String id, double limitTime, int distance) throws Exception {
		if (validAtributes(id, limitTime, distance)) {
			this.id = id;
			this.maxTime = limitTime;
			this.length = distance;
		}
	}

	public boolean validAtributes(String id, double limitTime, int distance) throws Exception {
		if (id != null && id != "") {
			throw new Exception("id not valid");
		}
		if (limitTime <= 0) {
			throw new Exception("limitTime not valid");
		}
		if (distance <= 0) {
			throw new Exception("distance not valid");
		}
		return true;
	}

	public void decideAction() {
		System.out.println("Starting competition. Circuit: " + id + ". Length: " + length + " . Max time: " + maxTime);
	}

	public Integer getLength() {
		return length;
	}

	public void updateRocketInfo() {

	}

	public void setCurrentTime(double time) {
		this.currentTime=time;
	}

	public void getActualSpeed() {

	}

	public void getFuelConsumption() {

	}

	public void getMetersTravelled() {

	}

}
