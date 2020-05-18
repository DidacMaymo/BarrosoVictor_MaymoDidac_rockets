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

	public Rocket(String id, List<Propellant> propellants, FuelTank fueltank) throws Exception {
		if(validAtributes(propellants, fueltank)) {
			this.idRocket = id;
			this.propellants = propellants;
			this.fueltank = fueltank;
		}
	}
	public boolean validAtributes(List<Propellant> propellants, FuelTank fueltank) throws Exception {
		for(Propellant p: propellants) {
			if(p.getMaxAcceleration()<=0) {
				throw new Exception();
			}
		}if(fueltank.getFuelCapacity()>=0) {
			throw new Exception();
		}
		return true;
		
	}

	public void setAcceleration(double acceleration) {
		for (Propellant p : propellants) {
			p.setActualAcceleration(acceleration);
		}
	}

	public double getAcceleration() { 
		double acc = 0;
		for (Propellant p : propellants) {
			acc += p.getActualAcceleration();
		}
		return acc;
	}

	public double getMaxAcceleration() { 
		double maxAcc = 0;
		for (Propellant p : propellants) {
			maxAcc += p.getMaxAcceleration();
		}
		return maxAcc;
	}

	public void updateSpeed() { // v = v0 + at
		this.speed += acceleration * ConstantUtilities.delay;
		fueltank.updateFuel(speed);
		updateMetersTravelled();
	}

	public double getSpeed() {
		return speed;
	}

	public void updateMetersTravelled() { // x = xo + v*t + ½ a * t^2
		metersTravelled += speed * ConstantUtilities.delay + (acceleration / 2) * Math.pow(ConstantUtilities.delay, 2);
	}

	public int getMetersTravelled() {
		return metersTravelled;
	}

	public double getFuelConsumption() {
		return fueltank.getFuelConsumption(speed);
	}

	public double decideAction(int currentTime) { 
		for (double acc = this.getMaxAcceleration(); acc >= 0; acc--) { 
			if (tryAcceleration(acc, ConstantUtilities.maxTime - currentTime, ConstantUtilities.length - this.metersTravelled, this.fueltank.getActualFuel())) {
				//afegir la acc a la estrategia, posar el segon i la acc escollida
				return acc;
			}
		}
		
		return 0;
	}
	
	public boolean tryAcceleration(double acc, double timeRemaining, double metersRemaining, double fuelRemaining) {
		double newSpeed = this.getSpeed() + acc * ConstantUtilities.delay;
		double newFuelConsumption = fueltank.getFuelConsumption(newSpeed);
		if(fuelRemaining-newFuelConsumption*timeRemaining >= 0) {
			if(this.metersTravelled+newSpeed*timeRemaining >= metersRemaining) {
				return true; 
			}
		}
		return false;
	}
    public void speedToAcceleration (double speed){
    	setAcceleration(0);
        while(getAcceleration()<speed){
            setAcceleration(getAcceleration()+1);
        }
        acceleration = this.getAcceleration();
        updateSpeed(); 
    }

}
