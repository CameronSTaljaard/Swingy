package com.ctaljaar.swingy.controller;

import com.ctaljaar.swingy.model.FileHandler;
import com.ctaljaar.swingy.model.Player;
// import com.ctaljaar.swingy.model.FileHandler;

import java.util.Scanner;

public class GameHandler {

	public static void GameController() {
		String mode;
		Scanner scanner = new Scanner(System.in);

		mode = StartGame(scanner, false);
		FileHandler.UpdateCharacter(scanner, mode);

		// Player loadedPlayer;
		// loadedPlayer = CharacterValidator.loadPlayer("Undyne");
		// CharacterValidator.loadPlayer("Undyne");
		// loadedPlayer.toString();
	}

	// TO DO
	public static String StartGame(Scanner scanner, boolean recurred) {
		String mode;
		
		if (!recurred)
			System.out.println("WELCOME TO SWINGY!\n");
		System.out.println("(1) Create a new hero");
		System.out.println("(2) Load a hero");
		mode = scanner.nextLine().toLowerCase();

		if (mode.equals("1"))
			mode = "create";
		else if (mode.equals("2"))
			mode = "load";

		if (mode.equals("create") || mode.equals("load"))
			return (mode);
		else
			return StartGame(scanner, true);
	}
}