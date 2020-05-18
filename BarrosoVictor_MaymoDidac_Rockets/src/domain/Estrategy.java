package domain;

import java.util.ArrayList;
import java.util.List;

public class Estrategy {

	public Rocket rocket;
	public List<String> accions = new ArrayList();

	public Estrategy(Rocket rocket) {
		this.rocket = rocket;
	}

	public void addEstrategy(int time, double acceleration) {
		accions.add(
				"For time: " + time + " rocket " + this.rocket.idRocket + "Has decided to accelerate: " + acceleration);
	}

}
