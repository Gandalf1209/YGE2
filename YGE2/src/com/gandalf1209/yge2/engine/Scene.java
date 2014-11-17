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

	private void update() {
		scenes.set(this.place, this);
	}

	public void add(Mesh mesh) {
		meshes.add(mesh);
		update();
	}

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
