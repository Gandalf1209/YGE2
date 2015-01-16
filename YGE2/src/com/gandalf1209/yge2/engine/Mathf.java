package com.gandalf1209.yge2.engine;

import java.util.Random;

public class Mathf {

	/**
	 * Returns a random number between the specified max and min
	 * numbers
	 * @param min
	 * @param max
	 * @return
	 */
	public static int random(int min, int max) {
		int r = 0;
		r = new Random().nextInt(max - min) + min;
		return r;
	}

	/**
	 * Basically the Pythagorean Theorem
	 * @param x
	 * @param y
	 * @return
	 */
	public static int path(int x, int y) {
		int path = 0;
		int xs = (int)Math.pow(x, 2);
		int ys = (int)Math.pow(y, 2);
		path = (int)Math.sqrt(xs + ys);
		return path;
	}

	/**
	 * The distance between two points
	 * @param a
	 * @param b
	 * @return
	 */
	public static int distance(Vector2 a, Vector2 b) {
		int dist = 0;
		int x = Math.abs(a.getX() - b.getX());
		int y = Math.abs(a.getY() - b.getY());
		dist = path(x, y);
		return dist;
	}
	
	public static Integer[] toIntegerObject(int[] intArray) {
		Integer[] result = new Integer[intArray.length];
		for (int i = 0; i < intArray.length; i++) {
			result[i] = Integer.valueOf(intArray[i]);
		}
		return result;
	}
	
	public static int[] toIntValue(Integer[] integerArray) {
		int[] result = new int[integerArray.length];
		for (int i = 0; i < integerArray.length; i++) {
			result[i] = integerArray[i].intValue();
		}
		return result;
	}

}
