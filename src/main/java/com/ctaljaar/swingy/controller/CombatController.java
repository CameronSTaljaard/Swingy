package com.ctaljaar.swingy.controller;

import java.util.Random;
import java.util.Scanner;

import com.ctaljaar.swingy.model.CombatHandler;
import com.ctaljaar.swingy.model.FileHandler;
import com.ctaljaar.swingy.model.Monster;
import com.ctaljaar.swingy.util.Globals;
import com.ctaljaar.swingy.util.Terminal;

public class CombatController {
	public static void combatLoop(Monster monster, boolean recurred) {
		Scanner scanner = Globals.scanner;
		String input = "";
		Random rand = new Random();

		if (!recurred)
		System.out.println("You encountered a " + monster.getName() + "!");
		System.out.println("What do you do?\n(1)Attack\n(2)Flee\n");
		input = scanner.nextLine();
		if (input.equals("1")) {
			System.out.println("Combat started.");
			boolean result = CombatHandler.combatSimulator(monster);
			if (!result) {
				Globals.player.kill();
			}
		} else if (input.equals("2")) {
			int escaped = rand.nextInt(2);
			if (escaped == 1) {
				System.out.println("You escaped.");
				GameLoop.InputListener("", false);
			} else {
				System.out.println("You failed to escape");
				Globals.player.setHealth(Globals.player.getHealth() - monster.getAttack());
				System.out.println("The monster hit you for " + monster.getAttack() + " while you had your back turned!");
				System.out.println("You have " + Globals.player.getHealth() + " health left");
				if (Globals.player.getHealth() <= 0)
					Globals.player.kill();
				combatLoop(monster, true);
			}
		} else {
			Terminal.clearScreen();
			System.out.println("Invalid command!");
			combatLoop(monster, true);
		}
	}
}
