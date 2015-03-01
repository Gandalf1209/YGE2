package com.gandalf1209.yge2.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;

import com.gandalf1209.yge2.engine.Application;
import com.gandalf1209.yge2.engine.SystemData;

public class CrashHandler {

	public static void printCrash(Exception e, Class<?> c) {
		System.out.println("Yamanu Application Crash - " + Util.getTime() + "\n");
		System.out.println("Application Information:");
		System.out.println("\tName: " + Application.NAME);
		System.out.println("\tVersion: " + Application.VERSION);
		System.out.println("\tAuthor: " + Application.AUTHOR + "\n");
		System.out.println("Error:");
		System.out.println("\tException Type:" + e.getClass().getName());
		System.out.println("\tError Message: " + e.getMessage());
		System.out.println("\tCause: " + e.getCause());
		System.out.println("\tError Origin: " + c.getSimpleName() + "\n");
		System.out.println("Other Information:");
		System.out.println("\tYamanu Version: " + SystemData.YAMANU_VERSION);
	}
	
	public static void logCrash(Exception e, Class<?> c) {
		try {
			BufferedWriter bw = new BufferedWriter(new FileWriter(new File(SystemData.TEMP_FOLDER + "/" + Application.NAME + "-crash.txt")));
			bw.write("Yamanu Application Crash - " + Util.getTime() + "\n");
			bw.newLine();
			bw.write("Application Information:");
			bw.newLine();
			bw.write("\tName: " + Application.NAME);
			bw.newLine();
			bw.write("\tVersion: " + Application.VERSION);
			bw.newLine();
			bw.write("\tAuthor: " + Application.AUTHOR + "\n");
			bw.newLine();
			bw.write("Error:");
			bw.newLine();
			bw.write("\tException Type:" + e.getClass().getName());
			bw.newLine();
			bw.write("\tError Message: " + e.getMessage());
			bw.newLine();
			bw.write("\tCause: " + e.getCause());
			bw.newLine();
			bw.write("\tError Origin: " + c.getSimpleName() + "\n");
			bw.newLine();
			bw.write("Other Information:");
			bw.newLine();
			bw.write("\tYamanu Version: " + SystemData.YAMANU_VERSION);
			bw.close();
		} catch (Exception ex) {
			printCrash(ex, CrashHandler.class.getClass());
		}
	}
	
}