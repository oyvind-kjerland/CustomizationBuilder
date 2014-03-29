package node;

import java.awt.Dimension;
import java.awt.Point;

public abstract class VisibleNode extends AbstractNode {

	protected Point position;
	
	protected Dimension size;
	
	
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
}
