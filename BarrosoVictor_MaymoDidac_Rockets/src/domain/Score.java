package domain;

public class Score {

	private Rocket rocket;
	private double timeTaken;
	private double metersTravelled;

	public Score(Rocket rocket, double timeTaken, double MetersTravelled) throws Exception {
		validateAttributes(rocket, timeTaken, MetersTravelled);
		this.rocket = rocket;
		this.timeTaken = timeTaken;
		this.metersTravelled = MetersTravelled;
	}

	private void validateAttributes(Rocket rocket, double time, double metersTravelled) throws Exception {
		if (time <= 0 || metersTravelled == 0 || rocket == null) {
			throw new Exception();
		}
	}

	public double getTimeTaken() {
		return timeTaken;
	}

	public double getMetersTravelled() {
		return metersTravelled;
	}

	public Rocket getRocket() {
		return rocket;
	}

	public double compareTo(Object obj) {
		Score other = (Score) obj;
		if (obj == null)
			return 1;
		if (timeTaken < other.timeTaken)
			return 1;
		if (timeTaken == other.timeTaken) {
			return metersTravelled - other.metersTravelled;
		}
		return -1;
	}
}