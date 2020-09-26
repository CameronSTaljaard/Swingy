package com.ctaljaar.swingy.model;

import java.util.ArrayList;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

import com.ctaljaar.swingy.util.Globals;
import java.security.SecureRandom;

public class Monster {
	public static ArrayList<String> monsterNames = new ArrayList<String>();
	SecureRandom srand = new SecureRandom();
	@NotBlank (message = "Monster must be named")
	String name;
	@Min (value = 1, message = "Monster must have health")
	int health;
	@Min (value = 1, message = "Monster must have attack")
	int attack;
	
	public Monster() {
		
		populateNames();

		this.name = monsterNames.get(srand.nextInt(4));
		switch(this.name) {
			case "Slime":
				this.attack = 1 * Globals.player.getLevel();
				this.health = 2 * Globals.player.getLevel();
				break;
			case "Pirate":
				this.attack = 2 * Globals.player.getLevel();
				this.health = 4 * Globals.player.getLevel();
				break;
			case "Bandit":
				this.attack = 3 * Globals.player.getLevel();
				this.health = 3 * Globals.player.getLevel();
				break;
			case "Bat":
				this.attack = 2 * Globals.player.getLevel();
				this.health = 1 * Globals.player.getLevel();
				break;
		}
	}

	public String getName() {
		return this.name;
	}

	public int getAttack() {
		return this.attack;
	}

	public int getHealth() {
		return this.attack;
	}

	public boolean takeDamage(int damage) {
		this.health = this.health - damage;
		if (this.health <= 0)
			return true;
		return false;
	}
	

	public static void populateNames() {
		monsterNames.add("Slime");
		monsterNames.add("Pirate");
		monsterNames.add("Bandit");
		monsterNames.add("Bat");
	}

	@Override
	public String toString() {
		return ("Name: " + this.name + "\nHealth: " + this.health + "\nAttack: " + this.attack);
	}
}
