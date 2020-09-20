package com.ctaljaar.swingy.controller;

import com.ctaljaar.swingy.model.FileHandler;
import com.ctaljaar.swingy.util.Globals;
import com.ctaljaar.swingy.util.Terminal;
import java.util.Scanner;

public class GameLoop {
	public static void InputListener(String previousCommand, Boolean recurred) {
		Scanner scanner = Globals.scanner;
		String input = previousCommand;
		
		if (!recurred)
			System.out.println("Please input a command: ");
		while(true) {
			if (input.toLowerCase().equals("exit")) {
				Terminal.clearScreen();
				System.out.println("The game has been terminated.");
				System.out.println("Your character has been saved.");
				return ;
			}
			input = scanner.nextLine();
			if (Globals.validCommands.contains(input.toLowerCase())) {
				Terminal.clearScreen();
				MovePlayer(input.toLowerCase());
				System.out.println("Please input a command: ");
				InputListener(input, true);
			} else {
				Terminal.clearScreen();
				System.out.println(input + " is not a valid command.");
				System.out.println("Please input a valid command: ");
				InputListener(input, true);
			}
		}
	}

	public static void MovePlayer(String input) {
		if (input.equals("north") || input.equals("up")) {
			Globals.player.setVerticalPos(Globals.player.getVerticalPos() + 1);	
			System.out.println(Globals.player.getName() + " has moved to the North.");
			FileHandler.updatePlayer(Globals.player);
		} else if (input.equals("south") || input.equals("down")) {
			Globals.player.setVerticalPos(Globals.player.getVerticalPos() - 1);
			System.out.println(Globals.player.getName() + " has moved to the South.");
			FileHandler.updatePlayer(Globals.player);
		} else if (input.equals("east") || input.equals("right")) {
			Globals.player.setHorizontalPos(Globals.player.getHorizontalPos() + 1);
			System.out.println(Globals.player.getName() + " has moved to the East.");
			FileHandler.updatePlayer(Globals.player);
		} else if (input.equals("west") || input.equals("left")) {
			Globals.player.setHorizontalPos(Globals.player.getHorizontalPos() - 1);
			System.out.println(Globals.player.getName() + " has moved to the West.");
			FileHandler.updatePlayer(Globals.player);
		}
		return ;
	}
}
