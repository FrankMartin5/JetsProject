package com.skilldistillery.jets;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
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
					plane = new JetImpl(jetRecord[0], Double.parseDouble(jetRecord[2]), Integer.parseInt(jetRecord[3]),
							Long.parseLong(jetRecord[4]));
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
		boolean keepGoing = true;
		while (keepGoing) {
			System.out.println("Which jet do you want to add");
			System.out.println("(1) Fighter Plane");
			System.out.println("(2) Cargo Plane");
			System.out.println("(3) Main Menu");
			int input = kb.nextInt();
			switch (input) {
			case 1:
				System.out.println("Enter Jet model ");
				String model = kb.next();
				System.out.println("Enter speed: ");
				double speed = kb.nextDouble();
				System.out.println("Enter range: ");
				int range = kb.nextInt();
				System.out.println("Enter price: ");
				long price = kb.nextLong();
				Jet fighterJet = new FighterJet(model, speed, range, price);
				jets.add(fighterJet);
				System.out.println(fighterJet.toString()+" is now added");
				System.out.println("Your fleet size is now " + jets.size());
				break;
			case 2:
				System.out.println("Enter Jet model: ");
				model = kb.next();
				System.out.println("Enter speed: ");
				speed = kb.nextDouble();
				System.out.println("Enter range: ");
				range = kb.nextInt();
				System.out.println("Enter price: ");
				price = kb.nextLong();
				Jet cargoJet = new CargoPlane(model, speed, range, price);
				System.out.println("Cargo Plane has entered the airfield");
				jets.add(cargoJet);
				System.out.println(cargoJet.toString()+" is now added");
				System.out.println("Your fleet size is now " + jets.size());
				break;
			case 3:
			default:
				keepGoing = false;
				System.out.println("Returning to main menu");
				break;
			}

		}
	}

	public void removeJets(List<Jet> jets, Scanner kb) {
		Integer i = 1;
		Integer jetRemoval;
		Jet removedJet = null;
		for (Jet jet : jets) {
			System.out.println(i + " " + jet.getModel());
			i++;
		}
		System.out.println("Select a number from 1 - " + (i - 1) + " to remove that jet.");
		jetRemoval = kb.nextInt();
		kb.nextLine();
		removedJet = jets.remove(jetRemoval - 1);
		System.out.println(removedJet.getModel() + " has been removed");
	}

}
