package com.gandalf1209.yge2.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JOptionPane;

public class Util {
	
	private static boolean loading = false;
	
	/**
	 * Returns the user's OS
	 * @return
	 */
	public static String getOS() {
		return System.getProperty("os.name");
	}
	
	/**
	 * Returns the user's name
	 * @return
	 */
	public static String getUsername() {
		return System.getProperty("user.name");
	}

	/**
	 * Returns a formatted string of the current date
	 * @return
	 */
	public static String getDate() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MM-dd-yy");
		return new String(ft.format(dNow));
	}
	
	/**
	 * Returns a formatted string of the current time
	 * @return
	 */
	public static String getTime() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
		return new String(ft.format(dNow));
	}
	
	/**
	 * Returns the location of the jar being run with a 
	 * specified name
	 * @param jarName
	 * @return
	 */
	public static String getJarLocation(String jarName) {
		String temp = Util.class.getClass().getProtectionDomain().getCodeSource().getLocation().getPath();
		String[] tempDir = temp.split("Server.jar");
		String temp2 = tempDir[0];
		String mainDir = temp2.replace("%20", " ");
		return mainDir;
	}
	
	/**
	 * Shows input text box, and returns the users input
	 * @param message
	 * @return
	 */
	public static String getInput(String message) {
		return JOptionPane.showInputDialog(message);
	}
	
	/**
	 * Shows a popup alert to the user
	 * @param message
	 */
	public static void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
	/**
	 * Prints a spinning icon to the console
	 * @param milliOffset
	 */
	public static void printLoadToConsole(int milliOffset) {
		loading = true;
		final Timer t = new Timer();
		TimerTask task = new TimerTask() {
			int loop = 0;
			public void run() {
				if (loading) {
					loop++;
					if (loop == 1) {
						System.out.print("\b|");
					}
					if (loop == 2) {
						System.out.print("\b/");
					}
					if (loop == 3) {
						System.out.print("\b-");
					}
					if (loop == 4) {
						System.out.print("\b\\");
						loop = 0;
					}
				} else {
					System.out.print("\b");
					t.cancel();
				}
			}
		};
		t.schedule(task, 00, milliOffset);
	}
	
	public static void stopLoading() {
		loading = false;
	}
	
}