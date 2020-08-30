package com.ctaljaar.swingy;

import com.ctaljaar.swingy.controller.CharacterHandler;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        if (args.length != 1 || (!args[0].equals("console") && !args[0].equals("gui"))) {
            System.out.println("Usage: program console | gui");
			CharacterHandler.readCharacter("Undyne");
            System.exit(0);
        }

		if (args[0].equals("console")) {
		
			int result;

			result = CharacterHandler.creationController();
			if (result == 1) {
				System.out.println("Character created.");
			} else if (result == 2) {
				System.out.println("Character already exists");
			} else if (result == 3){
				System.out.println("Invalid Class choice");
			} else {
				System.out.println("Invalid name");
			}
		}
        else if (args[0].equals("gui"))
            System.out.println("GUI, huh?");
    }
}
