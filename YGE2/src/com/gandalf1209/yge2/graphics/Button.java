package com.gandalf1209.yge2.graphics;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

public class Button {

	private int x;
	private int y;
	private int w;
	private int h;
	private String text;
	private Color color;
	private ButtonListener bl;
	
	private static Display d;
	public static List<Button> list = new ArrayList<Button>();
	
	public Button(int x, int y, int w, int h, String text, Color color, ButtonListener bl) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.text = text;
		this.color = color;
		this.bl = bl;
		list.add(this);
	}
	
	public static void init(Display display) {
		d = display;
		d.getWindow().addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				for (int i = 0; i < list.size(); i++) {
					Button b = list.get(i);
					if (e.getX() > b.getX() &&
								e.getX() < b.getX() + b.getW() &&
								e.getY() > b.getY() &&
								e.getY() < b.getY() + b.getH()) {
						if (e.getButton() == 1) {
							b.getButtonListener().action();
						}
					}
				}
			}
		});
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
	public int getW() {
		return w;
	}
	
	public int getH() {
		return h;
	}
	
	public String getText() {
		return text;
	}
	
	public Color getColor() {
		return color;
	}
	
	public ButtonListener getButtonListener() {
		return bl;
	}
	
}