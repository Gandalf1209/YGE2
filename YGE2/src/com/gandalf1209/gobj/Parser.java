package com.gandalf1209.gobj;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import com.gandalf1209.yge2.engine.GameObject;
import com.gandalf1209.yge2.engine.Mathf;

public class Parser {
	
	private static boolean setVert = false;
	private static String fileName;
	
	private static List<Integer> x = new ArrayList<Integer>();
	private static List<Integer> y = new ArrayList<Integer>();
	private static int[] xv;
	private static int[] yv;
	private static Color color = Color.darkGray;
	private static Color bcolor = Color.black;
	private static boolean border = false;
	
	public static GameObject parseFile(String loc, String opt) {
		String modLoc = loc.replace("\\", "/");
		String[] name = modLoc.split("/");
		fileName = name[name.length - 1];
		BufferedReader br = null;
		try {
			if (opt.equals("-l")) {
				br = new BufferedReader(new InputStreamReader(Parser.class.getResourceAsStream(loc)));
			}
			String line;
			int num = 0;
			while ((line = br.readLine()) != null) {
				num++;
				parseLine(line, num);
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		GameObject obj = new GameObject(xv, yv, color);
		obj.DRAW_BORDER = border;
		obj.BORDER_COLOR = bcolor;
		clear();
		return obj;
	}
	
	public static void parseLine(String line, int num) {
		try {
			if (line.equals("@vert")) {
				setVert = true;
			}
			if (line.equals("@endv")) {
				setVert = false;
				xv = Mathf.toIntValue((Integer[]) x.toArray(new Integer[x.size()]));
				yv = Mathf.toIntValue((Integer[]) y.toArray(new Integer[y.size()]));
			}
			if (setVert && !line.equals("@vert") && !line.equals("@endv")) {
				String[] args = line.split(",");
				x.add(Integer.parseInt(args[0].trim()));
				y.add(Integer.parseInt(args[1].trim()));
			} else {
				if (line.equals("@create")) {
					return;
				}
				if (line.startsWith("#color")) {
					String[] args = line.replace("#color", "").split(",");
					color = new Color(Integer.parseInt(args[0].trim()),
							Integer.parseInt(args[1].trim()),
							Integer.parseInt(args[2].trim()));
				}
				if (line.startsWith("#border")) {
					String bool = line.replace("#border", "").trim();
					border = bool.equalsIgnoreCase("true");
				}
				if (line.startsWith("#bcolor")) {
					String[] args = line.replace("#bcolor", "").split(",");
					bcolor = new Color(Integer.parseInt(args[0].trim()),
							Integer.parseInt(args[1].trim()),
							Integer.parseInt(args[2].trim()));
				}
			}
		} catch (Exception e) {
			System.err.println("GOBJ Error - " + fileName + ":" + num);
			System.err.println(e.getMessage());
			System.exit(-1);
		}
	}
	
	public static void clear() {
		x.clear();
		y.clear();
		xv = null;
		yv = null;
		color = Color.darkGray;
		bcolor = Color.black;
		border = false;
		fileName = "";
	}
	
}