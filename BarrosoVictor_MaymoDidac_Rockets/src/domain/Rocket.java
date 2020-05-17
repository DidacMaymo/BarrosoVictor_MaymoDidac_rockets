package domain;

import java.util.ArrayList;
import java.util.List;

import utilities.ConstantUtilities;

public class Rocket {

	public String idRocket;
	private double speed = 0; // at start here counts as v0
	public double acceleration = 0;
	public int metersTravelled = 0;
	private List<Propellant> propellants = new ArrayList<Propellant>();
	public FuelTank fueltank;

	public Rocket(String id, List<Propellant> propellants, FuelTank fueltank) {
		this.idRocket = id;
		this.propellants = propellants;
		this.fueltank = fueltank;
	}

	public void setAcceleration(double acceleration) {
		for (Propellant p : propellants) {
			p.setActualAcceleration(acceleration);
		}
	}

	public double getAcceleration() { // acceleration right now
		double acc = 0;
		for (Propellant p : propellants) {
			acc += p.getActualAcceleration();
		}
		return acc;
	}

	public double getMaxAcceleration() { // acceleration right now
		double maxAcc = 0;
		for (Propellant p : propellants) {
			maxAcc += p.getMaxAcceleration();
		}
		return maxAcc;
	}

	public void setSpeed() { // speed of rocket right now. v = v0 + at
		this.speed += acceleration * ConstantUtilities.delay;
		fueltank.updateFuel(speed);
		setMetersTravelled();
	}

	public double getSpeed() {
		return speed;
	}

	public void setMetersTravelled() { // x = xo + v*t + ½ a * t^2
		metersTravelled += speed * ConstantUtilities.delay + (acceleration / 2) * Math.pow(ConstantUtilities.delay, 2);
	}

	public int getMetersTravelled() {
		return metersTravelled;
	}

	public double getFuelConsumption() {
		return fueltank.getFuelConsumption(speed);
	}

	public double decideAction(int currentTime) { // retorna la acceleracio que has decidit posar, pot ser 0 o >, no <
		double timeRemaining = ConstantUtilities.maxTime - currentTime;
		double metersRemaining = ConstantUtilities.length - this.metersTravelled;
		double fuelRemaining = this.fueltank.getActualFuel();
		for (double acc = this.getMaxAcceleration(); acc >= 0; acc--) { // comencem per la acceleracio mes alta
			if (tryAcceleration(acc, timeRemaining, metersRemaining, fuelRemaining)) {
				return acc;
			}
		}
		return 0;
	}
	// comprovem si es una acceleracio valida (no quedarnos sense fuel fins acabar
	// la carrera amb acc=0 dspres de aixo

	public boolean tryAcceleration(double acc, double timeRemaining, double metersRemaining, double fuelRemaining) {
		double newSpeed = this.getSpeed() + acc * ConstantUtilities.delay;
		double newFuelConsumption = fueltank.getFuelConsumption(newSpeed);
		if(fuelRemaining-newFuelConsumption*timeRemaining >= 0) {
			//fins aqui entra
			if(newSpeed*timeRemaining >= metersRemaining) {
				return true; //aqui es que amb la nova acceleracio arribariem a temps a la meta i amb la gasolina.
			}
		}
		return false;
	}
    public void speedToAcceleration (double speed){
    	setAcceleration(0);
        while(getAcceleration()<speed){
            setAcceleration(getAcceleration()+1);
        }
        //System.out.println(speed);
        acceleration = this.getAcceleration();
        setSpeed(); 
    }

}
