package application;

import domain.Circuit;
import utilities.ConstantUtilities;

public class Main {
	public static Circuit circuit;

	public static void main(String[] args) throws Exception {
		initialise();
	}

	public static void initialise() throws Exception {
		circuit = new Circuit("tutorialCircuit", ConstantUtilities.maxTime, ConstantUtilities.length);
	}

	public void displayRockets() {
		
	}
}
