package com.gandalf1209.yge2.graphics;

import com.gandalf1209.yge2.engine.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

@SuppressWarnings("serial")
public class Display extends JComponent implements ActionListener {

	private Window frame;

	private Game game;
	private Timer t;
	private Scene s;

	public Display(String title, int x, int y, Game game) {
		this.game = game;
		this.frame = new Window(title, x, y, this);
	}

	public Window getWindow() {
		return frame;
	}

	public void initTime(int time) {
		t = new Timer(time, this);
		t.start();
	}

	public void loadScene(Scene s) {
		this.s = s;
	}

	protected void paintComponent(Graphics g) {
		GraphicsX gx = new GraphicsX(g, frame);
		gx.setColor(Color.black);
		gx.fillRect(0, 0, frame.getWidth(), frame.getHeight());
		if (s != null) {
			renderMesh(gx);
		}
		game.render(gx);
	}

	private void renderMesh(GraphicsX g) {
		for (int i = 0; i < s.meshes.size(); i++) {
			Mesh m = s.meshes.get(i);
			g.setColor(m.getColor());
			g.fillRect(m.getX(), m.getY(), m.getW(), m.getH());
			if (m.getMaterial() != null) {
				g.addImage(m.getMaterial(), m.getX(), m.getY(), m.getW(), m.getH());
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		repaint();

		game.update();

	}
}
