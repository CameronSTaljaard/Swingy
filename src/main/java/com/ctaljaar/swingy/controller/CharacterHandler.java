package com.ctaljaar.swingy.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import com.ctaljaar.swingy.model.Player;

public class CharacterHandler {

	public static void readCharacter(String name) {

		try {
			FileInputStream fi = null;
			fi = new FileInputStream("saves/heroes/" + name + ".txt");
			ObjectInputStream oi = new ObjectInputStream(fi);

			Player pr1 = (Player) oi.readObject();

			System.out.println(pr1.toString());

			oi.close();
			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println("Character does not exist");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void saveCharacter(String name, String heroClass) {

		Player p1 = new Player(name, heroClass);

		try {
			FileOutputStream f = new FileOutputStream(new File("saves/heroes/" + name + ".txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject(p1);

			o.close();
			f.close();
			return;

		} catch (FileNotFoundException e) {
			return;
		} catch (IOException e) {
			return;
		} catch (Exception e) {
			return;
		}
	}

	public static int creationController() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your heroes name: ");
		String name = scanner.nextLine();

		// Check for empty name.
		File characterFile = new File("saves/heroes/" + name + ".txt");
		if (characterFile.exists()) {
			scanner.close();
			return (2);
		}

		// Check if hero already exists.
		if (name.isEmpty()) {
			scanner.close();
			return (4);
		}

		// Validate hero class.
		System.out.print("What is your class?: \n(1) = Warrior\n(2) = Rogue\n(3) = Knight\n ");
		String heroClass = scanner.nextLine();
		
		if (heroClass.equals("1"))
			heroClass = "Warrior";
		else if (heroClass.equals("2"))
			heroClass = "Rogue";
		else if (heroClass.equals("3"))
			heroClass = "Knight";

		// Error on invalid class.
		if (!heroClass.equals("Warrior") && !heroClass.equals("Rogue") && !heroClass.equals("Knight")) {
			scanner.close();
			return (3);
		}
		scanner.close();
		
		// Finalize and save character.
		saveCharacter(name, heroClass);
		return (1);
	}
}