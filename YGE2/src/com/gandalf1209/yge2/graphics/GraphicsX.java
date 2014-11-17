package com.gandalf1209.yge2.graphics;

import com.gandalf1209.yge2.engine.Vector2;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class GraphicsX extends Graphics {

	private Graphics g;
	private com.gandalf1209.yge2.graphics.Window w;

	public GraphicsX(Graphics g, com.gandalf1209.yge2.graphics.Window w) {
		this.g = g;
		this.w = w;
	}

	public Color hex(String hex) {
		return Color.decode(hex);
	}

	public void fillRect(Vector2 x, Vector2 y, Vector2 w, Vector2 h) {
		int[] dx = new int[] {x.getX(), y.getX(), w.getX(), h.getX()};
		int[] dy = new int[] {x.getY(), y.getY(), w.getY(), h.getY()};
		Polygon p = new Polygon(dx, dy, 4);
		g.fillPolygon(p);
	}

	@SuppressWarnings("unused")
	public void addImage(Image img, Vector2 x, Vector2 y, Vector2 w, Vector2 h) {
		int ax = x.getX();
		int ay = x.getY();
		int bx = y.getX();
		int by = y.getY();
		int cx = w.getX();
		int cy = w.getY();
		int dx = h.getX();
		int dy = h.getY();

		this.addImage(img, ax, ay, cx - ax, dy - ay);
	}

	public void setBGColor(Color bg) {
		Color def = g.getColor();
		g.setColor(bg);
		g.fillRect(0, 0, w.getWidth(), w.getHeight());
		g.setColor(def);
	}

	public void setBGImage(Image img) {
		addImage(img, 0, 0, w.getWidth(), w.getHeight());
	}

	public void addImage(Image image, int x, int y, int width, int height) {
		this.drawImage(image, x, y, width, height, null);
	}

	public void drawTriangle(Vector2 p1, Vector2 p2, Vector2 p3) {
		int[] x = new int[] {p1.getX(), p2.getX(), p3.getX()};
		int[] y = new int[] {p1.getY(), p2.getY(), p3.getY()};
		Polygon p = new Polygon(x, y, 3);
		g.drawPolygon(p);
	}

	public void fillTriangle(Vector2 p1, Vector2 p2, Vector2 p3) {
		int[] x = new int[] {p1.getX(), p2.getX(), p3.getX()};
		int[] y = new int[] {p1.getY(), p2.getY(), p3.getY()};
		Polygon p = new Polygon(x, y, 3);
		g.fillPolygon(p);
	}

	/*
	*
	*   Below is code from Graphics class that is implemented in Graphics class
	*
	 */

	@Override
	public Graphics create() {
		return g;
	}

	@Override
	public void translate(int x, int y) {
		g.translate(x, y);
	}

	@Override
	public Color getColor() {
		return g.getColor();
	}

	@Override
	public void setColor(Color c) {
		g.setColor(c);
	}

	@Override
	public void setPaintMode() {
		g.setPaintMode();
	}

	@Override
	public void setXORMode(Color c1) {
		g.setXORMode(c1);
	}

	@Override
	public Font getFont() {
		return g.getFont();
	}

	@Override
	public void setFont(Font font) {
		g.setFont(font);
	}

	@Override
	public FontMetrics getFontMetrics(Font f) {
		return g.getFontMetrics(f);
	}

	@Override
	public Rectangle getClipBounds() {
		return g.getClipBounds();
	}

	@Override
	public void clipRect(int x, int y, int width, int height) {
		g.clipRect(x, y, width, height);
	}

	@Override
	public void setClip(int x, int y, int width, int height) {
		g.setClip(x, y, width, height);
	}

	@Override
	public Shape getClip() {
		return g.getClip();
	}

	@Override
	public void setClip(Shape clip) {
		g.setClip(clip);
	}

	@Override
	public void copyArea(int x, int y, int width, int height, int dx, int dy) {
		g.copyArea(x, y, width, height, dx, dy);
	}

	@Override
	public void drawLine(int x1, int y1, int x2, int y2) {
		g.drawLine(x1, y1, x2, y2);
	}

	@Override
	public void fillRect(int x, int y, int width, int height) {
		g.fillRect(x, y, width, height);
	}

	@Override
	public void clearRect(int x, int y, int width, int height) {
		g.clearRect(x, y, width, height);
	}

	@Override
	public void drawRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
		g.drawRoundRect(x, y, width, height, arcWidth, arcHeight);
	}

	@Override
	public void fillRoundRect(int x, int y, int width, int height, int arcWidth, int arcHeight) {
		g.fillRoundRect(x, y, width, height, arcHeight, arcHeight);
	}

	@Override
	public void drawOval(int x, int y, int width, int height) {
		g.drawOval(x, y, width, height);
	}

	@Override
	public void fillOval(int x, int y, int width, int height) {
		g.fillOval(x, y, width, height);
	}

	@Override
	public void drawArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
		g.drawArc(x, y, width, height, startAngle, arcAngle);
	}

	@Override
	public void fillArc(int x, int y, int width, int height, int startAngle, int arcAngle) {
		g.fillArc(x, y, width, height, startAngle, arcAngle);
	}

	@Override
	public void drawPolyline(int[] xPoints, int[] yPoints, int nPoints) {
		g.drawPolyline(xPoints, yPoints, nPoints);
	}

	@Override
	public void drawPolygon(int[] xPoints, int[] yPoints, int nPoints) {
		g.drawPolyline(xPoints, yPoints, nPoints);
	}

	@Override
	public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
		g.fillPolygon(xPoints, yPoints, nPoints);
	}

	@Override
	public void drawString(String str, int x, int y) {
		g.drawString(str, x, y);
	}

	@Override
	public void drawString(AttributedCharacterIterator iterator, int x, int y) {
		g.drawString(iterator, x, y);
	}

	@Override
	public boolean drawImage(Image img, int x, int y, ImageObserver observer) {
		return g.drawImage(img, x, y, observer);
	}

	@Override
	public boolean drawImage(Image img, int x, int y, int width, int height, ImageObserver observer) {
		return g.drawImage(img, x, y, width, height, observer);
	}

	@Override
	public boolean drawImage(Image img, int x, int y, Color bgcolor, ImageObserver observer) {
		return g.drawImage(img, x, y, bgcolor, observer);
	}

	@Override
	public boolean drawImage(Image img, int x, int y, int width, int height, Color bgcolor, ImageObserver observer) {
		return g.drawImage(img, x, y, width, height, bgcolor, observer);
	}

	@Override
	public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, ImageObserver observer) {
		return g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, observer);
	}

	@Override
	public boolean drawImage(Image img, int dx1, int dy1, int dx2, int dy2, int sx1, int sy1, int sx2, int sy2, Color bgcolor, ImageObserver observer) {
		return g.drawImage(img, dx1, dy1, dx2, dy2, sx1, sy1, sx2, sy2, bgcolor, observer);
	}

	@Override
	public void dispose() {
		g.dispose();
	}
}
