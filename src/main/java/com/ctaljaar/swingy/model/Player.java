package com.ctaljaar.swingy.model;

import java.io.Serializable;

import javax.validation.constraints.*;

public class Player implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotNull(message = "Name cannot be null.")
	@NotBlank(message = "Name cannot be blank.")
	private String name;
	
	@NotNull(message = "Class can not be null.")
	@NotBlank(message = "Class cannot be blank.")
	private String heroClass;
	private int health;
	
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
	private int mapLevel;

	private int verticalPos;
	private int horizontalPos;

	Player() {
	};

	public Player(String name, String heroClass) {
		this.name = name;
		this.heroClass = heroClass;
		
		if (heroClass == "Warrior") {
			this.attack = 5;
			this.defense = 5;
			this.health = 5;
		} else if (heroClass == "Rogue") {
			this.attack = 8;
			this.defense = 3;
			this.health = 4;
		} else {
			this.attack = 3;
			this.defense = 6;
			this.health = 6;
		}
		this.armor = 0;
		this.weapon = 0;
		this.experience = 0;
		this.level = 0;
		this.mapLevel = 1;
		this.verticalPos = 0;
		this.horizontalPos = 0;
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
		return this.health;
	}
	public void setLevel(@Min(0) int level) {
		this.level = level;
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
	
	public int getMapLevel() {
		return this.mapLevel;
	}
	public void setMapLevel(int mapLevel) {
		this.mapLevel = mapLevel;
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

	public String Getweapon() {
		String weapon = "Knife. +0 Attack\n";
		switch (this.weapon) {
			case 0:
				weapon = "Knife. +0 Attack\n";
				break;
			case 1:
				weapon = "Short sword. +1 Attack\n";
				break;
			case 2:
				weapon = "Longsword. +2 Attack\n";
				break;
		}
		return (weapon);
	}

	public void setWeapon(int weapon) {
		this.weapon = weapon;
	}

	public String getArmor() {
		String armor = "None. +0 Defense\n";
		switch (this.armor) {
			case 0:
				armor = "None: +0 Defense\n";
				break;
			case 1:
				armor = "Leather: +1 Defense\n";
				break;
			case 2:
				armor = "Chain mail: +2 Defense\n";
				break;
		}
		return (armor);
	}

	public void setArmor(int armor) {
		this.armor = armor;
	}

	public void changeLevel() {
		if (this.getExperience() >= 12200) {
			this.setLevel(5);
		} else if (this.getExperience() >= 8050) {
			this.setLevel(4);
		} else if (this.getExperience() >= 4800) {
			this.setLevel(3);
		} else if (this.getExperience() >= 2450) {
			this.setLevel(2);
		} else if (this.getExperience() >= 1000) {
			this.setLevel(1);
		} else {
			this.setLevel(0);
		}
	}

	@Override
	public String toString() {
		String weapon = this.Getweapon();
		String armor = this.getArmor();
		// String heroClass = this.heroClass;
		return "\n\nYOUR HERO:\nName: " + name + "\nClass: " + heroClass + "\n\nSTATS: " + "\nAttack: " + attack
		+ "\nDefense: " + defense + "\nHit Points: " + health + "\n\nEquipment:\n" + "Armor: " + armor + "Weapon: " + weapon + "\nLevel: " + level +"\nExperience: " + this.experience
		+ "\n\nVerticalpos: " + this.verticalPos + "\nHorizontalPos: " + this.horizontalPos;
	}
}