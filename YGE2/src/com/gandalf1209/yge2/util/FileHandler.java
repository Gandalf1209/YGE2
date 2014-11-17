package com.gandalf1209.yge2.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class FileHandler {

	public static String getContents(String loc) {
		StringBuilder sb = new StringBuilder();
		File f = new File(loc);
		if (f.exists()) {
			try {
				BufferedReader br = new BufferedReader(new FileReader(f));
				String line;
				while ((line = br.readLine()) != null) {
					sb.append(line).append("\n");
				}
				br.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else {
			sb.append("Error: File does not exist!");
		}
		return sb.toString();
	}
	
}