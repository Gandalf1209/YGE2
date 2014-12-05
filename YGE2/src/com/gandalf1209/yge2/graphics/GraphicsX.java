package com.gandalf1209.yge2.graphics;

import com.gandalf1209.yge2.engine.Vector2;

import java.awt.*;
import java.awt.image.ImageObserver;
import java.text.AttributedCharacterIterator;

public class GraphicsX extends Graphics {

	private Graphics g;
	private com.gandalf1209.yge2.graphics.Window w;
	
	public boolean DRAW_3D_BORDER = false;
	public int OVERALL_SHADOW_OFFSET = 20;
	public int RECT_DEPTH_OFFSET = 3;
	
	public GraphicsX(Graphics g, com.gandalf1209.yge2.graphics.Window w) {
		this.g = g;
		this.w = w;
	}
	
	public void drawLine(Vector2 v1, Vector2 v2) {
		g.drawLine(v1.getX(), v1.getY(), v2.getX(), v2.getY());
	}

	public void drawPixel(Vector2 p) {	
		g.fillRect(p.getX(), p.getY(), 1, 1);
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

	public void addImage(Image img, Vector2 p, int width, int height) {
		addImage(img, p.getX(), p.getY(), width, height);
		Vector2.verteces.add(null);
		Vector2.verteces.add(null);
		Vector2.verteces.add(null);
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
		Vector2.verteces.add(null);
		Vector2.verteces.add(null);
		Vector2.verteces.add(null);
		Vector2.verteces.add(null);
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
	 * Below is the 3D code from original Yamanu
	 * 
	 */
	
	public void fill3DRect(int x, int y, int w, int h)
	  {
	    Color fill = this.g.getColor();
	    this.g.fillRect(x, y, w, h);
	    this.g.setColor(Color.black);
	    if (this.DRAW_3D_BORDER) {
	      this.g.drawRect(x, y, w, h);
	    }

	    int tr = fill.getRed();
	    int tg = fill.getGreen();
	    int tb = fill.getBlue();

	    if (tr < this.OVERALL_SHADOW_OFFSET)
	      tr = Math.abs(tr) / 2;
	    else {
	      tr -= this.OVERALL_SHADOW_OFFSET;
	    }

	    if (tg < this.OVERALL_SHADOW_OFFSET)
	      tg = Math.abs(tg) / 2;
	    else {
	      tg -= this.OVERALL_SHADOW_OFFSET;
	    }

	    if (tb < this.OVERALL_SHADOW_OFFSET)
	      tb = Math.abs(tb) / 2;
	    else {
	      tb -= this.OVERALL_SHADOW_OFFSET;
	    }

	    Color topc = new Color(tr, tg, tb);
	    this.g.setColor(topc);
	    Polygon top = new Polygon(new int[] { x, x + w / this.RECT_DEPTH_OFFSET, x + w + w / this.RECT_DEPTH_OFFSET, x + w }, 
	      new int[] { y, y - h / this.RECT_DEPTH_OFFSET, y - h / this.RECT_DEPTH_OFFSET, y }, 4);
	    this.g.fillPolygon(top);
	    this.g.setColor(Color.black);
	    if (this.DRAW_3D_BORDER) {
	      this.g.drawPolygon(top);
	    }

	    int sr = topc.getRed();
	    int sg = topc.getGreen();
	    int sb = topc.getBlue();

	    if (sr < this.OVERALL_SHADOW_OFFSET)
	      sr = Math.abs(sr);
	    else {
	      sr -= this.OVERALL_SHADOW_OFFSET;
	    }

	    if (sg < this.OVERALL_SHADOW_OFFSET)
	      sg = Math.abs(sg);
	    else {
	      sg -= this.OVERALL_SHADOW_OFFSET;
	    }

	    if (sb < this.OVERALL_SHADOW_OFFSET)
	      sb = Math.abs(sb);
	    else {
	      sb -= this.OVERALL_SHADOW_OFFSET;
	    }

	    Color sidec = new Color(sr, sg, sb);
	    this.g.setColor(sidec);
	    Polygon side = new Polygon(new int[] { x + w, x + w + w / this.RECT_DEPTH_OFFSET, x + w + w / this.RECT_DEPTH_OFFSET, x + w }, 
	      new int[] { y, y - h / this.RECT_DEPTH_OFFSET, y + h - h / this.RECT_DEPTH_OFFSET, y + h }, 4);
	    this.g.fillPolygon(side);
	    this.g.setColor(Color.black);
	    if (this.DRAW_3D_BORDER)
	      this.g.drawPolygon(side);
	    
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	  }

	  public void fill3DRect(int x, int y, int w, int h, int offset)
	  {
	    Color fill = this.g.getColor();
	    this.g.fillRect(x, y, w, h);
	    this.g.setColor(Color.black);
	    if (this.DRAW_3D_BORDER) {
	      this.g.drawRect(x, y, w, h);
	    }

	    int tr = fill.getRed();
	    int tg = fill.getGreen();
	    int tb = fill.getBlue();

	    if (tr < offset)
	      tr = Math.abs(tr) / 2;
	    else {
	      tr -= offset;
	    }

	    if (tg < offset)
	      tg = Math.abs(tg) / 2;
	    else {
	      tg -= offset;
	    }

	    if (tb < offset)
	      tb = Math.abs(tb) / 2;
	    else {
	      tb -= offset;
	    }

	    Color topc = new Color(tr, tg, tb);
	    this.g.setColor(topc);
	    Polygon top = new Polygon(new int[] { x, x + w / this.RECT_DEPTH_OFFSET, x + w + w / this.RECT_DEPTH_OFFSET, x + w }, 
	      new int[] { y, y - h / this.RECT_DEPTH_OFFSET, y - h / this.RECT_DEPTH_OFFSET, y }, 4);
	    this.g.fillPolygon(top);
	    this.g.setColor(Color.black);
	    if (this.DRAW_3D_BORDER) {
	      this.g.drawPolygon(top);
	    }

	    int sr = topc.getRed();
	    int sg = topc.getGreen();
	    int sb = topc.getBlue();

	    if (sr < offset)
	      sr = Math.abs(sr);
	    else {
	      sr -= offset;
	    }

	    if (sg < offset)
	      sg = Math.abs(sg);
	    else {
	      sg -= offset;
	    }

	    if (sb < offset)
	      sb = Math.abs(sb);
	    else {
	      sb -= offset;
	    }

	    Color sidec = new Color(sr, sg, sb);
	    this.g.setColor(sidec);
	    Polygon side = new Polygon(new int[] { x + w, x + w + w / this.RECT_DEPTH_OFFSET, x + w + w / this.RECT_DEPTH_OFFSET, x + w }, 
	      new int[] { y, y - h / this.RECT_DEPTH_OFFSET, y + h - h / this.RECT_DEPTH_OFFSET, y + h }, 4);
	    this.g.fillPolygon(side);
	    this.g.setColor(Color.black);
	    if (this.DRAW_3D_BORDER)
	      this.g.drawPolygon(side);
	    
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	  }

	  public void drawTriangle(int x, int y, int b, int h)
	  {
	    int[] n = { x, x + b / 2, x + b };
	    int[] m = { y, y - h, y };
	    Polygon p = new Polygon(n, m, 3);
	    this.g.drawPolygon(p);
	    
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	  }

	  public void drawTriangle(int a, int b, int c, int d, int e, int f) {
	    int[] x = { a, c, e };
	    int[] y = { b, d, f };
	    Polygon p = new Polygon(x, y, 3);
	    this.g.drawPolygon(p);
	    
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	  }

	  public void fillTriangle(int a, int b, int c, int d, int e, int f) {
	    int[] x = { a, c, e };
	    int[] y = { b, d, f };
	    Polygon p = new Polygon(x, y, 3);
	    this.g.fillPolygon(p);
	    
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	  }

	  public void fillTriangle(int x, int y, int b, int h) {
	    int[] n = { x, x + b / 2, x + b };
	    int[] m = { y, y - h, y };
	    Polygon p = new Polygon(n, m, 3);
	    this.g.fillPolygon(p);
	    
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	  }

	  public void fillCylinder(int x, int y, int w, int h) {
	    Color fill = this.g.getColor();

	    int tr = fill.getRed();
	    int tg = fill.getGreen();
	    int tb = fill.getBlue();

	    if (tr < this.OVERALL_SHADOW_OFFSET)
	      tr = 0;
	    else {
	      tr -= this.OVERALL_SHADOW_OFFSET;
	    }
	    if (tg < this.OVERALL_SHADOW_OFFSET)
	      tg = 0;
	    else {
	      tg -= this.OVERALL_SHADOW_OFFSET;
	    }
	    if (tb < this.OVERALL_SHADOW_OFFSET)
	      tb = 0;
	    else {
	      tb -= this.OVERALL_SHADOW_OFFSET;
	    }

	    this.g.setColor(fill);
	    this.g.fillRect(x, y + h / 10, w, h - h / 5);
	    this.g.fillOval(x, y + h - h / 5, w, h / 5);
	    this.g.setColor(new Color(tr, tg, tb));
	    this.g.fillOval(x, y, w, h / 5);
	    this.g.setColor(Color.black);
	    if (this.DRAW_3D_BORDER) {
	      this.g.drawOval(x, y, w, h / 5);
	      this.g.drawLine(x, y + h / 10, x, y + h - h / 10);
	      this.g.drawLine(x + w, y + h / 10, x + w, y + h - h / 10);
	      this.g.drawOval(x, y + h - h / 5, w, h / 5);
	    }
	    this.g.setColor(fill);
	    this.g.fillOval(x, y + h - h / 5 - 1, w, h / 5);
	  }

	  public void fillCylinder(int x, int y, int w, int h, int offset) {
	    Color fill = this.g.getColor();

	    int tr = fill.getRed();
	    int tg = fill.getGreen();
	    int tb = fill.getBlue();

	    if (tr < offset)
	      tr = 0;
	    else {
	      tr -= offset;
	    }
	    if (tg < offset)
	      tg = 0;
	    else {
	      tg -= offset;
	    }
	    if (tb < offset)
	      tb = 0;
	    else {
	      tb -= offset;
	    }

	    this.g.setColor(fill);
	    this.g.fillRect(x, y + h / 10, w, h - h / 5);
	    this.g.fillOval(x, y + h - h / 5, w, h / 5);
	    this.g.setColor(new Color(tr, tg, tb));
	    this.g.fillOval(x, y, w, h / 5);
	    this.g.setColor(Color.black);
	    if (this.DRAW_3D_BORDER) {
	      this.g.drawOval(x, y, w, h / 5);
	      this.g.drawLine(x, y + h / 10, x, y + h - h / 10);
	      this.g.drawLine(x + w, y + h / 10, x + w, y + h - h / 10);
	      this.g.drawOval(x, y + h - h / 5, w, h / 5);
	    }
	    this.g.setColor(fill);
	    this.g.fillOval(x, y + h - h / 5 - 1, w, h / 5);
	  }

	  public void drawCylinder(int x, int y, int w, int h) {
	    this.g.drawOval(x, y, w, h / 5);
	    this.g.drawLine(x, y + h / 10, x, y + h - h / 10);
	    this.g.drawLine(x + w, y + h / 10, x + w, y + h - h / 10);
	    this.g.drawOval(x, y + h - h / 5, w, h / 5);
	  }

	  public void fillPyramid(int x, int y, int w, int h) {
	    Color fill = this.g.getColor();

	    int tr = fill.getRed();
	    int tg = fill.getGreen();
	    int tb = fill.getBlue();

	    if (tr < this.OVERALL_SHADOW_OFFSET)
	      tr = 0;
	    else {
	      tr -= this.OVERALL_SHADOW_OFFSET;
	    }
	    if (tg < this.OVERALL_SHADOW_OFFSET)
	      tg = 0;
	    else {
	      tg -= this.OVERALL_SHADOW_OFFSET;
	    }
	    if (tb < this.OVERALL_SHADOW_OFFSET)
	      tb = 0;
	    else {
	      tb -= this.OVERALL_SHADOW_OFFSET;
	    }

	    fillTriangle(x, y, w - w / 5, h);
	    this.g.setColor(new Color(tr, tg, tb));
	    fillTriangle(x + w - w / 5, y, x + w / 2 - w / 10, y - h, x + w - w / 10, y - h / 10);
	    this.g.setColor(Color.black);
	    if (this.DRAW_3D_BORDER) {
	      drawTriangle(x, y, w - w / 5, h);
	      drawTriangle(x + w - w / 5, y, x + w / 2 - w / 10, y - h, x + w - w / 10, y - h / 10);
	    } else {
	      int br = fill.getRed();
	      int bg = fill.getGreen();
	      int bb = fill.getBlue();

	      if (br < this.OVERALL_SHADOW_OFFSET)
	        br = 0;
	      else {
	        br -= this.OVERALL_SHADOW_OFFSET;
	      }
	      if (bg < this.OVERALL_SHADOW_OFFSET)
	        bg = 0;
	      else {
	        bg -= this.OVERALL_SHADOW_OFFSET;
	      }
	      if (bb < this.OVERALL_SHADOW_OFFSET)
	        bb = 0;
	      else {
	        bb -= this.OVERALL_SHADOW_OFFSET;
	      }

	      this.g.setColor(new Color(br, bg, bb));
	      drawTriangle(x, y, w - w / 5, h);
	      drawTriangle(x + w - w / 5, y, x + w / 2 - w / 10, y - h, x + w - w / 10, y - h / 10);
	    }
	    this.g.setColor(fill);
	    
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	  }

	  public void fillPyramid(int x, int y, int w, int h, int offset) {
	    Color fill = this.g.getColor();

	    int tr = fill.getRed();
	    int tg = fill.getGreen();
	    int tb = fill.getBlue();

	    if (tr < offset)
	      tr = 0;
	    else {
	      tr -= offset;
	    }
	    if (tg < offset)
	      tg = 0;
	    else {
	      tg -= offset;
	    }
	    if (tb < offset)
	      tb = 0;
	    else {
	      tb -= offset;
	    }

	    fillTriangle(x, y, w - w / 5, h);
	    this.g.setColor(new Color(tr, tg, tb));
	    fillTriangle(x + w - w / 5, y, x + w / 2 - w / 10, y - h, x + w - w / 10, y - h / 10);
	    this.g.setColor(Color.black);
	    if (this.DRAW_3D_BORDER) {
	      drawTriangle(x, y, w - w / 5, h);
	      drawTriangle(x + w - w / 5, y, x + w / 2 - w / 10, y - h, x + w - w / 10, y - h / 10);
	    }
	    this.g.setColor(fill);
	    
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	  }

	  public void drawPyramid(int x, int y, int w, int h) {
	    drawTriangle(x, y, w - w / 5, h);
	    drawTriangle(x + w - w / 5, y, x + w / 2 - w / 10, y - h, x + w - w / 10, y - h / 10);
	    
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
	    Vector2.verteces.add(null);
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
		Vector2.verteces.add(null);
		Vector2.verteces.add(null);
	}

	@Override
	public void fillRect(int x, int y, int width, int height) {
		g.fillRect(x, y, width, height);
		Vector2.verteces.add(null);
		Vector2.verteces.add(null);
		Vector2.verteces.add(null);
		Vector2.verteces.add(null);
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
		for (int i = 0; i < nPoints; i++) {
			Vector2.verteces.add(null);
		}
	}

	@Override
	public void fillPolygon(int[] xPoints, int[] yPoints, int nPoints) {
		g.fillPolygon(xPoints, yPoints, nPoints);
		for (int i = 0; i < nPoints; i++) {
			Vector2.verteces.add(null);
		}
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
