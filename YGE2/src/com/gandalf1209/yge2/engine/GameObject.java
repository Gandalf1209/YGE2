package com.gandalf1209.yge2.engine;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import com.gandalf1209.gobj.Parser;

public class GameObject {

	public boolean DRAW_BORDER = false;
	public Color BORDER_COLOR = Color.black;
	
	private int[] xVerts;
	private int[] yVerts;
	private Color color;
	
	public static List<GameObject> list = new ArrayList<GameObject>();
	
	public GameObject(int[] xVerts, int[] yVerts, Color color) {
		this.xVerts = xVerts;
		this.yVerts = yVerts;
		this.color = color;
		list.add(this);
	}
	
	public GameObject(GameObject obj) {
		this.xVerts = obj.getXVerts();
		this.yVerts = obj.getYVerts();
		this.color = obj.getColor();
		list.add(this);
	}
	
	public static GameObject createFromFile(String url) {
		return Parser.parseFile(url, "-l");
	}
	
	public static GameObject clone(GameObject obj) {
		return new GameObject(obj);
	}
	
	public void translate(int x, int y) {
		for (int i = 0; i < xVerts.length; i++) {
			setXVertex(i, getXVertex(i) + x);
			setYVertex(i, getYVertex(i) + y);
		}
	}

	public int getXVertex(int v) {
		return xVerts[v];
	}
	
	public void setXVertex(int v, int val) {
		xVerts[v] = val;
	}
	
	public int getYVertex(int v) {
		return yVerts[v];
	}
	
	public void setYVertex(int v, int val) {
		yVerts[v] = val;
	}
	
	public int[] getXVerts() {
		return xVerts;
	}

	public void setXVerts(int[] xVerts) {
		this.xVerts = xVerts;
	}

	public int[] getYVerts() {
		return yVerts;
	}

	public void setYVerts(int[] yVerts) {
		this.yVerts = yVerts;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
}