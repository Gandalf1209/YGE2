package com.gandalf1209.yge2.graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;
import javax.swing.Timer;

import com.gandalf1209.yge2.engine.Game;
import com.gandalf1209.yge2.engine.Mesh;
import com.gandalf1209.yge2.engine.Scene;
import com.gandalf1209.yge2.engine.Vector2;

@SuppressWarnings("serial")
public class Display extends JComponent implements ActionListener {

	private Window frame;

	private Game game;
	private Timer t;
	private Scene s;
	private GraphicsX g;

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
	
	public void keyListener(KeyListener kl) {
		frame.addKeyListener(kl);
	}
	
	public void mouseListener(MouseListener ml) {
		frame.addMouseListener(ml);
	}
	
	public void mouseMotionListener(MouseMotionListener mml) {
		frame.addMouseMotionListener(mml);
	}

	public void loadScene(Scene s) {
		this.s = s;
	}

	protected void paintComponent(Graphics g) {
		Vector2.verteces.clear();
		GraphicsX gx = new GraphicsX(g, frame);
		this.g = gx;
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
	
	public GraphicsX getGraphics() {
		return g;
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		repaint();

		game.update();

	}
}
