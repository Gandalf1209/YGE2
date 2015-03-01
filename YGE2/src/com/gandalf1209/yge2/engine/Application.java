package com.gandalf1209.yge2.engine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.gandalf1209.yge2.util.CrashHandler;

public class Application {

	public static String NAME;
	public static String VERSION;
	public static String AUTHOR;
	
	public static void start() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(Application.class.getResourceAsStream("/yamanu/data.ymn")));
			String line;
			while((line = br.readLine()) != null) {
				String[] types = line.split("=");
				if (types[0].equalsIgnoreCase("name")) {
					NAME = types[1];
				}
				if (types[0].equalsIgnoreCase("version")) {
					VERSION = types[1];
				}
				if (types[0].equalsIgnoreCase("author")) {
					AUTHOR = types[1];
				}
			}
		} catch (IOException e) {
			CrashHandler.logCrash(e, Application.class.getClass());
			CrashHandler.printCrash(e, Application.class.getClass());
		}
	}
	
}