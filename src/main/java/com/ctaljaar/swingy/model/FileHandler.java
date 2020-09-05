package com.ctaljaar.swingy.model;

import java.io.*;
import java.util.*;
import com.ctaljaar.swingy.controller.CharacterValidator;

public class FileHandler {
	public static boolean saveCharacter(String name, String heroClass) {

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

	public static void UpdateCharacter(Scanner scanner, String mode) {
		String name = "";
		String heroClass = "";
		
		name = CharacterValidator.validateName(scanner, mode);
		if (mode.equals("Create"))
			heroClass = CharacterValidator.validateClass(scanner);

		if (FileHandler.saveCharacter(name, heroClass))
			if (mode.equals("Create"))
				System.out.println("Character created");
			else
				System.out.println("Character updated");
	}
}