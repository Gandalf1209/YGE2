package com.gandalf1209.yge2.graphics;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.JComponent;

import com.gandalf1209.yge2.engine.Game;
import com.gandalf1209.yge2.engine.Mesh;
import com.gandalf1209.yge2.engine.Scene;
import com.gandalf1209.yge2.engine.Vector2;

@SuppressWarnings("serial")
public class Display extends JComponent {

	private Window frame;

	private Game game;
	private Scene s;
	private GraphicsX g;
	private boolean running = false;

	public Display(String title, int x, int y, Game game) {
		this.game = game;
		this.frame = new Window(title, x, y, this);
	}

	/**
	 * Returns the Window the Display is attached to
	 * @return
	 */
	public Window getWindow() {
		return frame;
	}

	/**
	 * Starts the loop with a specified delay between frames.
	 * @param time
	 */
	public void start(final int fps) {
		Thread disp = new Thread("Display Thread") {
			public void run() {
				while (running) {
					repaint();
					game.update();
					try {
						Thread.sleep(1000/fps);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		};
		running = true;
		disp.start();
	}
	
	/**
	 * Pauses the loop
	 */
	public void pause() {
		running = false;
	}
	
	/**
	 * Adds a KeyListener to the Window
	 * @param kl
	 */
	public void keyListener(KeyListener kl) {
		frame.addKeyListener(kl);
	}
	
	/**
	 * Adds a MouseListener to the Window
	 * @param ml
	 */
	public void mouseListener(MouseListener ml) {
		frame.addMouseListener(ml);
	}
	
	/**
	 * Adds a MouseMotionListener to the Window
	 * @param mml
	 */
	public void mouseMotionListener(MouseMotionListener mml) {
		frame.addMouseMotionListener(mml);
	}

	/**
	 * Sets the scene to be displayed in Window
	 * @param s
	 */
	public void loadScene(Scene s) {
		this.s = s;
	}

	/**
	 * Draws everything it needs to
	 */
	protected void paintComponent(Graphics g) {
		Vector2.verteces.clear();
		GraphicsX gx = new GraphicsX(g, frame);
		this.g = gx;
		gx.setColor(gx.BG_COLOR);
		gx.fillRect(0, 0, frame.getWidth(), frame.getHeight());
		if (s != null) {
			renderMesh(gx);
		}
		game.render(gx);
		for (int i = 0; i < Button.list.size(); i++) {
			Button b = Button.list.get(i);
			gx.setColor(b.getColor());
			gx.fillRect(b.getX(), b.getY(), b.getW(), b.getH());
			gx.setColor(gx.hex("#00000"));
			g.drawString(b.getText(), b.getX() + 10, b.getY() + 5);
		}
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
}
