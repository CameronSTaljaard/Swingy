package com.ctaljaar.swingy.controller;

import java.util.Scanner;
import com.ctaljaar.swingy.util.Terminal;
import java.io.*;

public class CharacterValidator {

	public static String validateName(Scanner scanner, String mode) {

		Boolean validName = false;
		String name = "";

		while (!validName) {

			System.out.print("Enter your heroes name: ");
			name = scanner.nextLine();

			if (name.isEmpty()) {
				System.out.print("Please give input for the heroes name.\n");
			} else {
				validName = true;
			}

			File characterFile = new File("saves/heroes/" + name + ".ser");
			if (mode.equals("create")) {
                if (characterFile.exists()) {
                    System.out.print("That hero already exists\n");
                    validName = false;
                }
			} else if (mode.equals("load")) {
                if (!characterFile.exists()) {
                    System.out.print("No hero with name: " + name + " exists.\n");
                    validName = false;
                }
			}
		}
		Terminal.clearScreen();
		return (name);
	}

	public static String validateClass(Scanner scanner) {

		Boolean validClass = false;
		String heroClass = "";

		while (!validClass) {
			System.out.print("What is your class?: \n(1) = Warrior\n(2) = Rogue\n(3) = Knight\n ");
			if (scanner.hasNextLine())
				heroClass = scanner.nextLine();

			switch (heroClass) {
				case "1":
					heroClass = "Warrior";
					break;
				case "2":
					heroClass = "Rogue";
					break;
				case "3":
					heroClass = "Knight";
					break;
			}
			if (heroClass.equals("Warrior") || heroClass.equals("Rogue") || heroClass.equals("Knight")) {
				validClass = true;
			}
		}
		Terminal.clearScreen();
		return (heroClass);
	}
}