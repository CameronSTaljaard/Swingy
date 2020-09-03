package com.ctaljaar.swingy.controller;

import java.util.Scanner;
import java.io.*;

import com.ctaljaar.swingy.model.Player;

public class CharacterValidator {

	public static String validateName(Scanner scanner) {

		Boolean validName = false;
		String name = "";
		
		while (!validName) {
			System.out.print("Enter your heroes name: \n");

			if (scanner.hasNextLine())
				name = scanner.nextLine();

			if (name.isEmpty()) {
				System.out.print("Please give input for the heroes name.\n");
			} else {
				validName = true;
			}
				
			File characterFile = new File("saves/heroes/" + name + ".txt");
			if (characterFile.exists()) {
				System.out.print("That hero already exists\n");
				validName = false;
			}
		}
		return(name);
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
		return(heroClass);
	}

	public static Player loadPlayer(String name) {

		Player loadedPlayer;

		try {
			FileInputStream fi = null;
			ObjectInputStream oi = new ObjectInputStream(fi);
			loadedPlayer = (Player) oi.readObject();
			
			fi = new FileInputStream("saves/heroes/" + name + ".txt");

			// System.out.println(loadedPlayer.toString());
			oi.close();
			fi.close();
			// System.out.println("Printing: " + name);
			
		} catch (FileNotFoundException e) {
			System.out.println("Character does not exist");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return (loadedPlayer);
	}
}