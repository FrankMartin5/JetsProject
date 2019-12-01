package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;


public class AirField {
	// F i e l d
	private List<Jet> jets = new ArrayList<>();
	

	public List<Jet> scanForJets() {
			try (BufferedReader rd = new BufferedReader(new FileReader("jets.txt"))) {
				String line;
				while ((line = rd.readLine()) != null) {
					String[] jetRecord = line.split(", "); 
					Jet plane = null;
					switch (jetRecord[0]) {
					case "Fighter":
						plane = new FighterJet(jetRecord[0], Double.parseDouble(jetRecord[2]),
								Integer.parseInt(jetRecord[3]), Long.parseLong(jetRecord[4]));
						jets.add(plane);
						break;
					case "Cargo":
						plane = new CargoPlane(jetRecord[0], Double.parseDouble(jetRecord[2]),
								Integer.parseInt(jetRecord[3]), Long.parseLong(jetRecord[4]));
						jets.add(plane);
						break;
					case "JetImpl":
						plane = new JetImpl(jetRecord[0], Double.parseDouble(jetRecord[2]),
								Integer.parseInt(jetRecord[3]), Long.parseLong(jetRecord[4]));
						jets.add(plane);
						break;
					default:
						System.out.println("something went wrong");
						
					}
					
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

			return jets;
	}


	public void listFleet() {
		for (Jet jet : jets) {
			System.out.println(jet);
		}
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
	public void addJet(List<Jet> jets, Scanner kb) {
		Jet newJet = null;
		String addJetType = null;
		String addJetModel = null;
		Double addJetSpeed = null;
		Integer addJetRange = null;
		Long addJetPrice = null;
		
		System.out.println("Enter a jet type: ");
		addJetType = kb.nextLine();
		
		System.out.println("Enter the jet name: ");
		addJetModel = kb.nextLine();
		
			try {
				System.out.println("Enter your speed in MPH: ");
				addJetSpeed = kb.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("Enter only numbers");
			}
			try {
				System.out.println("Enter your range in miles: ");
				addJetRange = kb.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Enter only numbers");
			}
			try {
				System.out.println("Enter a price jet price: ");
				addJetPrice = kb.nextLong();
			} catch (InputMismatchException e) {
				System.out.println("Enter only numbers");
			}
			if (addJetType.equalsIgnoreCase("fighter")) {
				newJet = new FighterJet(addJetModel, addJetSpeed, addJetRange, addJetPrice);
			} else if (addJetType.equalsIgnoreCase("cargo")) {
				newJet = new CargoPlane(addJetModel, addJetSpeed, addJetRange, addJetPrice);
			} else {
				newJet = new JetImpl(addJetModel, addJetSpeed, addJetRange, addJetPrice);
			}
			jets.add(newJet);
			System.out.println("Added "+ newJet.getModel() + ".");
	}
	public void removeJets(List<Jet> jets, Scanner kb) {
		Integer i = 1;
		Integer jetRemoval;
		Jet removedJet = null;
		for (Jet jet : jets) {
			System.out.println(i + " "+ jet.getModel());
			i++;
		}
		System.out.println("Select a number from 1 - "+ (i - 1) + " to remove that jet." );
		jetRemoval = kb.nextInt();
		kb.nextLine();
		removedJet = jets.remove(jetRemoval - 1);
		System.out.println(removedJet.getModel() + " has been removed");
	}
	
}
