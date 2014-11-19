package com.gandalf1209.yge2.engine;

public class Vector2 {

	private int x;
	private int y;

	public Vector2(int x, int y) {
		this.x = x;
		this.y = y;
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
