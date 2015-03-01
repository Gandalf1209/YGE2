package com.gandalf1209.yge2.util;

import java.io.File;

public class ScriptHandler {

	@SuppressWarnings("unused")
	public static void runScript(String loc, String type, boolean out) {
		String pwd = System.getProperty("user.dir");
		try {
			File file = new File(pwd + "/out.txt");
			file.createNewFile();
			if (type.equalsIgnoreCase("shell")) {
				Runtime.getRuntime().exec("sh " + loc + " >> '" + pwd + "/out.txt'");
			}
			if (type.equalsIgnoreCase("batch")) {
				Runtime.getRuntime().exec(loc + " >> '" + pwd + "/out.txt'");
			}
			if (type.equalsIgnoreCase("python")) {
				Runtime.getRuntime().exec("python " + loc + " >> '" + pwd + "/out.txt'");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (out) {
			readOut();
		} else {
			File f = new File(pwd + "/out.txt");
			//f.delete();
		}
	}
	
	private static void readOut() {
		File f = new File(System.getProperty("user.dir") + "/out.txt");
		String out = FileHandler.getContents(f.getAbsolutePath());
		if (!out.isEmpty()) {
			readOut();
		} else {
			System.out.println(out);
			//f.delete();
		}
	}
	
}