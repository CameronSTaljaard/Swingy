package com.ctaljaar.swingy.controller;

import com.ctaljaar.swingy.model.FileHandler;
import java.util.Scanner;
import com.ctaljaar.swingy.model.Player;
import com.ctaljaar.swingy.util.Globals;
import com.ctaljaar.swingy.util.Terminal;

public class GameHandler {

	public static void GameController() {
		String mode;
		String name;
		int mapSize;

		mode = StartGame(false);
		name = FileHandler.validateCharacter(mode);
		Globals.player = FileHandler.loadPlayer(name);
		mapSize = (Globals.player.getLevel() - 1) * 5 + 10 - (Globals.player.getLevel() % 2);
		Globals.player.setMapSize(mapSize);
		StartText();
		GameLoop.InputListener("", false);
	}

	public static String StartGame(boolean recurred) {
		String mode;
		Scanner scanner = Globals.scanner;

		Terminal.clearScreen();
		if (!recurred)
			System.out.println("WELCOME TO SWINGY!\n");
		else 
			System.out.println("Invalid option. Please input 1, or 2.");
		System.out.println("(1) Create a new hero");
		System.out.println("(2) Load a hero");
		mode = scanner.nextLine().toLowerCase();

		if (mode.equals("1"))
			mode = "create";
		else if (mode.equals("2"))
			mode = "load";

		if (mode.equals("create") || mode.equals("load"))
			return (mode);
		else {
			
			return StartGame(true);
		}
	}

	public static void StartText() {
		Terminal.clearScreen();
		System.out.println("Welcome to Swingy " + Globals.player.getName());
		System.out.println("\nYou can type exit at any time to quit the game.\n");
		System.out.println("\nYou can type info for hero details.\n");
		System.out.println("Type any of these commands to move:\n");
		System.out.println("north, up, east, right, left, west, down, south");
		System.out.println("The game has now begun.");
	}
}