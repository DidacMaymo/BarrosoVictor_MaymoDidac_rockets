package domain;

import java.util.ArrayList;
import java.util.List;

public class Circuit {

	private String id; 
	public  double maxTime, currentTime = 0; //time limit of race, and current time
	private int length; 					 //circuit distance
	private List<Rocket> rockets = new ArrayList<Rocket>(); //Rockets that participate in race
	Rocket winner;
	
	public Circuit(String id, double maxTime, int length) throws Exception {
		if (validAtributes(id, maxTime, length)) {
			this.id = id;
			this.maxTime = maxTime;
			this.length = length;
		}
	}

	public boolean validAtributes(String id, double maxTime, int length) throws Exception {
		if (id != null && id != "") {
			throw new Exception("id of circuit not valid");
		}
		if (maxTime <= 0) {
			throw new Exception("maxTime of circuit not valid");
		}
		if (length <= 0) {
			throw new Exception("length of circuit not valid");
		}
		return true;
	}

	public void decideAction() { //each second of race this method is executed.
		System.out.println("Starting competition. Circuit: " + id + ". Length: " + length + " . Max time: " + maxTime);
		//Does rocket want to accelerate (and when), same speed or slow down.
	}

	public Integer getLength() {
		return length;
	}

	public void updateRocketInfo() {

	}

	public void setCurrentTime(double time) {
		this.currentTime=time;
	}

}
