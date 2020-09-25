package com.ctaljaar.swingy.model;
import java.util.Random;
import java.util.concurrent.*;

import com.ctaljaar.swingy.controller.CombatController;
import com.ctaljaar.swingy.util.Globals;
import com.ctaljaar.swingy.util.Terminal;
import java.util.Scanner;

import java.lang.Thread;

public class CombatHandler {
	public static boolean combatEncounter() {
		int randomEncounter = ThreadLocalRandom.current().nextInt(1, 10 + 1);
		if (randomEncounter > 7)
			return true;
		return false;
	}

	public static void startCombat() {
		Monster monster = new Monster();
		CombatController.combatLoop(monster, false);
	}

	public static boolean combatSimulator(Monster monster) {
		Random rand = new Random();

		while (monster.health > 0 && Globals.player.getHealth() > 0) {
			int first = rand.nextInt(2);
			if (first == 0) {
				System.out.println("The player attacked first!");
				int landedAttack = rand.nextInt(5);
				if (landedAttack == 0)
					System.out.println("The player missed!");
				else {
					monster.health -= Globals.player.getAttack();
					System.out.println("The player did " + Globals.player.getAttack() + " Damage!");
				}
				landedAttack = rand.nextInt(5);
				if (landedAttack == 0)
				System.out.println("The monster missed!");
				else{
					Globals.player.setHealth(Globals.player.getHealth() - monster.getAttack());
					System.out.println("The monster did " + monster.getAttack() + " Damage!");
					if (Globals.player.getHealth() <= 0)
					return (false);
				}
			}
			else {
				System.out.println("The monster attacked first!");
				int landedAttack = rand.nextInt(5);
				if (landedAttack == 0)
					System.out.println("The monster missed!");
				else{
					Globals.player.setHealth(Globals.player.getHealth() - monster.getAttack());
					System.out.println("The monster did " + monster.getAttack() + " Damage!");
					if (Globals.player.getHealth() <= 0)
						return (false);
				}
				landedAttack = rand.nextInt(5);
				if (landedAttack == 0)
					System.out.println("The player missed!");
				else {
					monster.health -= Globals.player.getAttack();
					System.out.println("The player did " + Globals.player.getAttack() + " Damage!");
				}
			}
			System.out.println("\n");
		}
		Globals.player.setHealth(Globals.player.getMaxHealth());
		System.out.println("You defeated the " + monster.name + "!");
		if (monster.name.equals("Slime")) {
			Globals.player.addExperience(100 * Globals.player.getLevel());
			System.out.println("+" + 100 * Globals.player.getLevel() + " EXP!");
			Globals.player.changeLevel();
		} else {
			Globals.player.addExperience(500 * Globals.player.getLevel());
			System.out.println("+" + 200 * Globals.player.getLevel() + " EXP!");
			Globals.player.changeLevel();
		}
		int gotItem = rand.nextInt(4);
		if (gotItem == 3) {
			System.out.println("The player found an item!");
			int item = rand.nextInt(2);
			if (item == 1 && Globals.player.getArmorInt() != 3) {
				Globals.player.setArmor(Globals.player.getArmorInt() + 1);
				System.out.println("The player now has:\n" + Globals.player.getArmor());
			} else {
				Globals.player.setArmor(Globals.player.getWeaponInt() + 1);
				System.out.println("The player now has:\n" + Globals.player.getWeapon());
			}
		}
		FileHandler.updatePlayer(Globals.player);
		System.out.println("Press Enter to continue");
		Scanner scanner = Globals.scanner;
		scanner.nextLine();
		Terminal.clearScreen();
		return (true);
	}
}
