package com.ctaljaar.swingy.view;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.util.Scanner;
import java.util.Date;
 
import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
 
public class TextAreaLogProgram extends JFrame {

	private static final long serialVersionUID = 1L;
    /**
     * The text area which is used for displaying logging information.
     */
     
    public TextAreaLogProgram() {

		// super("Demo printing to JTextArea");
		
        JFrame frame = new JFrame();
        frame.setSize(400, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		final JTextArea textArea = new JTextArea();
		JScrollPane scrollPane = new JScrollPane(textArea);
		// caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

		final PrintStream printstream = new PrintStream(new CustomOutputStream(textArea));

		System.setOut(printstream);
		System.setErr(printstream);

		// frame.add(textArea);
		frame.add(scrollPane);

        frame.setVisible(true);
	}
}