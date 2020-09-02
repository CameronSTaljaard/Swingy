package com.ctaljaar.swingy.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class FileHandler {
	public static boolean saveCharacter(String name, String heroClass) {

		Player p1 = new Player(name, heroClass);

		try {
			FileOutputStream f = new FileOutputStream(new File("saves/heroes/" + name + ".txt"));
			ObjectOutputStream o = new ObjectOutputStream(f);

			o.writeObject(p1);

			o.close();
			f.close();
			return (true);

		} catch (FileNotFoundException e) {
			return (false);
		} catch (IOException e) {
			return (false);
		} catch (Exception e) {
			return (false);
		}
	}
}