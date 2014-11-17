package com.gandalf1209.yge2.graphics;

import javax.swing.*;

import java.awt.*;

@SuppressWarnings("serial")
public class Window extends JFrame {

	public Window(String title, int x, int y, Component c) {
		this.add(c);
		this.pack();
		this.setTitle(title);
		this.setMinimumSize(new Dimension(x, y));
		this.setMaximumSize(new Dimension(x, y));
		this.setPreferredSize(new Dimension(x, y));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(Window.EXIT_ON_CLOSE);
		try {
			setIconImage(new GraphicsLoader().loadGraphic("/textures/face.jpg"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.setVisible(true);
	}

	public Window(String title, int x, int y) {
		this.setTitle(title);
		this.setMinimumSize(new Dimension(x, y));
		this.setMaximumSize(new Dimension(x, y));
		this.setPreferredSize(new Dimension(x, y));
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
