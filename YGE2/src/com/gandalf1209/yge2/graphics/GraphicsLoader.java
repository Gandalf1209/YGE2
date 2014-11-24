package com.gandalf1209.yge2.graphics;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class GraphicsLoader {

	private String def = "";

	/**
	 * Loads an image and returns that image
	 * @param path
	 * @return
	 */
	public BufferedImage loadGraphic(String path) {
		BufferedImage b = null;
		try {
			b = ImageIO.read(getClass().getResourceAsStream(def + path));
		} catch (Exception e) {
			System.out.println("Error loading graphics from: " + (def + path));
			System.out.println(e.getMessage() + ", " + e.getCause());
		}
		return b;
	}

	/**
	 * Sets the location for all images to be loaded from
	 * @param path
	 */
	public void setDefaultLoadingDirectory(String path) {
		def = path;
	}

}
