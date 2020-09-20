package com.ctaljaar.swingy.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleIntegration {
    public String consoleExecOutput(String inputCommand) throws IOException, InterruptedException {
        String consoleOutput="";

        Process proc = Runtime.getRuntime().exec(inputCommand);

        // Read the output

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(proc.getInputStream()));

        String line = "";
        while((line = reader.readLine()) != null) {
            System.out.print(line + "\n");
            consoleOutput=consoleOutput+line + "\n";
        }

        proc.waitFor();

        return consoleOutput;
    }
}