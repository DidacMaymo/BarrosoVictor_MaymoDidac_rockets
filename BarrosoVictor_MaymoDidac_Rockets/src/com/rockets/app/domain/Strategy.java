package com.rockets.app.domain;

import java.util.ArrayList;

import com.rockets.app.utilities.ConstantUtilities;
import com.rockets.app.utilities.InvalidParamException;

public class Strategy {

		public static double decideAction(Rocket rocket,int currentTime, double length,double maxTime) throws Exception { //a cambiar
	        for (double acc = rocket.getMaxAcceleration(); acc >= 0; acc--) {
	            if (tryAcceleration(rocket,acc, maxTime - currentTime,
	                    length - rocket.getMetersTravelled(), rocket.getActualFuel())) {
	                return acc;
	            }
	        }
	        return 0;
	    }

	    private static  boolean tryAcceleration(Rocket rocket,double acc, double timeRemaining, double metersRemaining, double fuelRemaining) throws Exception {
	        double newSpeed = rocket.getSpeed() + acc * ConstantUtilities.DELAY;
	        double newFuelConsumption = rocket.getFuelTank().getFuelConsumption(newSpeed);
	        if (fuelRemaining - newFuelConsumption * timeRemaining >= 0) {
	            if (rocket.getMetersTravelled() + newSpeed * timeRemaining >= metersRemaining) {
	                return true;
	            }
	        }
	        return false;
	    }   
}
