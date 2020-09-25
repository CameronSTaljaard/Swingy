package com.ctaljaar.swingy.model;

import java.io.Serializable;

import javax.validation.constraints.*;
import javax.validation.groups.Default;

import com.ctaljaar.swingy.util.Terminal;

public class Player implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotNull(message = "Name cannot be null.")
	@NotBlank(message = "Name cannot be blank.")
	private String name;
	
	@NotNull(message = "Class can not be null.")
	@NotBlank(message = "Class cannot be blank.")
	private String heroClass;
	private int health;
	private int totalHealth;
	
	@Min(value = 1, message = "Level can't be lower than zero.")
	private int level;

	@Min(value = 3, message = "Attack can not be beneath 3.")
	private int attack;

	@NotNull(message = "Can't have null weapon.")
	private int weapon;

	@Min(value = 3, message = "Defense can not be beneath 3.")
	private int defense;

	@NotNull(message = "Can't have null armor.")
	private int armor;

	@Min(value = 0, message = "Experience can not be beneath 0.")
	private int experience;

	@Min(value = 1, message = "You can not go below level 1.")
	private int mapSize;

	private int verticalPos;
	private int horizontalPos;
	private int tempLevel;
	private int neededXP;

	Player() {
	};

	public Player(String name, String heroClass) {
		this.name = name;
		this.heroClass = heroClass;
		
		if (heroClass == "Warrior") {
			this.attack = 5;
			this.defense = 5;
			this.health = 5;
			this.totalHealth = 5;
		} else if (heroClass == "Rogue") {
			this.attack = 8;
			this.defense = 3;
			this.health = 4;
			this.totalHealth = 4;
		} else {
			this.attack = 3;
			this.defense = 6;
			this.health = 6;
			this.totalHealth = 6;
		}
		this.armor = 0;
		this.weapon = 0;
		this.experience = 0;
		this.tempLevel = 1;
		this.level = 1;
		this.verticalPos = 0;
		this.horizontalPos = 0;
		this.neededXP = level * 1000 + (int)Math.pow(level, 2) * 450;
    }
    
    public String getName() {
        return this.name;
    }

	public int getHealth() {
		return this.health;
	}
	public void setHealth(int health) {
		this.health = health;
	}

	public int getLevel() {
		return this.level;
	}
	public void setLevel(@Min(0) int level) {
		this.level = level;
	}

	public int getMaxHealth() {
		return this.totalHealth;
	}

	public int getAttack() {
		return this.attack;
	}
	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return this.defense;
	}
	public void setDefense(int defense) {
		this.defense = defense;
	}
	
	public int getExperience() {
		return this.experience;
	}
	public void addExperience(int experience) {
		this.experience += experience;
	}
	
	public int getMapSize() {
		return this.mapSize;
	}
	public void setMapSize(int mapSize) {
		this.mapSize = mapSize;
	}

	public int getVerticalPos() {
		return this.verticalPos;
	}

	public void setVerticalPos(int verticalPos) {
		this.verticalPos = verticalPos;
	}

	public int getHorizontalPos() {
		return this.horizontalPos;
	}

	public void setHorizontalPos(int horizontalPos) {
		this.horizontalPos = horizontalPos;
	}

	public String getWeapon() {
		String result;
		switch (this.weapon) {
			case 0:
				result = "Knife. +0 Attack\n";
				break;
			case 1:
				result = "Short sword. +1 Attack\n";
				break;
			case 2:
				result = "Longsword. +2 Attack\n";
				break;
			default:
				result = "Knife. +0 Attack\n";
				break;
		}
		return (result);
	}

	public void setWeapon(int weapon) {
		this.weapon = weapon;
		this.attack += 1;
	}

	public String getArmor() {
		String result;
		switch (this.armor) {
			case 0:
				result = "None: +0 Defense\n";
				break;
			case 1:
				result = "Leather: +1 Defense\n";
				break;
			case 2:
				result = "Chain mail: +2 Defense\n";
				break;
			default:
				result = "None. +0 Defense\n";
				break;
		}
		return (result);
	}

	public void kill() {
		Terminal.clearScreen();
		System.out.println("The player has died");
		FileHandler.deletePlayer();
		System.exit(2);
	}

	public int getArmorInt() {
		return this.armor;
	}

	public int getWeaponInt() {
		return this.weapon;
	}

	public void setArmor(int armor) {
		this.armor = armor;
		this.defense += 1;
	}

	public void changeLevel() {
		if (this.experience >= 1000 && this.experience < 2450) {
			this.level = 2;
			this.attack += 2;
			this.defense += 2;
			this.health += 4;
        } else if (this.experience >= 2450 && this.experience < 4800) {
			this.level = 3;
			this.attack += 2;
			this.defense += 2;
			this.health += 4;
		} else if (this.experience >= 4800 && this.experience < 8050) {
			this.level = 4;
			this.attack += 2;
			this.defense += 2;
			this.health += 4;
        } else if (this.experience >= 8050 && this.experience < 12200) {
			this.level = 5;
			this.attack += 2;
			this.defense += 2;
			this.health += 4;
        } else if (this.experience >= 12200 && this.experience < 17250) {
			this.attack += 2;
			this.defense += 2;
			this.health += 4;
            this.level = 6;
        } else if (this.experience >= 17250) {
			this.attack += 2;
			this.defense += 2;
			this.health += 4;
            this.level = 7;
        } else {
			this.level = 1;
		}
    }
	}

	@Override
	public String toString() {
		String weapon = this.getWeapon();
		String armor = this.getArmor();
		// String heroClass = this.heroClass;
		return "\n\nYOUR HERO:\nName: " + name + "\nClass: " + heroClass + "\n\nSTATS: " + "\nAttack: " + attack
		+ "\nDefense: " + defense + "\nHit Points: " + health + "\n\nEquipment:\n" + "Armor: " + armor + "Weapon: " + weapon + "\nLevel: " + level + "\nExperience: " + this.experience + "\nExperience to level: " + this.neededXP
		+ "\nVerticalpos: " + this.verticalPos + "\nHorizontalPos: " + this.horizontalPos;
	}
}