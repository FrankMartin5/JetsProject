package com.skilldistillery.jets;

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
			while(true) {
				System.out.println("1. List fleet\n2. Fly all jets\n3. View the fastest jet\n4. View jet with longest range\n"
						+ "5. Load all Cargo Jets\n6. Add a jet to Fleet\n7. Remove a jet from Fleet\n" + "8. Quit ");
				
			}
	}

}
