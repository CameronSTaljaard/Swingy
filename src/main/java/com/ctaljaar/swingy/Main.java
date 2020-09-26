package com.ctaljaar.swingy;

// import com.ctaljaar.swingy.controller.GameController;
// import java.awt.GraphicsConfiguration;

import javax.swing.*;
import java.awt.*;
import com.ctaljaar.swingy.controller.GameHandler;
import com.ctaljaar.swingy.util.Globals;
import com.ctaljaar.swingy.util.Terminal;
import com.ctaljaar.swingy.view.TextAreaLogProgram;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        if (args.length != 1 || (!args[0].equals("console") && !args[0].equals("gui"))) {
			System.out.println("Usage: java -jar [path] console | gui");
			System.exit(0);
		}
		
		Globals.populateCommands();
		
		if (args[0].equals("console")) {
			Terminal.clearScreen();
			GameHandler.GameController();
			System.exit(0);

		} else if (args[0].equals("gui")) {
			Globals.gui = true;
			Terminal.clearScreen();
			new TextAreaLogProgram();
			GameHandler.GameController();
			System.exit(0);
		}
	}
}
