package node;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

public abstract class VisibleNode extends AbstractNode {

	protected Point position;
	
	protected Dimension size;
	
	protected Color color;
	
	public Point getPosition() {
		return position;
	}
	public void setPosition(Point position) {
		this.position = position;
	}
	
	public Dimension getSize() {
		return size;
	}
	public void setSize(Dimension size) {
		this.size = size;
	}
	
	public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
	
}
