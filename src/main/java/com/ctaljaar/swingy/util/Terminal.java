package com.ctaljaar.swingy.util;

public class Terminal {
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
}
