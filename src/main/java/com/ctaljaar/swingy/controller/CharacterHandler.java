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

	public static void readCharacters(String name) {

		try {
			FileInputStream fi = null;
			fi = new FileInputStream(name + ".txt");
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

	public static int saveCharacter(String name, String heroClass) {

		File characterFile;
		Player p1 = new Player(name, heroClass);

		try {
			characterFile = new File(name + ".txt");
			if (characterFile.exists()) {
				return (2);
			}

			FileOutputStream f = new FileOutputStream(new File(name + ".txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject(p1);

			o.close();
			f.close();
			return (1);

		} catch (FileNotFoundException e) {
			return (0);
		} catch (IOException e) {
			return (0);
		} catch (Exception e) {
			return (0);
		}
	}

	public static int creationController() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter your heroes name: ");
		String name = scanner.nextLine();
		System.out.print("What is your class?: \n(1) = Warrior\n(2) = Rogue\n(3) = Knight\n ");
		String heroClass = scanner.nextLine();
		
		if (heroClass.equals("1"))
			heroClass = "Warrior";
		else if (heroClass.equals("2"))
			heroClass = "Rogue";
		else if (heroClass.equals("3"))
			heroClass = "Knight";
		
		if (name.isEmpty()) {
			scanner.close();
			return (4);
		}
		if (!heroClass.equals("Warrior") && !heroClass.equals("Rogue") && !heroClass.equals("Knight")) {
			scanner.close();
			return (3);
		}
		scanner.close();
		return (saveCharacter(name, heroClass));
	}
}