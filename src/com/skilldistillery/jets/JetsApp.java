package com.skilldistillery.jets;

import java.util.List;
import java.util.Scanner;

public class JetsApp {

	private AirField airField = new AirField();

	Scanner kb = new Scanner(System.in);

	public static void main(String[] args) {
		JetsApp ja = new JetsApp();
		ja.launch();
	}

	public void launch() {
		printMenu();
		}
		
		public void printMenu() {
			List<Jet> jets = airField.scanForJets();
			boolean keepGoing = true;
			while(keepGoing) {
				System.out.println("1. List fleet\n2. Fly all jets\n3. View the fastest jet\n4. View jet with longest range\n"
						+ "5. Load all Cargo Jets\n6. Dogfight!\n"
						+ "7. Add a jet to Fleet\n8. Remove a jet from Fleet\n" + "9. Quit ");
				String input = kb.next();
				switch (input) {
				case "1":
					airField.listFleet();
					break;
				case "2":
					airField.fly();
					break;
				case "3":
					System.out.println(airField.viewFastestJet());
					break;
				case "4":
					System.out.println(airField.viewLongestRange());
					break;
				case "5":
					airField.loadCargo();
					break;
				case "6":
					airField.dogFight();
					break;
				case "7":
					airField.addJet(jets, kb);
					break;
				case "8":
					airField.removeJets(jets, kb);
					break;
				case "9":
					System.out.println("Quitting...");
					keepGoing = false;
					break;
				default:
					System.out.println("Make a selection.");
					break;
				}
		}
	}

	

}
