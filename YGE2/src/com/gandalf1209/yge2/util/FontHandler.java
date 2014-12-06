package com.gandalf1209.yge2.util;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.File;

public class FontHandler {

	private String def = "";
	
	public void setDefaultLoadingDirectory(String url) {
		def = url;
	}
	
	public void loadFont(String url) {
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.PLAIN, this.getClass().getResourceAsStream(def + url)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void loadExternalFont(String url) {
		try {
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(Font.createFont(Font.PLAIN, new File(def + url)));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
