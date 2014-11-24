package com.gandalf1209.yge2.engine;

import java.util.ArrayList;
import java.util.List;

public class Scene {

	private String name;
	private int place;
	public List<Mesh> meshes = new ArrayList<Mesh>();

	public static List<Scene> scenes = new ArrayList<Scene>();

	public Scene(String name) {
		this.name = name;
		this.place = scenes.size();
		scenes.add(this);
	}

	/**
	 * Updates the current scene's data
	 */
	private void update() {
		scenes.set(this.place, this);
	}

	/**
	 * Adds a mesh to be drawn in the scene
	 * @param mesh
	 */
	public void add(Mesh mesh) {
		meshes.add(mesh);
		update();
	}

	/**
	 * Returns the scene by it's name
	 * @param name
	 * @return
	 */
	public static Scene getSceneByName(String name) {
		Scene s = null;
		for (int i = 0; i < scenes.size(); i++) {
			if (scenes.get(i).name.equals(name)) {
				s = scenes.get(i);
				break;
			}
		}
		return s;
	}

}
