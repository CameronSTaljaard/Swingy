package com.ctaljaar.swingy.controller;

import com.ctaljaar.swingy.model.FileHandler;
import java.util.Scanner;

public class GameHandler {

	public static void GameController() {
		Scanner scanner = new Scanner(System.in);

		CreateCharacter(scanner);
	}

	public static void CreateCharacter(Scanner scanner) {
		String name;
		String heroClass;
		
		name = CharacterValidator.validateName(scanner);
		heroClass = CharacterValidator.validateClass(scanner);
		if (FileHandler.saveCharacter(name, heroClass))
			System.out.println("Character saved");
	}
}