package com.ctaljaar.swingy.util;

import com.ctaljaar.swingy.model.Player;

import java.util.ArrayList;
import java.util.Scanner;

public class Globals {
    public static Scanner scanner = new Scanner(System.in);
	public static Player player;
	public static ArrayList<String> validCommands = new ArrayList<String>();

	public static void populateCommands() {
		validCommands.add("north");
		validCommands.add("up");
		validCommands.add("east");
		validCommands.add("right");
		validCommands.add("south");
		validCommands.add("down");
		validCommands.add("west");
		validCommands.add("left");
	}
}
