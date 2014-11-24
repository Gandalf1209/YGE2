package com.gandalf1209.yge2.engine;

import com.gandalf1209.yge2.graphics.GraphicsLoader;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Mesh {

	private Vector2 x;
	private Vector2 y;
	private Vector2 w;
	private Vector2 h;

	private BufferedImage material;
	private Color color = new Color(194, 194, 194);

	public Mesh(Vector2 x, Vector2 y, Vector2 w, Vector2 h) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}

	/**
	 * Sets the image to be drawn on the mesh
	 * @param url
	 */
	public void setMaterial(String url) {
		material = new GraphicsLoader().loadGraphic(url);
	}

	public void setColor(Color c) {
		color = c;
	}

	public Vector2 getX() {
		return x;
	}

	public void setX(Vector2 x) {
		this.x = x;
	}

	public Vector2 getY() {
		return y;
	}

	public void setY(Vector2 y) {
		this.y = y;
	}

	public Vector2 getW() {
		return w;
	}

	public void setW(Vector2 w) {
		this.w = w;
	}

	public Vector2 getH() {
		return h;
	}

	public void setH(Vector2 h) {
		this.h = h;
	}

	public Color getColor() {
		return color;
	}

	public BufferedImage getMaterial() {
		return material;
	}

}
