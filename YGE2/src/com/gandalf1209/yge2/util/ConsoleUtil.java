package com.gandalf1209.yge2.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.gandalf1209.yge2.engine.SystemData;

public class ConsoleUtil {

	public static void clearScreen() {
		String clear = "";
		if (SystemData.OS.contains("Windows")) {
			clear = "cls";
		} else {
			clear = "clear";
		}
		
		try {
			runCommandWithOutput(clear);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void runCommandWithOutput(String cmd) throws IOException {
		Runtime rt = Runtime.getRuntime();
		Process pr = rt.exec(cmd);
		
		BufferedReader br = new BufferedReader(new InputStreamReader(pr.getInputStream()));
		String line = "";
		while ((br.readLine()) != null) {
			System.out.println(line);
		}
	}
	
	public static void runCommand(String cmd) throws IOException {
		Runtime rt = Runtime.getRuntime();
		@SuppressWarnings("unused")
		Process pr = rt.exec(cmd);
	}
	
}