package com.ctaljaar.swingy.controller;

import java.io.*;
import com.ctaljaar.swingy.model.Player;

public class CharacterHandler {

	public static void readCharacter(String name) {

		try {
			FileInputStream fi = null;
			ObjectInputStream oi = new ObjectInputStream(fi);
			Player pr1 = (Player) oi.readObject();
			
			fi = new FileInputStream("saves/heroes/" + name + ".txt");

			System.out.println(pr1.toString());
			oi.close();
			fi.close();

		} catch (FileNotFoundException e) {
			System.out.println("Character does not exist");
		} catch (IOException e) {
			System.out.println("Error initializing stream");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}