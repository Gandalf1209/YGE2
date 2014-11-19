package com.gandalf1209.yge2.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JOptionPane;

public class Util {
	
	public static String getOS() {
		return System.getProperty("os.name");
	}
	
	public static String getUsername() {
		return System.getProperty("user.name");
	}

	public static String getDate() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("MM-dd-yy");
		return new String(ft.format(dNow));
	}
	
	public static String getTime() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
		return new String(ft.format(dNow));
	}
	
	public static String getInput(String message) {
		return JOptionPane.showInputDialog(message);
	}
	
	public static void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}
	
}