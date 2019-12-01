package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AirField {
	// F i e l d
	private List<Jet> jets = new ArrayList<>();
	String jetList = "Jets.txt";

	private void scanForJet() {
		try {
			FileReader fr = new FileReader(jetList);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				String[] jetInfo = line.split(", ");
				String model = jetInfo[0];
				double speed = Double.parseDouble(jetInfo[1]);
				int range = Integer.parseInt(jetInfo[2]);
				long price = Long.parseLong(jetInfo[3]);
				if (line.contains("Cargo")) {
					Jet cj = new CargoPlane(model, speed, range, price);
					jets.add(cj);
				}
				if (line.contains("Fighter")) {
					Jet fj = new FighterJet(model, speed, range, price);
					jets.add(fj);
				}
			}
			br.close();
		} catch (FileNotFoundException e) {
			System.err.println("Invalid filename: " + e.getMessage());
			return;
		} catch (IOException e) {
			System.err.println("Problem while reading " + jetList + ": " + e.getMessage());
			return;
		}
		System.out.println(jetList);

	}

	public List<Jet> scanForJets() {
		scanForJet();
		return jets;
	}

	public void listFleet() {
		System.out.println("Fleet: " + jets.toString());
	}

	public void fly() {
		for (Jet jet : jets) {
			jet.fly();
		}
	}

	public String viewFastestJet() {
		double fast = 0;
		String fastest = "";
		for (Jet jet : jets) {
			if (jet.getSpeed() > fast) {
				fast = jet.getSpeed();
				fastest = jet.toString();
			}
		}
		return fastest;
	}
	public String viewLongestRange() {
		int vLongest = 0;
		String vLongestRange = "";
		for (Jet jet : jets) {
			if (jet.getRange() > vLongest) {
				vLongest = jet.getRange();
				vLongestRange = jet.toString();
			}
		}
		return vLongestRange;
	}
	public void loadCargo() {
		for (Jet jet : jets) {
			if (jet instanceof CargoCarrier) {
				((CargoCarrier) jet).loadCargo();
			}
		}
	}
	public void dogFight() {
		for (Jet jet : jets) {
			if (jet instanceof CombatReady) {
				((CombatReady) jet).fight();
			}
		}
	}
	
}
