package com.gandalf1209.yge2.graphics;

import javax.swing.*;

import java.awt.*;

@SuppressWarnings("serial")
public class Window extends JFrame {

	/**
	 * Creates a new Window with a component attached
	 * @param title
	 * @param x
	 * @param y
	 * @param c
	 */
	public Window(String title, int x, int y, Component c) {
		this.add(c);
		this.pack();
		this.setTitle(title);
		this.setSize(x, y);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
		try {
			setIconImage(new GraphicsLoader().loadGraphic("/textures/face.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setVisible(true);
	}

	/**
	 * Creates a new Window without a component attached
	 * @param title
	 * @param x
	 * @param y
	 */
	public Window(String title, int x, int y) {
		this.setTitle(title);
		this.setSize(x, y);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
		try {
			setIconImage(new GraphicsLoader().loadGraphic("/textures/face.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setVisible(true);
	}

}
