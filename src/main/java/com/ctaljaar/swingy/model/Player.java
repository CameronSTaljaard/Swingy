package com.ctaljaar.swingy.model;

import java.io.Serializable;

public class Player implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private int health;
	private String heroClass;
	private int level;
	private int attack;
	private int defense;
	private int experience;

	Player() {
	};

	public Player(String name, String heroClass) {
		this.name = name;
		this.heroClass = heroClass;
		if (heroClass == "Warrior") {
			this.attack = 5;
			this.defense = 5;
			this.health = 5;
		} else if (heroClass == "Ranger") {
			this.attack = 8;
			this.defense = 3;
			this.health = 4;
		} else {
			this.attack = 3;
			this.defense = 6;
			this.health = 6;
		}
		this.experience = 0;
		this.level = experience / 5;
	}

	@Override
	public String toString() {
		return "Name: " + name + "\nClass: " + heroClass + "\n\nSTATS: " + "\nAttack: " + attack
		+ "\nDefense: " + defense + "\nHit Points: " + health + "\n\nLevel: " + level + "\nExperience: " + experience;
	}
}