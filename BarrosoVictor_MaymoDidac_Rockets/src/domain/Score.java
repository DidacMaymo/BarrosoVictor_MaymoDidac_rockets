package domain;

import java.time.LocalDate;

public class Score {

	String id;
	LocalDate date;
	double time;

	public Score(String id, double time) throws Exception {
		super();
		if (validateAttributes(id, time))
			throw new Exception("Wrong ID or time");
		this.id = id;
		this.time = time;
		this.date = java.time.LocalDate.now();
	}

	private boolean validateAttributes(String id, double time) {
		if (id.isEmpty() || time<=0) {
			return false;
		}
		return true;
	}

}
