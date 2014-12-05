package com.gandalf1209.yge2.util;

import java.awt.Color;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import com.gandalf1209.yge2.engine.Mathf;
import com.gandalf1209.yge2.engine.Vector2;
import com.gandalf1209.yge2.graphics.Display;

public class Source {

	private static Display d;

	private static String error = "Yamanu Source Error: ";

	/**
	 * Binds a display to the Source. Needed for any window/display
	 * commands
	 * @param d
	 */
	public static void bind(Display d) {
		Source.d = d;
	}

	/**
	 * Runs given commands. See the Source documentation for more
	 * information
	 * @param command
	 * @return
	 */
	public static Object run(String command) {
		Object o = null;
		String[] args = command.split(" ");
		if (args[0].equalsIgnoreCase("color")) {
			if (args[1].equalsIgnoreCase("get")) {
				o = d.getGraphics().getColor();
			} else if (args[1].equalsIgnoreCase("set")) {
				d.getGraphics().setColor(Color.decode(args[2]));
			} else {
				System.out.println(error + "Invalid color argument '" + args[1] + "'");
			}
		} else if (args[0].equalsIgnoreCase("window") || args[0].equalsIgnoreCase("display")) {
			if (args[1].equalsIgnoreCase("get")) {
				if (args[2].equalsIgnoreCase("width")) {
					o = d.getWindow().getWidth();
				} else if (args[2].equalsIgnoreCase("height")) {
					o = d.getWindow().getHeight();
				} else if (args[2].equalsIgnoreCase("title")) {
					o = d.getWindow().getTitle();
				} else if (args[2].equalsIgnoreCase("graphics")) {
					o = d.getGraphics();
				} else {
					System.out.println(error + "Invalid window argument '" + args[2] + "'");
				}
			} else if (args[1].equalsIgnoreCase("set")) {
				if (args[2].equalsIgnoreCase("width")) {
					d.getWindow().setSize(Integer.parseInt(args[3]), d.getWindow().getHeight());
				} else if (args[2].equalsIgnoreCase("height")) {
					d.getWindow().setSize(d.getWindow().getWidth(), Integer.parseInt(args[3]));
				} else if (args[2].equalsIgnoreCase("title")) {
					StringBuilder sb = new StringBuilder();
					for (int i = 3; i < args.length; i++) {
						sb.append(args[i]);
						if (i != args.length - 1) {
							sb.append(" ");
						}
					}
					d.getWindow().setTitle(sb.toString());
				} else {
					System.out.println(error + "Invalid window argument '" + args[2] + "'");
				}
			}
		} else if (args[0].equalsIgnoreCase("system")) {
			if (args[1].equalsIgnoreCase("os")) {
				o = System.getProperty("os.name");
			} else if (args[1].equalsIgnoreCase("user")) {
				o = System.getProperty("user.name");
			} else if (args[1].equals("arch")) {
				o = System.getProperty("os.arch");
			} else if (args[1].equals("freehd")) {
				File f = null;
				if (System.getProperty("os.name").contains("Windows")) {
					f = new File("C:\\");
				} else {
					f = new File("/");
				}
				int free = (int) (f.getFreeSpace() / 1024 / 1024);
				o = free + " MB (" + (free / 1024) + " GB)";
			} else {
				System.out.println(error + "Invalid system argument '" + args[1]
						+ "'");
			}
		} else if (args[0].equalsIgnoreCase("engine")) {
			if (args[1].equalsIgnoreCase("vertex")) {
				if (args[2].equalsIgnoreCase("get")) {
					o = Vector2.verteces.size();
				} else if (args[2].equalsIgnoreCase("clear")) {
					Vector2.verteces.clear();
				} else if (args[2].equalsIgnoreCase("translate")) {
					for (int i = 0; i < Vector2.verteces.size(); i++) {
						Vector2 v = Vector2.verteces.get(i);
						if (v != null) {
							v.translate(Integer.parseInt(args[3]), Integer.parseInt(args[4]));
						}
					}
				}
				else {
					System.out.println(error + "Invalid engine.vertex argument '" + args[2] + "'");
				}
			} else if (args[1].equalsIgnoreCase("math")) {
				if (args[2].equalsIgnoreCase("random")) {
					o = Mathf.random(Integer.parseInt(args[3]), Integer.parseInt(args[4]));
				} else if (args[2].equalsIgnoreCase("exp")) {
					o = (int)Math.pow(Integer.parseInt(args[3]), Integer.parseInt(args[4]));
				} else if (args[2].equalsIgnoreCase("path")) {
					o = (int)Mathf.path(Integer.parseInt(args[3]), Integer.parseInt(args[4]));
				} else if (args[2].equalsIgnoreCase("distance")) {
					o = (int)Mathf.distance(new Vector2(Integer.parseInt(args[3]),
														Integer.parseInt(args[4])), 
											new Vector2(Integer.parseInt(args[5]),
														Integer.parseInt(args[6])));
				}
				else {
					System.out.println(error + "Invalid engine.math argument '" + args[2] + "'");
				}
			}
			else {
				System.out.println("Invalid engine argument '" + args[1] + "'");
			}
		}
		else {
			System.out.println(error + "No such command '" + args[0] + "'");
		}
		return o;
	}

	/**
	 * Runs commands from a file
	 * @param file
	 */
	public static void file(String file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				if (line.contains("#log")) { 
					StringBuilder sb = new StringBuilder();
					String[] args = line.split(" ");
					for (int i = 1; i < args.length; i++) {
						sb.append(args[i]);
						if (i != args.length - 1) {
							sb.append(" ");
						}
					}
					System.out.println(sb.toString());
				} else if (line.contains("@log")) {
					String[] cmd = line.split("@log ");
					System.out.println(run(cmd[1]));
				}
				else {
					run(line);
				}
			}
			br.close();
		} catch (Exception e) {
			System.out.println(error + "Unable to run file " + file + "\n"
					+ e.getMessage());
			e.printStackTrace();
		}
	}

	/**
	 * Runs commands from a file
	 * @param file
	 */
	public static void file(File file) {
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while ((line = br.readLine()) != null) {
				run(line);
			}
			br.close();
		} catch (Exception e) {
			System.out.println(error + "Unable to run file "
					+ file.getAbsolutePath() + "\n" + e.getMessage());
			e.printStackTrace();
		}
	}

}