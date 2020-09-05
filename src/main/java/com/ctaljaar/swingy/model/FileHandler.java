package com.ctaljaar.swingy.model;

import java.io.*;
import java.util.*;
import com.ctaljaar.swingy.controller.CharacterValidator;

public class FileHandler {
	public static boolean createCharacter(String name, String heroClass) {

		Player p1 = new Player(name, heroClass);

		try {
			FileOutputStream f = new FileOutputStream(new File("saves/heroes/" + name + ".txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject(p1);

			o.close();
			f.close();
			return (true);

		} catch (FileNotFoundException e) {
			return (false);
		} catch (IOException e) {
			return (false);
		} catch (Exception e) {
			return (false);
		}
	}

	public static String validateCharacter(Scanner scanner, String mode) {
		String name = "";
		String heroClass = "";
		
		name = CharacterValidator.validateName(scanner, mode);
		if (mode.equals("create"))
			heroClass = CharacterValidator.validateClass(scanner);

		if (FileHandler.createCharacter(name, heroClass))
			if (mode.equals("Create")) {
				System.out.println("Character created");
				return (name);
			} else { 
				System.out.println("Character accepted.\nLoading character");
				return (name);
			}
		return ("");
	}

	public static Player loadPlayer(String name) {
		try {
			FileInputStream fis = new FileInputStream("saves/heroes/" + name + ".txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			Player player = (Player) ois.readObject();

			ois.close();
			System.out.println("Loaded character: " + name);
			return(player);
		
		} catch (IOException | ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		return (null);
		}
}