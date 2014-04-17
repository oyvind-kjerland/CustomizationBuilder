package node;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public abstract class VisibleNode extends AbstractNode {

	protected Point position = new Point(0, 0);
	
	protected Dimension size = new Dimension(0, 0);
	
	protected Color color;
	
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	public void setPosition(int x, int y) {
		this.position.x = x;
		this.position.y = y;
	}
	
	public Dimension getSize() {
		return size;
	}
	public void setSize(Dimension size) {
		this.size = size;
	}
	public void setSize(int width, int height) {
		this.size.width = width;
		this.size.height = height;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
}
