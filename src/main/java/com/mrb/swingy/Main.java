package com.mrb.swingy;

public class Main {

    public static void main(String[] args) {
        if (args.length != 1 || (!args[0].equals("console") && !args[0].equals("gui"))) {
            System.out.println("Usage: program console | gui");
            System.exit(1);
        }

        if (args[0].equals("console"))
            System.out.println("Console, huh?");
        else if (args[0].equals("gui"))
            System.out.println("GUI, huh?");
    }
}
