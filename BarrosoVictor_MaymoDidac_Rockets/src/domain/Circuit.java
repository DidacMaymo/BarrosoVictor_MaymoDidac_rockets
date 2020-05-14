package domain;

public class Circuit {

	private static String id;  //son necessaris els static?
	private static double maxTime;
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
		boolean end = false;
		while (!end) {

		}
	}

	public Integer getLength() {
		return length;
	}

	public Double getMaxTime() {
		return maxTime;

	}

	public void updateRocketInfo() {

	}

	public void getActualSpeed() {

	}

	public void getFuelConsumption() {

	}

	public void getMetersTravelled() {

	}

}
