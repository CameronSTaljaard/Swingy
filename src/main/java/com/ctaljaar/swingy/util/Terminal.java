package com.ctaljaar.swingy.util;

public class Terminal {
	public static void clearScreen() {
		if (Globals.gui == false) {
			System.out.print("\033[H\033[2J");
			System.out.flush();
			System.out.println("Globals.gui == " + Globals.gui);
		}
	}
}
