package domain;

public class Circuit {
	
	String id;
	double maxTtime;
	int length;
	Rocket rocket;

	public Circuit(String id, double limitTime, int distance) throws Exception {
		if (validAtributes(id, limitTime, distance)) {
			this.id = id;
			this.maxTtime = limitTime;
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


	public Integer getLength() {
		return length;
	}
	public Double getMaxLnegth() {
		return maxTtime;

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
