package com.gandalf1209.yge2.util;

import java.text.SimpleDateFormat;
import java.util.Date;

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
	
	public String getTime() {
		Date dNow = new Date();
		SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss");
		return new String(ft.format(dNow));
	}
	
}