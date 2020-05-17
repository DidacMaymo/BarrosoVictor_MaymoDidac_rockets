package domain;

public class Strategy {

	public Strategy() {
		
	}
	
	public void decideAction(int actualTime, Rocket rocket, int limitTime, double length ) {
		if(actualTime==0) {
			speedToAcceleration(rocket, length/limitTime);
		}
		else if(true) {
			
		}
	}
	
	
	public void speedToAcceleration (Rocket rocket, double speed) {
		while(rocket.getAcceleration()<speed) {
			rocket.accelerate(rocket.getAcceleration()+1);
		}
		rocket.updateSpeed();
	}
	
	public boolean isViable() {
		
	}
	
	
	
}
