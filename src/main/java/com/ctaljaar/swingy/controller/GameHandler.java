package com.ctaljaar.swingy.controller;

import com.ctaljaar.swingy.model.FileHandler;
import com.ctaljaar.swingy.model.Player;

import java.util.Scanner;

public class GameHandler {

	public static void GameController() {
		// Scanner scanner = new Scanner(System.in);

		// CreateCharacter(scanner);

		Player loadedPlayer;
		loadedPlayer = CharacterValidator.loadPlayer("Undyne");

		// loadedPlayer.toString();
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