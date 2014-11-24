package com.gandalf1209.yge2.engine;

import java.util.ArrayList;
import java.util.List;

public class Vector2 {

	private int x;
	private int y;
	
	public static List<Vector2> verteces = new ArrayList<Vector2>();

	public Vector2(int x, int y) {
		this.x = x;
		this.y = y;
		verteces.add(this);
	}
	
	public void translate(int x, int y) {
		this.x += x;
		this.y += y;
	}
	
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getX() {
		return x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

}
