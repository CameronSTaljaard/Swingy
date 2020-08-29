package com.ctaljaar.swingy.controller;

import java.io.Serializable;

public class Player implements Serializable{
	
	private static final long serialVersionUID = 1L;
	private String name;
	private int health;

	Player() {
	};

	Player(String name, int health) {
		this.name = name;
		this.health = health;
	}

	@Override
	public String toString() {
		return "Name:" + name + "\nHealth: " + health;
	}
}