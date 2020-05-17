package domain;

public class Strategy {

	public Strategy() {
		
	}
	
	public static void decideAction(int actualTime, Rocket rocket, int limitTime, double length ) {
		if(actualTime==1) {
			speedToAcceleration(rocket, 160);
		}
		else if(actualTime==2) {
			speedToAcceleration(rocket, 14);
		}
		else
			speedToAcceleration(rocket, 0);
		rocket.updateSpeed();
	}
	
	
	public static void speedToAcceleration (Rocket rocket, double speed) {
		rocket.accelerate(0);
		while(rocket.getAcceleration()<speed) {
			rocket.accelerate(rocket.getAcceleration()+1);
		}
		
	}
	
	
	
}
